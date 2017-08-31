//meinz015
public class Debug{
	
	public String debug(BattleboatsBoard gameBoard){
		return gameBoard.toString();
	}
	
	/*above is printing screen in debug mode
		it goes through all spots on the board and prints out values in each spot
	*/
	
	public String nonDebug(BattleboatsBoard gameBoard){
		String tempString = "";
		int rows = gameBoard.getRowNumber();
		int columns = gameBoard.getColumnNumber();
		for (int r=0; r<rows; r++){			
			for(int c=0; c<columns; c++){
				int number = gameBoard.getBoardNumber(r,c);
				if (number == 4 || number == 5){
					int value = 7;//7 is obscured view
					tempString = tempString+ " "+value;
				}
				else{
					int value = number;//shows places already hit
					tempString = tempString+ " "+value;
				}
			}
		tempString = tempString+" "+'\n';
		}
	return tempString;
	}
	
	/*above is print screen not in debug mode
		goes through all spots on the board
		if spots have been hit, it shows prints the number in that spot
		if spots have not been hit, it shows the number 7 to obscure board
	*/

}