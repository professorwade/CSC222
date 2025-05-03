import java.util.Scanner;

// Lynchburg, VA lat, long (37.414349, -79.143204)
public class Main {
    public static void main(String[] args)  {
        ForecastRetriever fr = new ForecastRetriever();
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter forecast location latitude (0 to quit): ");
            double lat = s.nextDouble();
            while (lat != 0) {
                System.out.print("Enter forecast location longitude: ");
                double lng = s.nextDouble();
                String url = "https://api.weather.gov/points/" + lat+ "," + lng;
                String resp = fr.getForecast(url);
                System.out.println(resp);
                Printable printable = fr; // a way to restrict access
                PdfGenerator pw = new PdfGenerator();
                pw.createPdf(printable.getFileName(), printable.getText());
                System.out.print("Enter forecast location latitude (0 to quit): ");
                lat = s.nextDouble();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}