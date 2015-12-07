package puzzles;

import util.FileRead;

public class Day6 {
	private static final String INSTRUCTION_ON = "ON";
	private static final String INSTRUCTION_OFF = "OFF";
	private static final String INSTRUCTION_TOGGLE = "TOGGLE";
	public static void run() {
		String content = FileRead.read("src/input_data/day6_input.txt");
		String[] lines = content.split("\n"); //split at newline; every line becomes gets its own place in the array
		
		Lamp[][] grid = new Lamp[1000][1000];
		for (int i = 0; i < 1000; i++) //instantiate every lamp
			for (int j = 0; j < 1000; j++)
				grid[i][j] = new Lamp(i, j);
		for (String line : lines) {
			System.out.println(parseLine(line));
		}
		
		
	}
	static Instruction parseLine(String line) {
		String[] parts = line.split(" ");
		String arg1, arg2, arg3;
		if (parts[0].equals("toggle")) {
			arg1 = parts[0].toUpperCase(); //turn off ...
			arg2 = parts[1]; //number
			arg3 = parts[3]; //number
		}
		else {
			arg1 = parts[1].toUpperCase(); //turn off ...
			arg2 = parts[2]; //number
			arg3 = parts[4]; //number
		}
		int start = Integer.parseInt(arg2.replace(",", ""));
		int end = Integer.parseInt(arg3.replace(",", ""));
		
		return new Instruction(arg1, start, end);
		
	}
}

class Lamp {
	private boolean status = false;
	private int posX, posY;
	public Lamp(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public void turnOn() {
		this.status = true;
	}
	public void turnOff() {
		this.status = false;
	}
	public void toggle() {
		this.status = !this.status;
	}
	public boolean getStatus() {
		return this.status;
	}
	public int getPosX() {
		return this.posX;
	}
	public int getPosY() {
		return this.posY;
	}
	@Override
	public String toString() {
		return this.status ? "On" : "Off";
	}
}

class Instruction {
	public String order;
	public int start;
	public int end;
	public Instruction(String o, int s, int e){
		this.order = o;
		this.start = s;
		this.end = e;
	}
	@Override
	public String toString() {
		return order + ": " + start + " -> " + end;
	}
		
}
