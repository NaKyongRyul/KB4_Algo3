package Day9.B2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839_설탕배달_최예빈 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        while (N >= 0) {
            if (N % 5 == 0) {
                count += N / 5;
                break;
            }
            N -= 3;
            count++;
        }

        if (N < 0) count = -1;  // 3과 5로 구성할 수 없음

        System.out.println(count);
    }
}
