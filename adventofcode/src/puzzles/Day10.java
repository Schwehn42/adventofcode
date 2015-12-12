package puzzles;

import java.util.ArrayList;
import java.util.List;

public class Day10 {
	static final boolean DEBUG = true;
	 static final String input = "132113112";
	//static final int input = 132113337; // debug value

	public static void run() {
		process(input);
	}

	static String process(String s) {
		String ret = "";
		List<LookNSay> splitList = split(s);
		for (LookNSay lns : splitList) {
			System.out.println(lns.getNumber() + " -> " + lns.getAmount());
			ret += String.valueOf(lns.getAmount()) + String.valueOf(lns.getNumber());
		}
		System.out.println(ret);
		return ret;
	}

	static List<LookNSay> split(String s) {
		/* list because we dont know how large the array has to be */
		List<LookNSay> split = new ArrayList<LookNSay>();

//		String s = String.valueOf(p);
		char[] parts = s.toCharArray();

		int amount = 1;

		try {
			for (int i = 0; i < parts.length; i++) {
				int currIndexInt = Integer.parseInt(String.valueOf(parts[i])); //char to string to int
				//this is required for unknown reasons
				if (i == parts.length - 1) {
					split.add(new LookNSay(currIndexInt, amount));
					amount = 1;
					continue;
				}
				if (parts[i] == parts[i + 1]) {
					amount++;
				} else {
					split.add(new LookNSay(currIndexInt, amount));
					amount = 1;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		return split;
	}
}

class LookNSay {
	private int number;
	private int amount;

	public LookNSay(int number, int amount) {
		this.number = number;
		this.amount = amount;
	}

	public int getNumber() {
		return this.number;
	}

	public int getAmount() {
		return this.amount;
	}
}