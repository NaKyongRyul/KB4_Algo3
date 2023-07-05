package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합5_김원우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int summation = 1, start =1 , end =1, cnt = 1;


        /**
         * 투포인터 방식
         */
        while (end < n){
            if (summation < n) {
                end++;
                summation += end;
            } else if (summation == n) {
                cnt++;
                end++;
                summation += end;
            } else {
                summation -= start;
                start++;
            }
        }
        System.out.println(cnt);

        /**
         * 투포인터 안쓰고 조건 달아서 nlogn으로 풀기
         */

//        for (int i = 1; i < n; i++) {
//            int tmp = i;
//            for (int j = i + 1; j <= n; j++) {
//                tmp += j;
//                if (tmp == n) {
//                    cnt++;
//                    break;
//                } else if (tmp > n) {
//                    break;
//                }
//            }
//        }
//
//        System.out.println(cnt+1); // 자기 자신 추가



    }
}
