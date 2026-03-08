package com.example.reports;

/**
 * TODO (student):
 * Implement Proxy responsibilities here:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private RealReport realReport = null;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("[proxy] ACCESS DENIED: " + user.getName()
                    + " (" + user.getRole() + ") cannot access report "
                    + reportId + " [" + classification + "]");
            return;
        }

        if (realReport == null) {
            System.out.println("[proxy] lazy-loading report " + reportId + " for the first time...");
            realReport = new RealReport(reportId, title, classification);
        } else {
            System.out.println("[proxy] reusing cached report " + reportId);
        }

        realReport.display(user);
    }
}
