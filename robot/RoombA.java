package robot;

import kareltherobot.*;

public class RoombA implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		roomba.move();
		boolean keep_driving_lovely_garbage_bot = true;
		
		while (keep_driving_lovely_garbage_bot) {
			boolean i_am_next_to_beeper = roomba.nextToABeeper();
			if (roomba.frontIsClear()) {
				if (i_am_next_to_beeper) {
					roomba.pickBeeper();
				}
			} else if (i_am_next_to_beeper){
				roomba.pickBeeper();
				roomba.move();
			} else {
				//i am next to a wall
				if (roomba.facingWest()) {
					roomba.turnLeft();
					if (roomba.nextToABeeper()){
						roomba.pickBeeper();
					}
					roomba.move();
				} else {
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();
					if (roomba.nextToABeeper()){
						roomba.pickBeeper();
					}
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();
				}
				
				
				roomba.turnLeft();
				
			}

			
			
			
		}

		int totalBeepers = 0; // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
		
		roomba.move();

	}
}