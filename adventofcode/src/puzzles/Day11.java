package puzzles;

public class Day11 {
	static final char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	String input = "vzbxkghb";

	public static void run() {
		String shifted = shift("zebra");
		System.out.println(shifted);
	}

	static String shift(String s) {
		char[] parts = s.toCharArray();
		for (int i = 0; i < parts.length; i++) {
			char curr = parts[parts.length - 1 - i]; // extract for easier use
			if (curr == 'z') { // wrap around
				curr = 'a';
			} else { // get next letter a->b
				int index = findAlphabetIndex(curr);
				curr = alphabet[index + 1];
			}
			// insert in parts again
			parts[parts.length - 1 - i] = curr;
		}
		return String.valueOf(parts);
	}

	static int findAlphabetIndex(char search) {
		for (int i = 0; i < alphabet.length; i++)
			if (alphabet[i] == search)
				return i;
		System.out.println("index not found: '" + search + "'");
		return -1;
	}
}
