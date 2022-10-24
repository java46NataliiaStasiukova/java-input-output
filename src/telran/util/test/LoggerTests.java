package telran.util.test;
import java.io.*;
import telran.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoggerTests {
	PrintStream stream;
	SimpleStreamHandler handler;
	Logger logger;
//	File file;
	@BeforeEach
	void setUp() throws IOException {
		//TODO
//		file = new File("testFile.txt");
//		file.createNewFile();
//		file.delete();
		new File("test.txt").delete();
		stream = new PrintStream("test.txt");
		handler = new SimpleStreamHandler(stream);
		logger = new Logger(handler, "Logger Test");
		
	}
	@Test
	void testTest() throws IOException {
//		stream = new PrintStream("test.txt");
//		SimpleStreamHandler handler = new SimpleStreamHandler(stream);
//		Logger logger = new Logger(handler, "Test logger1");
//		logger.error("New error message!");		
//		stream.close();
	}
	@Test
	void errorTest() {
		logger.error("New error message!");	
		stream.close();
	}

}