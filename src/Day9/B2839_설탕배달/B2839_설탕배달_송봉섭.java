package Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839_설탕배달_송봉섭 {
    static int N;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //몫 갯수
        while (true) {
            if (N == 0) {
                System.out.println(count);
                break;
            }
            if (N % 5 == 0) {
                System.out.println(N / 5 + count);
                break;
            }
            if (N <0){
                System.out.println(-1);
                break;
            }

            N = N - 3;
            count++;
        }


    }
}
