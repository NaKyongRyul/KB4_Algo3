package Day6.P_크레인인형뽑기게임;

import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

public class P_크레인인형뽑기_Sol {
	public int solution(int[][] board, int[] moves) {

		int answer = 0;
		Stack<Integer> stack = new Stack<>(); // Stack 이용
		stack.push(0); // Stack 이 비어있는 경우를 방지

		// move -> x 열 선택
		for (int move : moves) {
			// y -> 위에서부터 확인
			for (int y = 0; y < board.length; y++) {
				// 인형이 나오면 집음
				if (board[y][move - 1] != 0) {
					// 인형 터지면 pop
					if (stack.peek() == board[y][move - 1]) {
						stack.pop();
						answer += 2;
					}
					// 인형 터지지 않으면 push
					else
						stack.push(board[y][move - 1]);
					// 인형 집으니깐 없어짐
					board[y][move - 1] = 0;
					break;
				}
			}
		}
		return answer;
	}
}
