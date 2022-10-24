package telran.util;
import java.io.*;
import java.time.*;
public class SimpleStreamHandler implements Handler{

	PrintStream stream;
	
	public SimpleStreamHandler(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void publish(LoggerRecord loggerRecord) {
		LocalDateTime.now();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(loggerRecord.timestamp, ZoneId.of(loggerRecord.zoneId));
		stream.println(localDateTime);
		stream.println(loggerRecord.level);
		stream.println(loggerRecord.loggerName);
		stream.println(loggerRecord.message);
	}
}
