package solid.logger.impl;

import solid.logger.enums.ReportLevel;
import solid.logger.interfaces.Appender;
import solid.logger.interfaces.Logger;

import java.util.Arrays;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appender) { //one or more appenders
        this.appenders = appender;
    }

    @Override
    public void logInfo(String time, String message) {
        log(time,message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String time, String message) {
        log(time,message, ReportLevel.WARNING);
    }

    @Override
    public void logError(String time, String message) {
        log(time,message, ReportLevel.ERROR);
    }

    @Override
    public void logCritical(String time, String message) {
        log(time,message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String time, String message) {
        log(time,message, ReportLevel.FATAL);
    }

    private void log(String time, String message, ReportLevel reportLevel){
        //        for(Appender appender: appenders){
//            appender.append(time,message,reportLevel);
//        } //the same as the bottom line
        Arrays.stream(appenders).forEach(appender -> appender.append(time, message, reportLevel));
    }
}
