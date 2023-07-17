package Day6.P_크레인인형뽑기;

import java.util.Stack;
class P_크레인인형뽑기_강윤서 {
    public int solution(int[][] board, int[] moves) {
        Stack <Integer> stack = new Stack<>();
        int n = board[0].length;
        int count = 0; // 결과
        
        // 크레인 작동 위치 확인
        for (int i=0; i<moves.length; i++){ 
            // 해당 라인 확인하여 가장 상단 인형 뽑기, 스택에 삽입 및 제거
            int col = moves[i]-1;
            for (int j=0; j<n; j++){
                if (board[j][col]!=0){ // 인형이 있으면
                    if (!stack.isEmpty() && stack.peek()==board[j][col]){ // 스택에 있는 값과 같으면
                        stack.pop(); // 스택에서 제거
                        count+=2;
                        board[j][col]=0;
                    } else {
                        stack.push(board[j][col]); // 스택에 삽입
                        board[j][col]=0;
                    }
                    break;
                }
            }
        }
        return count;
    }
}
