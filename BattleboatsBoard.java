//meinz015
public class BattleboatsBoard{
	private int rows;
	private int columns;
	private int numberBoats;
	private int[][] board;
	private int[] locationx = null;
	
	/*
	toString is used for debug
	*/
	public String toString(){
		String tempString = "";
		for (int r=0; r<rows; r++){
			for (int c=0; c<columns; c++){
				int value = board[r][c];
				tempString = tempString + " " + value;
			}
			tempString = tempString+" "+'\n';
		}
		return tempString;
	}
	/*
	initilizes game board
	sets board up to integers added
	also initizes boat number and ship location when called in main drive
	*/
	
	public BattleboatsBoard(int m, int n){
		if(m < 0 || n<0){
			System.out.println("Error: negative number.");
		}
		else if (m<3 || m>12 || n<3 || n>12){
			System.out.println("Error: board size out of range.");
		}
		else{
			board = new int[m][n];
			rows = board.length;
			columns = board[0].length;
		}
		initBoard();
		setBoatNumber();
		initShip();
	}
	
	/*
	determines how many boats are on the board given the chart and board dimensions chosen
	*/
	
	private void setBoatNumber(){
		if (rows == 3 && columns == 3){
			numberBoats = 1;
		}
		else if ((rows>3 && rows<=5)|| (columns<3 && columns<=5)){
			numberBoats = 2;
		}
		else if((rows>5 && rows<=7)||(columns>5 && columns<=7)){
			numberBoats = 3;
		}
		else if((rows >7 && rows<=9)||(columns>7 && columns<=9)){
			numberBoats = 4;
		}
		else if((rows>9 && rows<=12)||(columns>9 && columns<=12)){
			numberBoats = 6;
		}
	}
	
	//initializes the entire board to 4 (represents water)
	private void initBoard(){
		for (int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				board[i][j] = 4;
			}
		}
	}
	
	/*
	generates random numbers within the board (x and y) and up/down
	given the coordinates and orientation, checks to make sure all parts of the ship are not out of bounds
	if they ship isnt out of bounds and there isn't another ship in any placement of the ship, it places the ship
	whereever it places the ship, it changes the number on the board to 5(representing a ship)
	it also adds the locations of the ships to an array, which has a length of the number of ships*3
	*/
	
	private void initShip(){
		System.out.println("Number Ships: "+numberBoats);
		locationx = new int[numberBoats*3];
		int count = 0;
		for (int i = 0; i<numberBoats; i++){
			boolean flag = true;
			int x = rows;
			int y = columns;
			while (flag == true){
				int xCoord = (int)Math.floor(Math.random() * x); 
				int yCoord = (int)Math.floor(Math.random() * y); 
				int upOrDown = (int)Math.floor(Math.random() * 100);
				if (upOrDown%2 == 0){
					upOrDown = 0; //ships are horizontal
				}
				else {
					upOrDown = 1; //ships are vertical
				}
				boolean overlapx = false;
				boolean overlapy = false;
				boolean xOutofBounds = false;
				boolean yOutofBounds = false;
				if (xCoord+2 >= columns){
					xOutofBounds = true;
				}
				if (yCoord+2 >= rows){
					yOutofBounds = true;
				}
				if (board[xCoord][yCoord] == 5){
					overlapx = true;
					overlapy = true;
				}
				if ((((board[xCoord][yCoord] == 4) && (upOrDown ==0))|| ((board[xCoord][yCoord] == 4) &&(upOrDown == 1)))){
					if(xOutofBounds == false && yOutofBounds == false){
						for (int j=0; j<3; j++){
							if ((upOrDown == 0)&& (board[xCoord+j][yCoord] == 5)){
								overlapx = true;
							}
							else if ((upOrDown == 1)&& (board[xCoord][yCoord+j] == 5)){
								overlapy = true;
							}
						}
					}
				flag = true;
				}
				if (upOrDown == 0 && overlapy == false && overlapx == false && xOutofBounds == false && yOutofBounds == false){
					for (int j=0; j<3; j++){
						if (board[xCoord+j][yCoord] == 4){
							board[xCoord+j][yCoord] = 5;
							locationx[count] = xCoord+j;
							count++;
							int tempxCoord = xCoord+j;
						}
					}
				flag = false;
				}
				else if (upOrDown == 1 && overlapx == false && overlapy == false && xOutofBounds == false && yOutofBounds == false){
					for (int j=0; j<3; j++){
						if (board[xCoord][yCoord+j] == 4){
							board[xCoord][yCoord+j] = 5;
							locationx[count] = xCoord;
							count++;
						}
					}
				flag = false;
				}
			}
		}
	}
	
	/*
	below are getters and setters
	set certain values in board (changes numbers to 0 and 1 in main drive)
	get,set row/column number = helps other classes know when something is out of bounds
	returns number of boats
	gets/ sets locationx = used to tell if a ship has been sunk/when all ships are sunk and game is ended
	*/
	
	public void setBoard(int coord1, int coord2, int newVal){
		board[coord1][coord2] = newVal;
	}
	
	public int[][] getBoard(){
		return board;
	}
	
	public int getRowNumber(){
		return rows;
	}
	
	public int getColumnNumber(){
		return columns;
	}
	
	public int getNumberBoats(){
		return numberBoats;
	}
	
	public int getBoardNumber(int x, int y){
		return board[x][y];
	}
	
	public int[] getLocationx(){
		return locationx;	
	}
	public void setLocationx(int count, int x){
		locationx[count] = x;
	}
	/*
	goes through locationx array and if all numbers are 30 (as specified in BattleboatsMoves), we know all ships have been sunk and returns true
	*/
	
	public boolean allSunk(){
		boolean flag = true;
		for (int i=0; i<locationx.length; i++){
			if (locationx[i] != 30){
				flag = false;
			}
		}
	return flag;
	}
}	