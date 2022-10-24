package telran.util;

import java.time.Instant;

public class Logger {

	Level level = Level.INFO;
	Handler handler;
	String name;

	public Logger(Handler handler, String name) {
		this.handler = handler;
		this.name = name;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
//	Method “error” creates LoggerRecord object with level Level.ERROR and 
//	publishes the object for any level value
	public void error(String message) {
		//TODO
		LoggerRecord loggerRecord = new LoggerRecord(Instant.now(), "Asia/Jerusalem", Level.ERROR, name, message);
		handler.publish(loggerRecord);
	}
//	Method “warn” creates LoggerRecord object with level Level.WARN and 
//	publishes the object for any level value, except Level.ERROR
	public void warn(String message) {
		//TODO
		LoggerRecord loggerRecord = new LoggerRecord(Instant.now(), "Asia/Jerusalem", Level.WARN, name, message);
		handler.publish(loggerRecord);
	}
//	Method “info creates LoggerRecord object with level Level.INFO and 
//	publishes the object for level having one out of the following values:
//		Level.TRACE, Level.DEBUG, Level.INFO
	public void info(String message) {
		//TODO
		LoggerRecord loggerRecord = new LoggerRecord(Instant.now(), "Asia/Jerusalem", Level.INFO, name, message);
		handler.publish(loggerRecord);
	}
//	Method “debug” creates LoggerRecord object with level Level.DEBUG and 
//	publishes the object for level having one out of the following values:
//		Level.TRACE, Level.DEBUG
	public void debug(String message) {
		//TODO
		LoggerRecord loggerRecord = new LoggerRecord(Instant.now(), "Asia/Jerusalem", Level.DEBUG, name, message);
		handler.publish(loggerRecord);
	}
//	Method “trace” creates LoggerRecord object with level Level.TRACE
//	and publishes the object for only Level.TRACE
	public void trace(String message) {
		//TODO
		LoggerRecord loggerRecord = new LoggerRecord(Instant.now(), "Asia/Jerusalem", Level.TRACE, name, message);
		handler.publish(loggerRecord);
	}
	
	
}