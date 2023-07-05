package day06;

import java.util.Arrays;
import java.util.Stack;

public class 프로그래머스_크레인인형뽑기 {
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		int N = board.length;
		Stack[] arr  = new Stack[N]; // 배열

		for(int i=0; i<N; i++) {
			arr[i] = new Stack<>();
			for(int j=N-1; j>=0; j--) {
				if(board[j][i]!=0)
					arr[i].add(board[j][i]);
			}
		}

		Stack ans = new Stack(); // 그냥 스택
		for(int move : moves) {
			if(!arr[move-1].isEmpty()) {
				int doll = (int) arr[move-1].peek();
				//System.out.println((move));
				//System.out.print(move + " " + doll + "\n");
				//System.out.println(ans);
				
				if(!ans.isEmpty()) {
					if((int)ans.peek() == doll) {
						arr[move-1].pop();
						ans.pop();
						answer++;
					}
					else {
						arr[move-1].pop();
						ans.add(doll);
					}
				}
				else if(ans.isEmpty()) {
					arr[move-1].pop();
					ans.add(doll);
				}
				System.out.println(move + "번 레인에서 " + doll + " 인형 뽑아냄 ");
				System.out.println("현재 바구니 상태 : " + ans);
			}
		}

		return answer*2;
	}

	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		System.out.println(solution(board, moves));
	}
}
