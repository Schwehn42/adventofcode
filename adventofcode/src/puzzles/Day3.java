package puzzles;

import util.FileRead;

public class Day3 {
	public static void run() {
		String content = FileRead.read("src/input_data/day3_input.txt");
		char[] parts = content.toCharArray();
		System.out.println(parts.length);
		
	}
}
