package soduko;

public class Soduko {
	
	private static final int GRID_SIZE = 9;
	public static void main(String[] args){
		
		int[][] board= { {7, 0, 2, 0, 5, 0, 6, 0, 0},
		        	{0, 0, 0, 0, 0, 3, 0, 0, 0},
		        	{1, 0, 0, 0, 0, 9, 5, 0, 0},
		        	{8, 0, 0, 0, 0, 6, 0, 9, 0},
		        	{0, 4, 3, 0, 0, 0, 7, 5, 0},
		        	{0, 9, 0, 0, 0, 0, 0, 0, 8},
		        	{0, 0, 9, 7, 0, 0, 0, 0, 5},
		        	{0, 0, 0, 2, 0, 0, 0, 0, 0},
		        	{0, 0, 7, 0, 4, 0, 2, 0, 3} };
		printboard(board);
		
		if(solveBoard(board)){
			System.out.println();
			System.out.println("Board Solved Successfully !!!");
			System.out.println();
		}else{
			System.out.println("ooop's it's not solved !!!");
		}
		printboard(board);
				
	}
	private static void printboard(int[][] board){
	
		for(int row=0;row<GRID_SIZE;row++){
			if(row % 3 == 0 && row != 0){
				System.out.println("-----------");
			}
			for(int col=0;col<GRID_SIZE;col++){
				if(col % 3 ==0 && col != 0){
					System.out.print("|");
				}
				System.out.print(board[row][col]);
			}
			System.out.println();
		}
	}
	private static boolean isNumberinRow(int[][] board,int number,int row){		
		for(int i=0;i<GRID_SIZE;i++){
			if(board[row][i] == number){
				return true;
			}
		}
		return false;
	}
	private static boolean isNumberinCol(int[][] board,int number,int col){
		for(int i=0;i<GRID_SIZE;i++){
			if(board[i][col] == number){
				return true;
			}
		}
		return false;
	}
	private static boolean isNumberinBox(int[][] board,int number,int row,int col){
		int boardRowBox = row - row % 3;
		int boardColBox = col - col % 3;
		
		for(int i=boardRowBox;i<boardRowBox+3;i++){
			for(int j=boardColBox;j<boardColBox+3;j++){
				if(board[i][j] == number){
					return true;
				}
			}
		}
		return false;
	}
	private static boolean isValidPlacement(int[][] board,int number,int row,int col){
		return !isNumberinRow(board,number,row) && 
				!isNumberinCol(board,number,col) && 
				!isNumberinBox(board,number,row,col); 
	}
	private static boolean solveBoard(int[][] board){
		for(int row =1; row <GRID_SIZE; row++){
			for(int col =1; col <GRID_SIZE; col++){
				if(board[row][col] == 0){
					for(int numberToTry =0; numberToTry <=GRID_SIZE; numberToTry++){
						if(isValidPlacement(board,numberToTry,row,col)){
							board[row][col] = numberToTry;
							
							if(solveBoard(board)){
								return true;
							}else{
								board[row][col] =0;
							}
						}
					}
					return false;
				}
			}
		}			
		return true;
	}

}
