package chapter1;

//Import SLF4J classes.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;

public class MyAppWithConfigFile {
	
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(MyAppWithConfigFile.class);
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(lc);
		configurator.doConfigure(args[0]);

		logger.info("Entering application.");
		Bar bar = new Bar();
		bar.doIt();
		logger.info("Exiting application.");
	
		StatusPrinter.print(lc.getStatusManager());
	}
}
