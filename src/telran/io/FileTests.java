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

	}

	@Test
	void newDirectoryTest() {
		
		assertFalse(file.exists());
		file.mkdirs();
		assertTrue(file.exists());
	}
	@Test
	void printDirectoryContent() throws IOException {
		createFiles();
		printDirectory("testFolder", -1, 1);
	}
	/**
	 * 
	 * @param pathName - name of path to initial directory
	 * @param level - level of sub-directories printing
	 * example, level = 1 printing only first level of the initial directory content
	 *          level = 2 content + sub-directories content
	 *          ''''''''
	 *          level = -1 printing all levels
	 */
	private void printDirectory(String pathName, int level, int indent) {
		if(level == 0) {
			return;
		}
		File filePath = new File(pathName);
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
	private void createFiles() throws IOException {	
		File[] arrayDirs = {
				new File("testFolder"),
				new File("testFolder/f1"),
				new File("testFolder/f2/f5/f6"),
				new File("testFolder/f3/f4")
		};
		File[] arrayFiles = {	
				new File("testFolder/f1", "t1.txt"),
				new File("testFolder/f2", "t2.txt"),
				new File("testFolder/f2/f5", "t3.txt"),
				new File("testFolder/f2/f5", "t4.txt"),
				new File("testFolder/f2/f5/f6", "t5.txt")		
		};
		
		for(File file: arrayDirs) {
			file.mkdirs();
		}
		for(File file: arrayFiles) {
			file.createNewFile();
		}

	}


}