package solid.logger.impl;

import solid.logger.enums.ReportLevel;
import solid.logger.interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", time, reportLevel, message);
    }
}
