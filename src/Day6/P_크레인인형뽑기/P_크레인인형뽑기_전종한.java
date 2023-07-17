package Day6.P_크레인인형뽑기;

import java.util.Stack;

public class P_크레인인형뽑기_전종한 {
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack <Integer> stack = new Stack<>();
        
        for(int i : moves){
            for(int [] line : board){
                // 인형이 없는 경우 //
                if(line[i-1] == 0) continue;
                
                // 인형이 있는 경우 //
                if(!stack.isEmpty() && stack.peek() == line[i-1]){
                    stack.pop();
                    line[i-1] = 0;
                    answer += 2;
                }else{
                    stack.push(line[i-1]);
                    line[i-1] = 0;
                }
                break;
            }
        }
        return answer;
    }
}
