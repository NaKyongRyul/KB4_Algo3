package Day6.P_크레인인형뽑기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_크레인인형뽑기_전민형 {

	public static void main(String[] args) throws IOException {
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String str = reader.readLine();
//		
//		StringTokenizer tok = new StringTokenizer(str);
//		
		int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		Stack <Integer> stc = new Stack<>();
		int cnt = 0;
		
		for(int i = 0; i<moves.length; i++) {
			
			for(int j = 0; j<board.length; j++){
				if(board[j][moves[i]-1]!=0) {
					if(stc.isEmpty()) {
						stc.push(board[j][moves[i]-1]);
						
					}
					else if(stc.peek()==board[j][moves[i]-1]) {
						stc.pop();
						cnt = cnt + 2;
						
					}else {
						stc.push(board[j][moves[i]-1]);
					}
					board[j][moves[i]-1]=0;
					break;
				}
			}
			
			
		}
		
		System.out.println(cnt);
		
		
		

	}

}
