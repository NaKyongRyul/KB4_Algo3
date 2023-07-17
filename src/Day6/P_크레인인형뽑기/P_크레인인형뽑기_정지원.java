package Day6.P_크레인인형뽑기;

import java.util.Stack;

public class P_크레인인형뽑기_정지원 {
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<moves.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][moves[i]-1]!=0){
                    if(!stack.isEmpty() && stack.peek()==board[j][moves[i]-1]){
                        stack.pop();
                        answer+=2;
                    }
                    else{
                        stack.push(board[j][moves[i]-1]);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
                else{
                    continue;
                }
            }
        }   
        return answer;
    }
}
