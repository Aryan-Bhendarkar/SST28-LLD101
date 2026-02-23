public class Demo05 {
    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());
        Exporter pdf = new PdfExporter();
        Exporter csv = new CsvExporter();
        Exporter json = new JsonExporter();

        System.out.println("PDF: " + describe(pdf, req));
        System.out.println("CSV: " + describe(csv, req));
        System.out.println("JSON: " + describe(json, req));
    }

    private static String describe(Exporter exporter, ExportRequest req) {
        ExportResult result = exporter.export(req);
        if (result.isError()) {
            return "ERROR: " + result.error;
        }
        return "OK bytes=" + result.bytes.length;
    }
}
