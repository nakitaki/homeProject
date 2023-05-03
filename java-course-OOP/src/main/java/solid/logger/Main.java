package solid.logger;

import solid.logger.impl.appenders.ConsoleAppender;
import solid.logger.impl.appenders.FileAppender;
import solid.logger.impl.MessageLogger;
import solid.logger.impl.SimpleLayout;
import solid.logger.impl.appenders.LogFile;
import solid.logger.interfaces.Appender;
import solid.logger.interfaces.File;
import solid.logger.interfaces.Layout;
import solid.logger.interfaces.Logger;


public class Main {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered");

    }
}
