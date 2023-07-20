package Day8.B9663_N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;



/**
 * dfs + 백트래킹
 */
public class B9663_N_Queen_김휘경 {
    static int N;
    static int count;
    static int[] row;

    static boolean check(int target){ // 인접한지 확인
        for(int i = 0; i < target; i++) {
            if (row[target] == row[i]) { // 인접
                return false;
            }else if(abs(target - i) == abs(row[target] - row[i])){ // 대각선 인접
                return false;
            }
        }
        return true;

    }

    static void dfs(int depth){

        // 중단 조건
        if(N == depth){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            row[depth] = i; // 해당 위치 할당

            if(check(depth)){ // 퀸 넣기 가능한 경우
                dfs(depth+1); // 재귀
            }
        }


    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 초기화
        count = 0;
        row = new int[N];


        dfs(0);


        System.out.println(count);

    }


}
