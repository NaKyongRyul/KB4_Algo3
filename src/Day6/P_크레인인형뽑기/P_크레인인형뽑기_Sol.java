package Day6.P_크레인인형뽑기;

import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

public class P_크레인인형뽑기_Sol {
	
	// 메인문
	public static void main(String[] args) throws IOException {
		
		int[][] board = new int [][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board , moves));
	}
		 
	// 솔루션 함수
	public static int solution(int[][] board, int[] moves) {
		
		int answer = 0;
		Stack <Integer> stack = new Stack<>();
		
		// 밑에서 비어있는스택.peek() => 에러방지
		stack.push(0);
		
		for(int move : moves) {
			
			// 뽑을 인형 탐색
			for(int y = 0; y < board.length; y++) {
				
				// 인형이 있는 경우
				if(board[y][move - 1] != 0 ) {
					
					// 스택에 옮기는 로직
					// 스택이 터지는 경우
					if(board[y][move - 1] == stack.peek()) {
						stack.pop();
						answer += 2;
					}
					
					// 안터지는 경우
					else {
						stack.push(board[y][move - 1]);
					}
					
					board[y][move-1] = 0;
					break;
				}
			}
		}
		
		return answer;
		
	}
	
}


