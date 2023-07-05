package Day6.P_크레인인형뽑기게임;

import java.util.Stack;

public class P_크레인인형뽑기게임_서은효 {


	
	public static int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		int row = board.length;	   //행 길이 == 열 길이
		
		for(int i =0, len = moves.length; i< len; i++) {
			
			int move = moves[i] - 1; //크레인이 선택하려는 열 번호 
			
			for(int j =0; j<row; j++) { //열에서 행만큼 for 반복 
				if(board[j][move] != 0) {//만약 0이 아니라면 
					
					if(stack.isEmpty()) { //스택이 비었으면 그 값을 넣어줌 
						stack.push(board[j][move]); 
						board[j][move] = 0;
						break;
					}else{ //스택이 안 비었으면 
						
						if(stack.peek() == board[j][move]) {//스택의 마지막 값이 지금 값과 같은지 보고
							stack.pop();//pop한 후 count 올린다 
							cnt += 2;
							board[j][move] = 0; // push후 pop한 부분 0으로 변경 
							break;
							
						}else {//스택의 마지막 값과 다르다면 push 
							stack.push(board[j][move]); 
							board[j][move] = 0;
							break;
						}
					}
					
					
					}
}
			
		}

		return cnt;
        
	}
	
	public static void main(String[] args) {
		int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] move = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, move));
		
	}
}



