import java.util.Stack;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.13ms, 75.2MB)
 * 테스트 2 〉	통과 (0.13ms, 71MB)
 * 테스트 3 〉	통과 (0.13ms, 77.9MB)
 * 테스트 4 〉	통과 (0.76ms, 71.8MB)
 * 테스트 5 〉	통과 (0.14ms, 71MB)
 * 테스트 6 〉	통과 (0.18ms, 82.5MB)
 * 테스트 7 〉	통과 (0.40ms, 81.2MB)
 * 테스트 8 〉	통과 (0.49ms, 74.1MB)
 * 테스트 9 〉	통과 (0.38ms, 77MB)
 * 테스트 10 〉	통과 (0.47ms, 79.8MB)
 * 테스트 11 〉	통과 (0.64ms, 72.8MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
class Solution {

    static int N, M;
    static int[] top;
    static Stack<Integer> stack;
    static int count;

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        N = board.length;
        M = moves.length;

        top = new int[N];
        for (int j = 0; j < N; j++) {       // 열
            top[j] = N;                     // 바닥
            for (int i = 0; i < N; i++) {   // 행
                if (board[i][j] != 0) {
                    top[j] = i;
                    break;
                }
            }
        }

        stack = new Stack<>();              // 바구니
        int pick, r, c;
        for (int moveto : moves) {

            // 탑이 있는지 확인 N 과 같으면 바닥x
            c = moveto - 1;
            if (top[c] == N) continue;      // 바닥

            // 빼면서 탑 조정
            r = top[c];
            top[c] += 1;

            // 스택 피크와 같으면 빼고 카운트+2
            if (!stack.isEmpty() && stack.peek() == board[r][c]) {
                stack.pop();
                count += 2;
            } else stack.push(board[r][c]);
        }

        return count;
    }
}