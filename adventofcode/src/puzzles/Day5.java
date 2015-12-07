/**
 * @author Jakob Schwehn
 * @date 2015-12-07
 * @github https://github.com/schwehn42
 * Exercice as of http://adventofcode.com/day/5
 */

package puzzles;

import util.FileRead;

public class Day5 {
	public static void run() {
		String content = FileRead.read("src/input_data/day5_input.txt");
		int niceStrings = 0;
		String[] lines = content.split("\n"); //split at newline; every line becomes gets its own place in the array
		System.out.println("lines: " + lines.length);
		for (String line : lines) {
			System.out.print(line + " ");
			/*System.out.print((validateVowels(line) ? "T " : "F "));
			System.out.print((validateDouble(line) ? "T " : "F "));
			System.out.print((validateForbidden(line) ? "T " : "F "));*/
			if (validateForbidden(line) && validateVowels(line) && validateDouble(line)) {
				System.out.print("NICE");
				niceStrings++;
			}
			else {
				System.out.print("NAUGHTY");
			}
			System.out.println();
		}
		System.out.println(niceStrings);
		validateDoubleDebug("bvggvrdgjcspkkyj");
	}
	
	static boolean validateVowels(String line) {
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		char[] parts = line.toCharArray();
		byte containing = 0; //needs to be 3 or more to return true
		System.out.print("[");
		for (char c : parts) {
			for (char v : vowels) {
				if (c == v) {
					containing++;
					break;
				}
			}
		}
		System.out.print("]");
		if (containing >= 3)
			return true;
		return false;
	}
	
	static boolean validateDouble(String line) {
		char[] parts = line.toCharArray();
			for (int i = 0; i < parts.length - 1; i++) {
				if (parts[i] == parts[i+1]) {
					System.out.print("[" + parts[i] + "-" + parts[i+1] + "]");
					return true;
				}
			}
		return false;	
	}
	
	static boolean validateDoubleDebug(String line) {
		char[] parts = line.toCharArray();
			for (int i = 0; i < parts.length - 1; i++) {
				if (parts[i] == parts[i+1]) {
					System.out.print("[" + parts[i] + "-" + parts[i+1] + "]");
					return true;
				}
			}
		return false;	
	}
	
	static boolean validateForbidden(String line) {
		String[] forbidden = {"ab", "cd", "pq", "xy"}; //if line contains one or more of this return false
		for (String f : forbidden) {
			if (line.contains(f)) {
				System.out.print("[forbidden: " + f + "]");
				return false;
			}
		}
		return true;
	}
	
}
