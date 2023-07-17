package Day6.P_크레인인형뽑기;

import java.util.Stack;

class P_크레인인형뽑기_황혜령 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

		int n = board[0].length;
		int[] loc = new int[n];
		Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < n; i++){
            int tmp = 0;
            while(board[tmp++][i] == 0)
                loc[i] = tmp;
        }
        
        
		for(int i = 0; i < moves.length; i++){
			int curY = (loc[moves[i] - 1]++);
			int curX = moves[i] - 1;
			if(curY >= n) continue;
			int doll = board[curY][curX];
            
			if(!s.isEmpty() && doll == s.peek()){				
				answer += 2;
				s.pop();
			}
			else
				s.add(doll);
		}
        
        return answer;
    }
}
