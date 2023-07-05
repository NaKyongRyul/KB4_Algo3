package Day1.B2018_수들의합;

import java.util.Scanner;

public class B2018_수들의합_김준서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            int sum=0;
            for (int j = i; j <= N; j++) {
                sum+=j;
                if (sum > N) {
                    break;
                }
                dp[sum]+=1;
            }
        }
        System.out.println(dp[N]);
    }
}

/* i
 *  
 * */
