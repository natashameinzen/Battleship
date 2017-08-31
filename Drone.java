//meinz015
public class Drone{
	private int [][] droneImage = new int[3][3];
	/*
	first checks to see if coordinates entered are out of bounds or not. 
	if they are, it fills entire droneImage array with -8's
	if not out of bounds, it puts the 3x3 matrix surrounding the coordinate into droneImage array
	sorts through all the coordinates of matrix -> if any are out of bounds, it adds 2 to matrix
	if coordinates are in bounds, it calls to on BattleboatsBoard class to get value in coordinate system
	returns droneImage matrix
	*/
	
	public int[][] drone(BattleboatsBoard boardParam, int coord1, int coord2){
		int rows = boardParam.getRowNumber();
		int columns = boardParam.getColumnNumber();
		int tempNumX = coord1;
		int tempNumY = coord2;
		coord1 = tempNumY;		//accidentally got x and y coordinates mixed up, so did a quick switch instead of retyping coord1 and coord 2 in all the if/else statements
		coord2 = tempNumX;
		if (coord1<0 || coord2>rows-1 || coord2<0 || coord1>columns-1){
			for(int countC = 0; countC<3; countC++){
				for(int countR = 0; countR<3; countR++){
					droneImage[countR][countC] = -8; //-8 means that part of drone is out of bounds
				}
			}
		}
		else{
			if (coord1 == 0){
				if (coord2 == 0){
					droneImage[0][0] = 2;
					droneImage[0][1] = 2;
					droneImage[0][2] = 2;
					droneImage[1][0] = 2;
					droneImage[1][1] = boardParam.getBoardNumber(coord1, coord2);
					droneImage[1][2] = boardParam.getBoardNumber(coord1, coord2+1);
					droneImage[2][0] = 2;
					droneImage[2][1] = boardParam.getBoardNumber(coord1+1, coord2);
					droneImage[2][2] = boardParam.getBoardNumber(coord1+1, coord2+1);
				}
				else if (coord2 == rows-1){
					droneImage[0][0] = 2;
					droneImage[0][1] = boardParam.getBoardNumber(coord1-1, coord2);
					droneImage[0][2] = boardParam.getBoardNumber(coord1-1, coord2+1);
					droneImage[1][0] = 2;
					droneImage[1][1] = boardParam.getBoardNumber(coord1, coord2);
					droneImage[1][2] = boardParam.getBoardNumber(coord1, coord2+1);
					droneImage[2][0] = 2;
					droneImage[2][1] = 2;
					droneImage[2][2] = 2;
				}
				else{
					droneImage[0][0] = 2;
					droneImage[0][1] = 2;
					droneImage[0][2] = 2;
					droneImage[1][0] = boardParam.getBoardNumber(coord1, coord2-1);
					droneImage[1][1] = boardParam.getBoardNumber(coord1, coord2);
					droneImage[1][2] = boardParam.getBoardNumber(coord1, coord2+1);
					droneImage[2][0] = boardParam.getBoardNumber(coord1+1, coord2-1);
					droneImage[2][1] = boardParam.getBoardNumber(coord1+1, coord2);
					droneImage[2][2] = boardParam.getBoardNumber(coord1+1, coord2+1);
				}
			}
			else if (coord2 == 0){
				if (coord1 == columns-1){
					droneImage[0][0] = 2;
					droneImage[0][1] = 2;
					droneImage[0][2] = 2;
					droneImage[1][0] = boardParam.getBoardNumber(coord1, coord2-1);
					droneImage[1][1] = boardParam.getBoardNumber(coord1, coord2);
					droneImage[1][2] = 2;
					droneImage[2][0] = boardParam.getBoardNumber(coord1+1, coord2-1);
					droneImage[2][1] = boardParam.getBoardNumber(coord1+1, coord2);
					droneImage[2][2] = 2;
				}
				else{
					droneImage[0][0] = 2;
					droneImage[0][1] = boardParam.getBoardNumber(coord1-1, coord2);
					droneImage[0][2] = boardParam.getBoardNumber(coord1-1, coord2+1);
					droneImage[1][0] = 2;
					droneImage[1][1] = boardParam.getBoardNumber(coord1, coord2);
					droneImage[1][2] = boardParam.getBoardNumber(coord1, coord2+1);
					droneImage[2][0] = 2;
					droneImage[2][1] = boardParam.getBoardNumber(coord1+1, coord2);
					droneImage[2][2] = boardParam.getBoardNumber(coord1+1, coord2+1);
				}
			}
			else if (coord1 == columns-1){
				if (coord2 == rows-1){
					droneImage[0][0] = boardParam.getBoardNumber(coord1-1, coord2-1);
					droneImage[0][1] = boardParam.getBoardNumber(coord1-1, coord2);
					droneImage[0][2] = 2;
					droneImage[1][0] = boardParam.getBoardNumber(coord1, coord2-1);
					droneImage[1][1] = boardParam.getBoardNumber(coord1, coord2);
					droneImage[1][2] = 2;
					droneImage[2][0] = 2;
					droneImage[2][1] = 2;
					droneImage[2][2] = 2;
				}
				else{
					droneImage[0][0] = boardParam.getBoardNumber(coord1-1, coord2-1);
					droneImage[0][1] = boardParam.getBoardNumber(coord1-1, coord2);
					droneImage[0][2] = boardParam.getBoardNumber(coord2-1, coord1+1);
					droneImage[1][0] = boardParam.getBoardNumber(coord1, coord2-1);
					droneImage[1][1] = boardParam.getBoardNumber(coord1, coord2);
					droneImage[1][2] = boardParam.getBoardNumber(coord1, coord2+1);
					droneImage[2][0] = 2;
					droneImage[2][1] = 2;
					droneImage[2][2] = 2;
				}
			}
			else if (coord2 == rows-1){
				droneImage[0][0] = boardParam.getBoardNumber(coord1-1, coord2-1);
				droneImage[0][1] = boardParam.getBoardNumber(coord1-1, coord2);
				droneImage[0][2] = 2;
				droneImage[1][0] = boardParam.getBoardNumber(coord1, coord2-1);
				droneImage[1][1] = boardParam.getBoardNumber(coord1, coord2);
				droneImage[1][2] = 2;
				droneImage[2][0] = boardParam.getBoardNumber(coord1+1, coord2-1);
				droneImage[2][1] = boardParam.getBoardNumber(coord1+1, coord2);
				droneImage[2][2] = 2;
			}
			else{
				droneImage[0][0] = boardParam.getBoardNumber(coord1-1, coord2-1);
				droneImage[0][1] = boardParam.getBoardNumber(coord1-1, coord2);
				droneImage[0][2] = boardParam.getBoardNumber(coord1-1, coord2+1);
				droneImage[1][0] = boardParam.getBoardNumber(coord1, coord2-1);
				droneImage[1][1] = boardParam.getBoardNumber(coord1, coord2);
				droneImage[1][2] = boardParam.getBoardNumber(coord1, coord2+1);
				droneImage[2][0] = boardParam.getBoardNumber(coord1+1, coord2-1);
				droneImage[2][1] = boardParam.getBoardNumber(coord1+1, coord2);
				droneImage[2][2] = boardParam.getBoardNumber(coord1+1, coord2+1);
			}
		}
	return droneImage;
	}
	
	/*
	sorts through droneImage array and prints it out
	if there is a -8 at all within the array, recon is printed since -8 symbolizes the original coordinate entered being out of bounds
	*/
	
	public String values(){
		String tempStr = "";
		int rows = 3;
		int columns = 3;
		for (int r =0; r< rows; r++){
			for (int c=0; c<columns; c++){
				int number = droneImage[r][c];
				if (number == -8){
					tempStr = "Recon";
				}
				else{
					tempStr = tempStr+ " "+ number;
				}
			}
			tempStr = tempStr+" "+'\n';
		}
	return tempStr;
	}
}
//if shot out of bounds, they lose 8 points and no output of board, right?