package solutions.recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import solutions.TestCaseAbstract;

public class EightQueenProblem extends TestCaseAbstract{
	
	int totalCount = 0;
	HashMap<String, Boolean> finalRes = new HashMap<String, Boolean>();

	@Override
	public void run() {
		int[][] board = new int[8][8]; 
		List<String> queenPositions = new ArrayList<String>();
		eightQueenProblem(queenPositions, board,1);
		System.out.println(totalCount);
		System.out.println(finalRes.size());
	}

	public void eightQueenProblem(List<String> queenPositions, int[][] board, int currcount) {
		if(currcount ==9) {
			Collections.sort(queenPositions);  
			finalRes.put(String.join(",", queenPositions), true);
			totalCount++;
			return;
		}
		if(currcount >9) {
			return;
		}
//		printBoard(board);
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				boolean isAdded = addQueen(currcount, board, x, y);
				if(isAdded) {
//					System.out.println(currcount+":"+x+"_"+y);
					queenPositions.add( x+"_"+y);
					eightQueenProblem(queenPositions,copyBoard(board), (currcount+1));
					queenPositions.remove( x+"_"+y);
					removeQueen(board, x, y, currcount);
				}
			}
		}
	}
	private int[][] copyBoard(int[][] board){
		if(board==null) {
			return null;
		}
		int[][] newBoard = new int[8][8]; 
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				newBoard[x][y] = board[x][y];
			}
		}
		return newBoard;
	}

	private boolean addQueen(int index, int[][] board, int x, int y) {
		if(board[x][y]!=0) {
			return false;
		}
		board[x][y]=index;
		for(int r=0; r<8;r++) {
			if(board[r][y]==0) {
				board[r][y] = index;
			}
		}
		for(int c=0; c<8;c++) {
			if(board[x][c]==0) {
				board[x][c] = index;
			}
		}
		for(int c=y,r=x; c>=0&&r>=0;r--,c--) {
			if(board[r][c]==0) {
				board[r][c] = index;
			}
		}
		for(int c=y,r=x; c<8&&r<8;r++,c++) {
			if(board[r][c]==0) {
				board[r][c] = index;
			}
		}
		for(int c=y,r=x; c>=0&&r<8;r++,c--) {
			if(board[r][c]==0) {
				board[r][c] = index;
			}
		}
		for(int c=y,r=x; c<8&&r>=0;r--,c++) {
			if(board[r][c]==0) {
				board[r][c] = index;
			}
		}
		return true;
	}

	public void removeQueen(int[][] board, int x, int y, int currentCount) {
		for(int r=0; r<8;r++) {
			if(board[r][y] == currentCount) {
				board[r][y] = 0;
			}
		}
		for(int c=0; c<8;c++) {
			if(board[x][c] == currentCount) {
				board[x][c] = 0;
			}
		}
		for(int c=y,r=x; c>=0&&r>=0;r--,c--) {
			if(board[r][c] == currentCount) {
				board[r][c] = 0;
			}
		}
		for(int c=y,r=x; c<8&&r<8;r++,c++) {
			if(board[r][c] == currentCount) {
				board[r][c] = 0;
			}
		}
		for(int c=y,r=x; c>=0&&r<8;r++,c--) {
			if(board[r][c]==currentCount) {
				board[r][c] = 0;
			}
		}
		for(int c=y,r=x; c<8&&r>=0;r--,c++) {
			if(board[r][c]==currentCount) {
				board[r][c] = 0;
			}
		}
	}

	private void printBoard(int[][] board) {
		for(int x=0;x<8;x++){
			for(int y=0;y<8;y++){
				System.out.print(board[x][y] + " ");
			}
			System.out.println("" );
		}
	}
}
