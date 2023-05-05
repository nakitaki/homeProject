package solid.logger.impl.factories;

import solid.logger.enums.ReportLevel;
import solid.logger.impl.appenders.ConsoleAppender;
import solid.logger.impl.appenders.FileAppender;
import solid.logger.interfaces.Appender;
import solid.logger.interfaces.Factory;
import solid.logger.interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {
    private LayoutFactory layoutFactory;

    public AppenderFactory() {
        this.layoutFactory = new LayoutFactory();
    }

    @Override
    public Appender produce(String input) {
        String[] tokens = input.split(" ");

        String appenderType = tokens[0];
        String layoutType = tokens[1];

        Layout layout = layoutFactory.produce(layoutType);
        Appender appender = null;
        if(appenderType.equals("ConsoleAppender")){
            appender = new ConsoleAppender(layout);
        } else if(appenderType.equals("FileAppender")){
            appender = new FileAppender(layout);
        }

        if(tokens.length >= 3){
            appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        }
        return appender;
    }
}
