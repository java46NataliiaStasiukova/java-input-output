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
	public void error(String message) {
	if (level.compareTo(Level.ERROR) <= 0) {
		LoggerRecord loggerRecord = createLoggerRecord(Level.ERROR, message);
		handler.publish(loggerRecord);
	}
	}
	public void warn(String message) {
	if (level.compareTo(Level.WARN) <= 0) {
		LoggerRecord loggerRecord = createLoggerRecord(Level.WARN, message);
		handler.publish(loggerRecord);
		}
	}
	public void info(String message) {
	if (level.compareTo(Level.INFO) <= 0) {
		LoggerRecord loggerRecord = createLoggerRecord(Level.INFO, message);
		handler.publish(loggerRecord);
		}
	}
	public void debug(String message) {
	if (level.compareTo(Level.DEBUG) <= 0) {
		LoggerRecord loggerRecord = createLoggerRecord(Level.DEBUG, message);
		handler.publish(loggerRecord);
		}
	}
	public void trace(String message) {
	if (level.compareTo(Level.TRACE) == 0) {
		LoggerRecord loggerRecord = createLoggerRecord(Level.TRACE, message);
		handler.publish(loggerRecord);
		}
	}
	private LoggerRecord createLoggerRecord(Level level, String message) {
		
		return new LoggerRecord(Instant.now(), "Asia/Jerusalem", level, name, message);
	}
	
	
}