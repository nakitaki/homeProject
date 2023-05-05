package solid.logger.impl.layouts;

import solid.logger.enums.ReportLevel;
import solid.logger.interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format(
                "<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>%n" +
                "</log>%n", time, reportLevel, message);
    }
}
