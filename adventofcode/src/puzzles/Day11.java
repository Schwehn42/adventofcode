package puzzles;

public class Day11 {
	static final char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	static String input = "vzbxkghb";

	public static void run() {
		
	}

	static String shift(String s) {
		char[] parts = s.toCharArray();
		for (int i = 0; i < parts.length; i++) {
			char curr = parts[parts.length - 1 - i]; // extract for easier use
			char newChar = getNextChar(curr);
			// insert in parts again
			parts[parts.length - 1 - i] = newChar;
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

	static char getNextChar(char c) {
		if (c == 'z') { // wrap around
			c = 'a';
		} else { // get next letter a->b
			int index = findAlphabetIndex(c);
			c = alphabet[index + 1];
		}
		return c;
	}

	static boolean validate(String s) {
		boolean valid1 = false, valid2 = true, valid3 = false;
		char[] parts = s.toCharArray();
		// validate 1: has to contain abc or fgh etc.
		System.out.println(String.valueOf(parts));
		for (int i = 0; i < parts.length - 2; i++) {
			char curr = parts[i];
			char curr1 = parts[i + 1]; // curr + 1
			char curr2 = parts[i + 2]; // curr + 2
			if (getNextChar(curr) == curr1 && getNextChar(curr1) == curr2) {
				valid1 = true;
				break;
			}
		}

		// validate 2: pw may not contain i, o or l
		for (char c : parts)
			if (c == 'i' || c == 'o' || c == 'l')
				valid2 = false;

		// validate 3:
		char validChar1 = 0;
		for (int i = 0; i < parts.length - 1; i++) {
			if (parts[i] == parts[i + 1])
				validChar1 = parts[i];

		}
		for (int j = 0; j < parts.length - 1; j++) { // same thing again, but this time exlude validChar
			if (parts[j] == parts[j + 1] && parts[j] != validChar1) // found a second different pair
				valid3 = true;
		}

		System.out.println("Validation: " + valid1 + ", " + valid2 + " and " + valid3);
		return valid1 && valid2 && valid3; // all three have to be true;
	}
}
