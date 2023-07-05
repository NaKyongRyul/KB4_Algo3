package Day6;

import java.util.Scanner;

public class B2839_설탕배달_김원우 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt =0;

        while (true) {
            if (n % 5 == 0) {
                System.out.println(n / 5 + cnt);
                break;
            } else if (n < 0) {
                System.out.println(-1);
                break;
            }
            n -= 3;
            cnt++;
        }

    }

}
