/**
 * @author Jakob Schwehn
 * @date 2015-12-07
 * @github https://github.com/schwehn42
 * Exercice as of http://adventofcode.com/day/6
 */

package puzzles;

import util.FileRead;

public class Day6 {
	private static final String INSTRUCTION_ON = "ON";
	private static final String INSTRUCTION_OFF = "OFF";
	private static final String INSTRUCTION_TOGGLE = "TOGGLE";
	
	public static Lamp[][] grid = new Lamp[1000][1000];
	
	public static void run() {
		String content = FileRead.read("src/input_data/day6_input.txt");
		String[] lines = content.split("\n"); //split at newline; every line becomes gets its own place in the array
		
		for (int i = 0; i < 1000; i++) //instantiate every lamp
			for (int j = 0; j < 1000; j++)
				grid[i][j] = new Lamp(i, j);
		
		printGrid(0, 0, 10, 10);
		System.out.println(countLampsOn());
		turnOn(3, 3, 6, 6);
		printGrid(0, 0, 10, 10);
		System.out.println(countLampsOn());
		toggle(0, 0, 10, 10);
		printGrid(0, 0, 10, 10);
		System.out.println(countLampsOn());
		turnOff(0, 0, 10, 10);
		
		
		/*for (String line : lines) {
			Instruction lineInfo = parseLine(line);
			System.out.print(lineInfo);
			if (lineInfo.order.equals(INSTRUCTION_ON)) {
				turnOn(lineInfo.startX, lineInfo.startY, lineInfo.endX, lineInfo.endY);
			}
			else if (lineInfo.order.equals(INSTRUCTION_OFF)) {
				turnOff(lineInfo.startX, lineInfo.startY, lineInfo.endX, lineInfo.endY);
			}
			else if (lineInfo.order.equals(INSTRUCTION_TOGGLE)) {
				toggle(lineInfo.startX, lineInfo.startY, lineInfo.endX, lineInfo.endY);
			}
			System.out.println(" --> " + countLampsOn());
		}*/
		
		//printGrid(0, 0, 100, 100);
		
		
		
		
	}
	
	static int countLampsOn() {
		int totalLampsOn = 0;
		for (int i = 0; i < 1000; i++) //instantiate every lamp
			for (int j = 0; j < 1000; j++)
				if (grid[i][j].getStatus())
					totalLampsOn++;
		
		return totalLampsOn;
	}
	
	static void turnOn(int startX, int startY, int endX, int endY) {
		for (int y = startY; y <= endY; y++) {
			for (int x = startX; x <= endX; x++) {
				grid[x][y].turnOn();
			}
		}
		
	}
	
	static void turnOff(int startX, int startY, int endX, int endY) {
		for (int y = startY; y <= endY; y++) {
			for (int x = startX; x <= endX; x++) {
				grid[x][y].turnOff();
			}
		}
		
	}
	
	static void toggle(int startX, int startY, int endX, int endY) {
		for (int y = startY; y <= endY; y++) {
			for (int x = startX; x <= endX; x++) {
				grid[x][y].toggle();
			}
		}
		
	}
	
	static void printGrid(int startX, int startY, int endX, int endY) {
		for (int y = startY; y < endY; y++) {
			for (int x = startX; x < endX; x++) {
				System.out.print(grid[x][y].getStatus() ? "X " : "O ");
				//System.out.print(x + "|" + y + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------");
	}
	
	static Instruction parseLine(String line) {
		String[] parts = line.split(" ");
		String arg1, arg2, arg3;
		if (parts[0].equals("toggle")) { //if it's "turn on" instead of toggle theres one extra space which goes in the array
			arg1 = parts[0].toUpperCase(); //instruction
			arg2 = parts[1]; //x,y of start
			arg3 = parts[3]; //x,y of end
		}
		else {
			arg1 = parts[1].toUpperCase(); //instruction
			arg2 = parts[2]; //x,y of start
			arg3 = parts[4]; //x,y of end
		}
		String[] start = arg2.split(",");
		String[] end = arg3.split(",");
		int startX = Integer.parseInt(start[0]);
		int startY = Integer.parseInt(start[1]);
		int endX = Integer.parseInt(end[0]);
		int endY = Integer.parseInt(end[1]);
		
		return new Instruction(arg1, startX, startY, endX, endY);
		
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
	public int startX, startY;
	public int endX, endY;
	public Instruction(String order, int sX, int sY, int eX, int eY){
		this.order = order;
		this.startX = sX;
		this.endX = eX;
		this.startY = sY;
		this.endY = eY;
	}
	@Override
	public String toString() {
		return order + ": " + startX + "|" + startY + " -> " + endX + "|" + endY;
	}
		
}
