package Day6.P_크레인인형뽑기;

import java.util.Arrays;
import java.util.Stack;

public class 크레인인형뽑기_신동렬 {
        static int k;
        public int solution(int [][] board, int[] moves) {

            int [][]board2 = new int[board.length][board.length];
            for (int i=0; i<board.length;i++){
                for(int j=0; j<board[i].length; j++)
                    board2[i][j]=board[j][i];
            }
            int result=0;
            Stack<Integer> stack = new Stack();
            for(int i=0; i<moves.length;i++){
                for(int j=0; j<board2.length;j++){
                    if(board2[moves[i]-1][j]!=0){
                        if(!stack.isEmpty()){
                            k= stack.peek();}
                        stack.push(board2[moves[i]-1][j]);
                        if(k==stack.peek()){
                            stack.pop();
                            stack.pop();
                            result+=2;
                        }
                        board2[moves[i]-1][j]=0;
                        break;
                    }
                }

            }
            return result;}

    }



