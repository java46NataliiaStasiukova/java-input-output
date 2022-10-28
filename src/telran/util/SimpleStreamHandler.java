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
		stream.printf("%s%s%s%s\n", localDateTime, loggerRecord.level, loggerRecord.loggerName, loggerRecord.message);
	}
}
