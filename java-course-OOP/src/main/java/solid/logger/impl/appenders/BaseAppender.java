package solid.logger.impl.appenders;

import solid.logger.enums.ReportLevel;
import solid.logger.interfaces.Appender;
import solid.logger.interfaces.Layout;

public abstract class BaseAppender implements Appender {
    private static final ReportLevel DEFAULT_REPORT_LEVEL_INFO = ReportLevel.INFO;
    Layout layout;
    private ReportLevel reportLevel;
    private int messagesCount;

    public BaseAppender(Layout layout) {
        this(layout, DEFAULT_REPORT_LEVEL_INFO);
    }

    public BaseAppender(Layout layout, ReportLevel reportLevel) {
        this.layout = layout;
        this.reportLevel = reportLevel;
        this.messagesCount = 0;
    }

    public boolean canAppend(ReportLevel reportLevel) {
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    public Layout getLayout() {
        return layout;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public void increaseMessageCount() {
        this.messagesCount++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d"
                , this.getClass().getSimpleName(), this.layout.getClass().getSimpleName(), this.reportLevel, messagesCount);
    }
}
