package solid.logger;

import solid.logger.enums.ReportLevel;
import solid.logger.impl.appenders.ConsoleAppender;
import solid.logger.impl.appenders.FileAppender;
import solid.logger.impl.MessageLogger;
import solid.logger.impl.factories.LoggerFactory;
import solid.logger.impl.layouts.SimpleLayout;
import solid.logger.impl.appenders.LogFile;
import solid.logger.interfaces.Appender;
import solid.logger.interfaces.File;
import solid.logger.interfaces.Layout;
import solid.logger.interfaces.Logger;
import solid.logger.impl.layouts.XmlLayout;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        {
//            //console and file appender
//            System.out.println("test 1");
//            Layout simpleLayout = new SimpleLayout();
//            Appender consoleAppender = new ConsoleAppender(simpleLayout);
//
//            File file = new LogFile();
//            Appender fileAppender = new FileAppender(simpleLayout);
//            ((FileAppender) fileAppender).setFile(file);
//
//            Logger logger = new MessageLogger(consoleAppender, fileAppender);
//
//            logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//            logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered");
//            System.out.println();
//        }
//        {
//            //+ xmlLayout
//            System.out.println("test 2");
//            Layout xmlLayout = new XmlLayout();
//            Appender consoleAppender = new ConsoleAppender(xmlLayout);
//            Logger logger = new MessageLogger(consoleAppender);
//
//            logger.logFatal("3/26/2015 2:08:11 PM", "mscorlib.dll does not respond");
//            logger.logCritical("3/26/2015 2:08:11 PM", "No connection string found in App.config");
//
//        }
//        {
//            //only logs after the given ReportLevel
//            System.out.println("test 3");
//            Layout simpleLayout = new SimpleLayout();
//            Appender consoleAppender = new ConsoleAppender(simpleLayout);
//            consoleAppender.setReportLevel(ReportLevel.CRITICAL);
//
//            Logger logger = new MessageLogger(consoleAppender);
//
//            logger.logInfo ("3/31/2015 5:33:07 PM", "Everything seems fine");
//            logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high disconnect imminent");
//            logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
//            logger.logCritical ("3/31/2015 5:33:07 PM", "No connection string found in App.config");
//            logger.logFatal ("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");
//
//            System.out.println(logger);
//        }
        {
            System.out.println("input/output");
            InputParser inputParser = new InputParser();
            Scanner scanner = new Scanner(System.in);
            LoggerFactory loggerFactory = new LoggerFactory();

            Logger logger = loggerFactory.produce(inputParser.readLoggerInfo(scanner));

            String input = scanner.nextLine();

            while(!"END".equals(input)){
                String[] tokens = input.split("\\|");

                ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
                String time = tokens[1];
                String message = tokens[2];

                switch(reportLevel){
                    case INFO: logger.logInfo(time,message); break;
                    case WARNING: logger.logWarning(time,message); break;
                    case ERROR: logger.logError(time,message); break;
                    case CRITICAL: logger.logCritical(time,message); break;
                    case FATAL: logger.logFatal(time,message); break;
                }
                input = scanner.nextLine();
            }


            System.out.println(logger);

//            input{
//                2
//                ConsoleAppender SimpleLayout CRITICAL
//                FileAppender XmlLayout
//                INFO|3/26/2015 2:08:11 PM|Everything seems fine
//                WARNING|3/26/2015 2:22:10 PM|Warning: ping is too high - disconnect imminent
//                ERROR|3/26/2015 2:32:44 PM|Error parsing request
//                CRITICAL|3/26/1025 2:38:01|No connestion string found in App.config
//                FATAL|3/26/2015 2:39:23|mxcorlib.dll does not open
//                END
//            }


        }
    }
}
