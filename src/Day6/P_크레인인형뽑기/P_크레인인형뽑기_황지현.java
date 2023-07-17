import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class P_크레인인형뽑기_황지현 {
    public int solution(int[][] board, int[] moves) {
        Stack <Integer> stack=new Stack <>();
        int answer = 0;
        int size=board.length;
        // System.out.println(Arrays.deepToString(board));
        for(int m :moves){
                for(int i=0;i<size;i++){
                    if(board[i][m-1]!=0){
                        //스택이 비어있을 경우 값 넣기
                        if(stack.isEmpty()){
                            stack.push(board[i][m-1]);
                            board[i][m-1]=0;
                            break;
                        }
                        //아닐경우 비교해가면서 스택연산
                        if(stack.peek()==board[i][m-1]){
                            System.out.println(stack.peek());
                            stack.pop(); 
                            answer+=2;
                        }
                        else{
                            stack.push(board[i][m-1]);
                            }
                        board[i][m-1]=0;
                        break;
                        }
                }
        }
        return answer;
    }
}