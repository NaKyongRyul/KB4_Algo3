package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_김휘경 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken()); // 동전 가치 수
        int K = Integer.parseInt(st.nextToken());

        int[] values = new int[N];

        for(int i = 0; i < N; i++){
            int target = Integer.parseInt(br.readLine());
            values[i] =  target;
        }



        int count = 0;
        int idx = N-1;

        while(idx >= 0){
            if(K == 0){
                break;
            }
            if(K >= values[idx]){
                int tmpCount = K / values[idx];
                count += tmpCount;
                K -= tmpCount * values[idx];
            }
            idx -= 1;
        }

        System.out.println(count);
    }
}
