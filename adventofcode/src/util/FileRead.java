package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileRead {
	public static String read(String path){
		String content = null;

		try {
			content = new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
}
