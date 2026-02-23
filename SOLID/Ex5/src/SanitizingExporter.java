public class SanitizingExporter extends Exporter {
    private final Exporter delegate;

    public SanitizingExporter(Exporter delegate) {
        this.delegate = delegate;
    }

    @Override
    public ExportResult doExport(ExportRequest req){
        String safeBody = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");
        ExportRequest safeReq = new ExportRequest(req.title, safeBody);
        return delegate.export(safeReq);
    }
}