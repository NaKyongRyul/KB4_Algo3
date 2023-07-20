package Day8.B9663_N-Queen;

import java.util.Scanner;

public class B9663_N_Queen_정지원 {
	static int n;
	static int[][] board;
	static int count = 0;
	
	static boolean isSafe(int y, int x){
		
		for(int i=0;i<y;i++) {
			if(board[i][x]==1) {
				return false;
			}
			else if((x-(i+1))>=0 && board[y-i-1][x-(i+1)]==1) {
				return false;
			}
			else if(x+i+1<n && board[y-i-1][x+i+1]==1) {
				return false;
			}
		}
		
		return true;
	}
	
	
	static void func(int line, int col) {
		
		if(line==n-1) {
			count++;
			return;
		}
		
		board[line][col] = 1;
		
		for(int i=0;i<n;i++) {
			if(isSafe(line+1, i)) func(line+1, i);
			else {
				continue;
			}
		}
		
		
		board[line][col] = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n= sc.nextInt();
		board = new int[n][n];
		
		
		for(int i=0;i<n;i++) {
			func(0, i);
			
		}
		
		System.out.println(count);
	}
}
