package puzzles;

import java.util.ArrayList;

import util.FileRead;

public class Day7 {
	
	public static ArrayList<var> vars = new ArrayList<var>();
	
	public static void run() {
		String content = FileRead.read("src/input_data/day7_input.txt");
		String[] lines = content.split("\r\n"); //split at newline; every line becomes gets its own place in the array
		for (String line : lines) {
			System.out.println(parseLine(line));
		}
	}

	public static int getIndexByName(String search) {
		for (int i = 0; i < vars.size(); i++)
			if (vars.get(i).getName().equals(search))
				return i;
		return -1;
	}
	public static String parseLine(String line) {
		return null;
	}
}

class var {
	private String name;
	private int value;
	public var(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public var shiftBitAnd(int shift) {
		int shiftVal = this.getValue() & shift;
		return new var(this.name, shiftVal);
	}
	
	public var shiftBitOr(int shift) {
		int shiftVal = this.getValue() | shift;
		return new var(this.name, shiftVal);
	}
	
	public var shiftBitLeft(int shift) {
		int shiftVal = this.getValue() << shift;
		return new var(this.name, shiftVal);
	}
	
	public var shiftBitRight(int shift) {
		int shiftVal = this.getValue() >> shift;
		return new var(this.name, shiftVal);
	}
	
	public String getName() {
		return this.name;
	}
	public int getValue() {
		return this.value;
	}
	@Override
	public String toString() {
		return this.name + ": " + this.value;
	}
}