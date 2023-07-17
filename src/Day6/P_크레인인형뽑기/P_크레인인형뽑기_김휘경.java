package Day6.P_크레인인형뽑기;

import java.util.ArrayList;



public class P_크레인인형뽑기_김휘경 {
    public int solution(int[][] board, int[] moves) {
        int len = board.length;
        int count = 0;

        int[][] board2 = new int[len][len];
        ArrayList<Integer> list = new ArrayList<>();
        /*
        0 0 0 0 0       00043
        0 0 1 0 3       00225
        0 2 5 0 1       01541
        4 2 4 4 2       00043
        3 5 1 3 1       03121

        4 (3 (1 1 ) 3) 2 x 4
        */

        // 행렬 바꾸기
        for(int i=0; i < len; i++){
            for(int j=0; j < len; j++){
                board2[i][j] = board[j][i]; // 5 1 -> 1 5
            }
        }

        for(int m : moves){
            int a = 0;
            for(int i = 0; i < len; i++){
                if(board2[m-1][i] != 0){
                    a = board2[m-1][i]; // 4
                    board2[m-1][i] = 0;
                    break;
                }
            }
            if(a != 0){
                if(list.size()>=1 && list.get(list.size()-1) == a){
                    list.remove(list.size()-1);
                    count += 2;
                }else list.add(a);
            }else continue;
        }
        return count;
    }
}