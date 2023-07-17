package Day6.P_크레인인형뽑기;

import java.util.Stack;
public class P_크레인인형뽑기_장재은 {
	public int solution(int[][] board, int[] moves) {
        Stack <Integer> stack = new Stack<>();
        int answer = 0;
        int num = 0;
        for(int m:moves){
            for(int i=0; i<board.length; i++){
                if(board[i][m-1] != 0) {
                    num = board[i][m-1];
                    board[i][m-1] = 0;
                    if(!stack.isEmpty() && stack.peek() == num){
                        stack.pop();
                        answer += 2;   
                    }
                    else{
                        stack.push(num);
                    }                    
                    break;
                }       
            }
        }
        return answer;
    }
}

