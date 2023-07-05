package Day6.P_크레인인형뽑기게임;

import java.util.Stack;

public class P_크레인인형뽑기게임_박상희 {
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		Stack<Integer> dolls = new Stack<>(); // 뽑은 인형들을 넣을 스택
		for (int m = 0, len = moves.length; m < len; m++) {
			int num = moves[m]; // 인형을 집기 위해 크레인을 작동시킨 위치(뽑으려는 인형이 담긴 위치)
			
			for (int r = 0, rows = board.length; r < rows; r++) {
				if (board[r][num - 1] == 0) { // 뽑을 인형이 없다면
					continue;
				}
				else if ((!dolls.isEmpty()) && (board[r][num - 1] == dolls.peek())) { // 뽑은 인형들을 담긴 스택이 비어 있지 않고, 방금 뽑은 인형이 뽑은 인형들을 담긴 스택의 첫 번째 인형과 같다면
					dolls.pop();
					answer += 2;
				}
				else {
					dolls.push(board[r][num - 1]); // 방금 뽑은 인형을 스택에 담는다.
				}
				
				board[r][num - 1] = 0; // 뽑은 인형의 위치를 0으로 설정함으로써 인형을 없앤다.
				
				break;
			}
		}		
		
		return answer;
	}
	
	public static void main(String[] args) {
		int board[][] = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int moves[] = {1, 5, 3, 5, 1, 2, 1, 4};
		
		System.out.println(solution(board, moves)); // int result = 4;
	}
}

/*
// 프로그래머스 제출용
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
		
		Stack<Integer> dolls = new Stack<>(); // 뽑은 인형들을 넣을 스택
		for (int m = 0, len = moves.length; m < len; m++) {
			int num = moves[m]; // 인형을 집기 위해 크레인을 작동시킨 위치(뽑으려는 인형이 담긴 위치)
			
			for (int r = 0, rows = board.length; r < rows; r++) {
				if (board[r][num - 1] == 0) { // 뽑을 인형이 없다면
					continue;
				}
				else if ((!dolls.isEmpty()) && (board[r][num - 1] == dolls.peek())) { // 뽑은 인형들을 담긴 스택이 비어 있지 않고, 방금 뽑은 인형이 뽑은 인형들을 담긴 스택의 첫 번째 인형과 같다면
					dolls.pop();
					answer += 2;
				}
				else {
					dolls.push(board[r][num - 1]); // 방금 뽑은 인형을 스택에 담는다.
				}
				
				board[r][num - 1] = 0; // 뽑은 인형의 위치를 0으로 설정함으로써 인형을 없앤다.
				
				break;
			}
		}		
		
		return answer;
    }
}
*/
