import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ForecastRetriever implements Printable
{
    private String lastForecast;

    public String getForecast(String url) throws IOException, InterruptedException, JSONException {
        String resp = getQuery(url);
        JSONObject jsonObject = new JSONObject(resp);
        StringBuilder sb = new StringBuilder();
        JSONObject properties = jsonObject.getJSONObject("properties")
                .getJSONObject("relativeLocation").getJSONObject("properties");
        sb.append("Forecast for: ").append(properties.getString("city")).append(", ")
                .append(properties.getString("state")).append("\n\n");
        properties = jsonObject.getJSONObject("properties"); // back up tree
        String forecastURL = properties.getString("forecast");
        resp = getQuery(forecastURL);
        jsonObject = new JSONObject(resp).getJSONObject("properties");
        JSONArray periods = jsonObject.getJSONArray("periods");
        for (int i = 0; i < periods.length(); i++) {
            JSONObject obj = periods.getJSONObject(i);
            sb.append(obj.getString("name")).append(" : ")
                    .append(obj.getString("shortForecast")).append("\n");
        }
        lastForecast = sb.toString();
        return sb.toString();
    }

    private String getQuery(String url) throws IOException, InterruptedException {
        // Create an HttpClient
        HttpResponse<String> response;
        HttpClient client = HttpClient.newHttpClient();

        // Build the HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) // Replace with your URL
                .GET() // or .POST(), .PUT(), .DELETE() as needed
                .build();

        // Send the request and get the response
        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    /**
     * Implements the Printable interface to return the text of the last forecast looked up
     * @return String of text to be printed
     */
    @Override
    public String getText() {
        return lastForecast; // returns the text of the last forecast looked up
    }

    /**
     * Implements the Printable interface to return a suitable filename for the file to be saved as
     * @return string of filename
     */
    @Override
    public String getFileName() {
        String[] lines = lastForecast.split("\n");
        String fileName = lines[0].split(":")[1].strip();
        fileName = fileName.replaceAll(",","") + " Forecast.pdf";
        return fileName;
    }
}
