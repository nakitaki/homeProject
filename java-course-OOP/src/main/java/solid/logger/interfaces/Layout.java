package solid.logger.interfaces;

import solid.logger.enums.ReportLevel;

public interface Layout {
    String format(String time, String message, ReportLevel reportLevel);
}
