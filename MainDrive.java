//meinz015
//the MainDrive is the main method you should run
import java.util.*;
public class MainDrive{
	public static void main(String[] args){
		
		BattleboatsBoard myBoard = null;
		
		System.out.println("Key: \nMiss = 0\nHit Ship = 1\nUnguessed open water(debug only) = 4\nUnguessed ship(debug only) = 5\nObscured unguessed spots = 7\nDrone out of bounds = 2");
		System.out.println("\n\n\nSize of Board (Input as two numbers, no punctuation, x first, y second)");
		
		Scanner inputBoard = new Scanner(System.in);
		int firstCoord = inputBoard.nextInt();
		int secondCoord = inputBoard.nextInt();
		
		firstCoord = (int)firstCoord;
		secondCoord = (int)secondCoord;
		myBoard = new BattleboatsBoard(firstCoord, secondCoord);
		/*
		Before the while loop begins, debug/nondebug is chosen for the entire game
		variables that do not need to be reinstatiated in the while loop are instantiated before the loop
		*/
		System.out.println("Debug Mode? (Yes or No): ");
		Scanner inputDebug = new Scanner(System.in);
		String strDebug = inputDebug.nextLine();
		
		boolean flag = false;//setting flag so that we know when all boats have been hit
		Debug debug = new Debug();
		BattleboatsMoves myMove = new BattleboatsMoves();
		int numTurns = 0;
		int cannonShots = 0;
		
		/*
		while loop for the whole game is initialized
		asks player if they want to use the drone, then asks for guess
		prints out response according to coordinate input and increases cannon and turns
		checks to see if all of locationx is 30. if so, all ships are sunk and game ends. if not, game continues
		when all ships have been sunk, exits while loop and prints out number of turns and number of cannon fires
		*/
		
		Scanner inputDrone = new Scanner(System.in);
		int[] checkArray = myBoard.getLocationx();
		while (flag == false){
			System.out.println("\nWould you like to use a drone? (Yes or No)(Uses 4 turns): ");
			String strDrone = inputDrone.nextLine();
			if (strDrone.equals("Yes")){
				System.out.println("Enter coordinates of drone(Input as two numbers, no punctuation, x first, y second): ");
				Scanner inputDroneCoords = new Scanner(System.in);
				String strDroneCoords = inputDroneCoords.nextLine();
				Scanner droneCoordsScanner = new Scanner(strDroneCoords);
				int x = droneCoordsScanner.nextInt();
				int y = droneCoordsScanner.nextInt();
				Drone newDrone = new Drone();
				System.out.println("Drone's coordinates: ");
				newDrone.drone(myBoard, x, y);
				String droneResult = newDrone.values();
				System.out.println(droneResult);
				if (droneResult.equals("Recon")){
					System.out.println("Since the drone was out of bounds, lose addition 4 turns waiting for it to return.");
					numTurns = numTurns+8;
				}
				else{
					numTurns = numTurns+4;
				}	
			}
			System.out.println("Board: ");
			if (strDebug.equals("No")){
				System.out.println(debug.nonDebug(myBoard));
				
			}
			else if (strDebug.equals("Yes")){
				System.out.println(debug.debug(myBoard));
			}
			
			String result = myMove.moves(myBoard);
			System.out.println(result);
			if (result.equals("Hit!")){
				numTurns = numTurns+1;
				cannonShots = cannonShots+1;
				myMove.hitShips(myBoard);
			}
			else if(result.equals("Miss")){
				numTurns = numTurns+1;
				cannonShots = cannonShots+1;
			}
			else if(result.equals("You already choose this spot. You will be penalized 4 turns.")){
				numTurns = numTurns+4;
				cannonShots = cannonShots+1;
			}
			
			flag = myBoard.allSunk();
		}
	System.out.println("Number of turns: " + numTurns);
	System.out.println("Number of shots fired: "+cannonShots);
	}
}