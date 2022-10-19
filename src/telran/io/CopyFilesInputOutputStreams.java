package telran.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CopyFilesInputOutputStreams {

	public static void main(String[] args) {
		int[] count = {0};
		LocalDateTime start = LocalDateTime.now();
		boolean overwritten = false;
		if (args.length > 2) {
			overwritten = true;
		}
		try {
			if (args.length < 2) {
				throw new Exception("Not enough arguments for copying");
			}
			File source = getSource(args[0]);
			File destination = getDestination(args[1], overwritten);
			copyFiles(source, destination, count);
			LocalDateTime end = LocalDateTime.now();
			System.out.println("Copied <" + count[0] + " bytes> for <running time in milliseconds: " + ChronoUnit.MILLIS.between(start, end) + ">");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@SuppressWarnings("resource")
	private static void copyFiles(File source, File target, int[] count) throws Exception {
		if (source.isDirectory()) {
			if (!target.exists()) {
				target.mkdir();
			}
			String[] children = source.list();
			for (int i = 0; i < children.length; i++) {
				copyFiles(new File(source, children[i]), new File(target, children[i]), count);
			}
		} else {
			InputStream input = new FileInputStream(source);
			OutputStream output;
			try {
				output = new FileOutputStream(target);
			} catch (FileNotFoundException e) {
				throw new Exception("Destination <" + target + "> has non-existed directory in the path.");
			}
			byte[] buffer = new byte[1024];
			int len;
			while ((len = input.read(buffer)) > 0) {
				count[0] += len;
				output.write(buffer, 0, len);
			}
			input.close();
			output.close();
		}
	}

	private static File getDestination(String path, boolean overwritten) throws Exception {
		File file = new File(path);
		if (file.exists() && overwritten == false) {
			throw new Exception("Destination <" + path + "> cannot be overwritten");
		}
		return file;
	}

	private static File getSource(String path) throws Exception {
		File sourceFile = new File(path);
		if (!sourceFile.exists()) {
			throw new Exception("Source file <" + path + "> does not exist");
		}
		return sourceFile;
	}

}