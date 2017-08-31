//meinz015
import java.util.Scanner;

public class BattleboatsMoves{
	private String str = null;
	private int count = 0;
	private int[] hitShipsx = null;
	private int[] hitShipsy = null;
	
	/*
	asks player for guess
	if guess = 5(there is ship), str = hit
	if guess = 4(water), str = miss
	if guess = anything else, str = already hit
	also, whenever a ship is hit, it changes that location in the location x array to 8
	*/
	
	public String moves(BattleboatsBoard gameBoard){
		System.out.println("Location (Input as two numbers, no punctuation, x first, y second)");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		Scanner next = new Scanner(str);
		int firstCoord = next.nextInt();
		int secondCoord = next.nextInt();
		int tempFirst = secondCoord;
		int tempSecond = firstCoord;
		firstCoord = tempFirst;
		secondCoord = tempSecond;
		int rows = gameBoard.getRowNumber();
		int columns = gameBoard.getColumnNumber();
		if (firstCoord <0 || firstCoord>rows-1||secondCoord<0||secondCoord>columns-1){
			str = "Out of Bounds";
		}
		else{
			int guess = gameBoard.getBoardNumber(firstCoord, secondCoord);
			if (guess == 5){
				str = "Hit!";
				gameBoard.setBoard(firstCoord, secondCoord, 1);
				gameBoard.setLocationx(count, 20);
				count++;
			}
			else if(guess == 4){
				str = "Miss";
				gameBoard.setBoard(firstCoord, secondCoord, 0);
			}
			else if(guess == 0|| guess==1){
				str = "You already choose this spot. You will be penalized 4 turns.";
			}
		}
	return str;
	}
	
	/*
	looks at locationx array
	since ships are in sets of 3, if 3 eights are in a row(starting with the 0,1,2 in the array), the ship is sunk
	once a ship is sunk, the three places in the array are changed to 9
	*/
	
	public void hitShips(BattleboatsBoard gameBoard){
		int[] checkArray = gameBoard.getLocationx();
		for (int i = 0; i< checkArray.length; i=i+3){
			if (checkArray[i]==20 && checkArray[i+1]==20 && checkArray[i+2]==20){
				System.out.println("Sunk!");
				gameBoard.setLocationx(i, 30);
				gameBoard.setLocationx(i+1, 30);
				gameBoard.setLocationx(i+2, 30);
			}
		}
	}
}



	
	