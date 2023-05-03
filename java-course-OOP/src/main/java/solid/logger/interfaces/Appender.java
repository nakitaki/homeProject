package solid.logger.interfaces;

import solid.logger.enums.ReportLevel;

public interface Appender {
    void append(String time, String message, ReportLevel reportLevel);
}
