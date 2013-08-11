package micros;

import java.util.Scanner;

public class Micros {
  
	private static int xpos = 0;
	private static int ypos = 0;
	private static int direction = 0;
	
	private static String[] directions = {"North", "East", "South", "West"};
	private static final int NORTH = 0;
	private static final int EAST = 1;
	private static final int SOUTH = 2;
	private static final int WEST = 3;
	private static final int XMIN = 0;
	private static final int YMIN = 0;
	private static final int XMAX = 4;
	private static final int YMAX = 4;
	
	/**
	 * Turn left of right
	 * @param c direction
	 * @return true if success, false if failure
	 */
	public static boolean turn(char c) {
		
		if (c == 'L') {
			if (direction == NORTH) 
				direction = WEST;
			else 
				direction--;
		}
		else if (c == 'R') {
			if (direction == WEST) {
				direction = NORTH;
			}
			else
				direction++;
		}
		return(true);
	}
	
	/**
	 * Move, currently forwards only. Backwards would probably be a new method
	 * @param c the direction
	 * @return true if success, false if failure
	 */
	public static boolean move(char c) {
		
		if (direction == NORTH && ypos == YMAX) {
			System.out.println("Cannot move North when Y position is " + YMAX);
			return(false);
		}
		if (direction == EAST && xpos == XMAX) {
			System.out.println("Cannot move East when X position is " + YMAX);
			return(false);
		}
		if (direction == SOUTH && ypos == YMIN) {
			System.out.println("Cannot move South when Y position is " + YMIN);
			return(false);
		}
		if (direction == WEST && xpos == XMIN) {
			System.out.println("Cannot move West when X position is " + XMIN);
			return(false);
		}
		
		if (direction == NORTH) ypos++;
		else if (direction == EAST) xpos++;
		else if (direction == SOUTH) ypos--;
		else if (direction == WEST) xpos--;
		
		return(true);
	}
	
	/**
	 * Show the current position
	 */
	public static void displayPosition() {
		
		System.out.println("x = " + xpos + ", y = " + ypos + ", direction = " + directions[direction]);
	}

	/**
	 * Supply commands from the command line.
	 * Commands will be run until an invalid command is encountered,
	 * or until a valid command fails.
	 * Commands are case sensitive
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		java.util.Scanner input = new Scanner( System.in);
     
		while (true) {
			
		    System.out.println("Please Enter your Command: ");             
		    String command = input.nextLine();
		    
		    for (int i = 0; i < command.length(); i++) {
		    	char c = command.charAt(i);
		    	
		    	if (c != 'L' && c != 'R' && c != 'F') {
		    		//Stop if there is an invalid command, 
		    		//do not roll back to starting position
		    		System.out.println("Invalid command");
		    		break;
		    	}
		    	
		    	if (c == 'L' || c =='R') {
		    		//Stop if the command fails, 
		    		//do not roll back to starting position
		    		if (!turn(c))
		    			break;
		    	} else if (c == 'F') {
		    		//Stop if the command fails,
		    		//do not roll back to starting position
		    		if (!move(c))
		    			break;
		    	}
		    }
		    
		    displayPosition();
		}

	}

}
