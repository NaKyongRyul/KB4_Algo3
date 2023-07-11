package Day2.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_조승빈 {
    static int N;
    static int M;

    static char[] arr;
    static int[] minCountArr = new int[4];
    static int[] realCountArr = new int[4];

    static int pwdCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            minCountArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            if (arr[i]=='A') realCountArr[0]++;
            if (arr[i]=='C') realCountArr[1]++;
            if (arr[i]=='G') realCountArr[2]++;
            if (arr[i]=='T') realCountArr[3]++;
        }

        if (checkCounting()) {
            pwdCnt++;
        }

        int idx;
        for (int i = M; i < N; i++) {
            idx = i - M;

            if (arr[idx]=='A') realCountArr[0]--;
            if (arr[idx]=='C') realCountArr[1]--;
            if (arr[idx]=='G') realCountArr[2]--;
            if (arr[idx]=='T') realCountArr[3]--;

            if (arr[i]=='A') realCountArr[0]++;
            if (arr[i]=='C') realCountArr[1]++;
            if (arr[i]=='G') realCountArr[2]++;
            if (arr[i]=='T') realCountArr[3]++;

            if (checkCounting()) {
                pwdCnt++;
            }
        }

        System.out.println(pwdCnt);
    }

    public static boolean checkCounting() {
        for (int i = 0; i < 4; i++) {
            if (realCountArr[i] < minCountArr[i]) return false;
        }
        return true;
    }
}
