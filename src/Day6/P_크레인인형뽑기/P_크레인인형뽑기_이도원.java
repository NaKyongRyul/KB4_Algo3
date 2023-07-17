package Day6.P_크레인인형뽑기;

import java.util.*;

public class P_크레인인형뽑기_이도원 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            int line = moves[i] - 1;

            int idx = 0;
            while (idx < board.length && board[idx][line] == 0) idx++;

            if (idx >= board.length) continue;

            int curPeek = board[idx][line];
            list.add(curPeek);
            board[idx][line] = 0;

            if (list.size() >= 2 && list.get(list.size() - 1) == list.get(list.size() - 2)) {
                answer += 2;
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }

        return answer;
    }
}
