public class SizeLimitedExporter extends Exporter {
    private final Exporter delegate;
    private final int maxLength;
    private final String errorMessage;

    public SizeLimitedExporter(Exporter delegate, int maxLength, String errorMessage) {
        this.delegate = delegate;
        this.maxLength = maxLength;
        this.errorMessage = errorMessage;
    }

    @Override
    public ExportResult doExport(ExportRequest req) {
        if (req.body != null && req.body.length() > maxLength) {
            throw new IllegalArgumentException(errorMessage);
        }
        return delegate.export(req);
    }
}