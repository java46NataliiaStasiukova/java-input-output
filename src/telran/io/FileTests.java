package telran.io;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
class FileTests {
	File file;
	@BeforeEach
	void setUp() {
		file = new File("dir1");
		file.delete();
		new File("file1.txt").delete();
	}

	@Test
	void newDirectoryTest() {
		
		assertFalse(file.exists());
		file.mkdirs();
		assertTrue(file.exists());
	}
	@Test
	void printDirectoryContent() throws Exception {
		printDirectory("..", -1, 1);
	}
	/**
	 * 
	 * @param pathName - name of path to initial directory
	 * @param level - level of sub-directories printing
	 * example, level = 1 printing only first level of the initial directory content
	 *          level = 2 content + sub-directories content
	 *          ''''''''
	 *          level = -1 printing all levels
	 * @throws Exception 
	 */
	private void printDirectory(String pathName, int level, int indent) throws Exception {
		if(level == 0) {
			return;
		}
		
		File filePath = new File(pathName);
		if(!filePath.exists() || !filePath.isDirectory()) {
			throw new Exception(pathName + " is not directory");
		}
		File files[] = filePath.listFiles(); 
		String fileOrFolder = "Directory";
		for(File f: files) {
			if(f.isFile()) {
				fileOrFolder = "File";
		    }
			System.out.printf("%s%s%s%s%s\n", " ".repeat(indent), "<", f.getName(), "> type = ", fileOrFolder);	
			if(f.isDirectory()) {		
				printDirectory(f.getPath(), level - 1, indent + 4);		
			}
		}
		
		/*
		   <dir> type=dir
		       <dir> type=dir
		           <file> type=file
		           <dir> type=dir
		              ...
		 */
		
	}
	
	@Test
	//to write + to read
	void printStreamTest() throws IOException {
		try(PrintStream printStream = new PrintStream("file1.txt");
				BufferedReader reader = new BufferedReader(new FileReader("file1.txt"));){
			printStream.println("Hello");
			assertEquals("Hello", reader.readLine());
		}
	}
	@Test
	//to write; to read later or in another application //writing to buffer
	void printWriterTest() throws IOException {
		try(PrintWriter printWriter = new PrintWriter("file1.txt");
				BufferedReader reader = new BufferedReader(new FileReader("file1.txt"));){
			printWriter.println("Hello");
			printWriter.flush();//reading all buffer
			assertEquals("Hello", reader.readLine());
		}
	}


}