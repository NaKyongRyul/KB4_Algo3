package Day6.P_크레인인형뽑기;


import java.util.Stack;
import java.util.*;

class P_크레인인형뽑기_김현지 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = moves.length;
        int col;
        int boardLen = board[0].length;
        int lastDoll;
        boolean removedDoll;
        Stack <Integer> stack = new Stack<>();
        

        
        
        // moves에 따른 인형들 stack에 넣기
        for (int i=0; i<len; i++) {
            col = moves[i]-1;
            removedDoll = false;
            for (int row=0; row<boardLen; row++) {
                // System.out.println(stack);
                if (removedDoll == true) {
                    break;
                }
                // board가 비어있지 않다면 stack에 추가
                if ((board[row][col])!= 0) {
                    // stack이 비어있지 않다면 같은지 확인
                    if (!stack.isEmpty()) {
                        lastDoll = stack.peek();
                        if (lastDoll == board[row][col]) {
                            board[row][col] = 0;
                            stack.pop();
                            answer += 2;
                        // 같지 않다면 stack에 인형 추가
                        } else {
                            stack.add(board[row][col]);
                            board[row][col] = 0;
                        }
                        removedDoll = true;
                    // stack이 비어있다면 그냥 추가
                    } else {
                        stack.add(board[row][col]);
                        removedDoll = true;
                        board[row][col] = 0;
                    }
                // board가 비어있다면 다음 칸으로 이동
                } else {
                    continue;
                }
            }
        }
        
        
        return answer;
    }
}