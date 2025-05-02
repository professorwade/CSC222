import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class ForecastRetriever implements Printable
{
    private String lastForecast;

    public String getForecast(String url) throws IOException, InterruptedException, JSONException {
        String resp = getQuery(url);
        JSONObject jsonObject = new JSONObject(resp);
        StringBuilder sb = new StringBuilder();
        JSONObject properties = jsonObject.getJSONObject("properties")
                .getJSONObject("relativeLocation").getJSONObject("properties");
        sb.append("Forecast for: " + properties.getString("city") +
                ", " + properties.getString("state") + "\n\n");
        properties = jsonObject.getJSONObject("properties"); // back up tree
        String forecastURL = properties.getString("forecast");
        resp = getQuery(forecastURL);
        jsonObject = new JSONObject(resp).getJSONObject("properties");
        JSONArray periods = jsonObject.getJSONArray("periods");
        for (int i = 0; i < periods.length(); i++) {
            JSONObject jobj = periods.getJSONObject(i);
            sb.append(jobj.getString("name") + " : " + jobj.getString("shortForecast") + "\n");
        }
        lastForecast = sb.toString();
        return sb.toString();
    }

    private String getQuery(String url) throws IOException, InterruptedException {
        // Create an HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Build the HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) // Replace with your URL
                .GET() // or .POST(), .PUT(), .DELETE() as needed
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        return response.body();
    }

    @Override
    /**
     * Implements the Printable interface to return the text of the last forecast looked up
     */
    public String getText() {
        return lastForecast; // returns the text of the last forecast looked up
    }

    @Override
    /**
     * Implements the Printable interface to return a suitable filename for the file to be saved as
     */
    public String getFileName() {
        String[] lines = lastForecast.split("\n");
        String fileName = lines[0].split(":")[1].strip();
        fileName = fileName.replaceAll(",","") + " Forecast.pdf";
        return fileName;
    }
}
