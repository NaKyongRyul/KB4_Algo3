package Day1.B12891_DNA비밀번호;

import java.util.Scanner;

public class B12891_DNA비밀번호_임재현 {
    public static boolean checkCount(int[] arr, int[] min) {
        // 최소치와 비교해 안전하면 true, 아니라면 false 리턴
        for (int i = 0; i < 4; i++) {
            if (arr[i] < min[i])
                return false;
        }
        return true;
    }

    public static int getArrIndex(char s) {
        if (s == 'A')
            return 0;
        if (s == 'C')
            return 1;
        if (s == 'G')
            return 2;
        if (s == 'T')
            return 3;

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        int ans = 0;

        String dna = sc.next();
        // 'A', 'C', 'G', 'T' 순으로 저장
        int[] arr = new int[4];
        int[] min = new int[4];
        for (int i = 0; i < 4; i++) {
            min[i] = sc.nextInt();
        }

        for (int i = 0; i < P; i++) {
            arr[getArrIndex(dna.charAt(i))]++;
        }

        ans += checkCount(arr, min) ? 1 : 0;

        for (int i = P; i < S; i++) {
            arr[getArrIndex(dna.charAt(i - P))]--;
            arr[getArrIndex(dna.charAt(i))]++;
            ans += checkCount(arr, min) ? 1 : 0;
        }

        System.out.println(ans);

        sc.close();
    }
}
