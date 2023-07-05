import java.util.Stack;
import java.util.Arrays;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack <Integer> bucket = new Stack<>();
        bucket.add(0);
        
        int answer = 0;
        
        for (int i = 0; i<moves.length; i++){
            int move = moves[i]; // 뽑으려는 번호
            for (int j=0; j<board.length;j++){
                if (board[j][move-1]==0) continue; // 아무것도 없는 경우 아래로 내려감
                if (bucket.peek()==board[j][move-1]) {
                    bucket.pop(); // 같은 인형 들어있으면 인형 터트리기
                    answer+=2; // 인형 두개 사라짐
                }
                else {
                    bucket.add(board[j][move-1]); // 아니면 바구니에 추가
                }
                board[j][move-1] = 0; // 보드에서 삭제
                break; 
            }
        }
        return answer;
    }
}