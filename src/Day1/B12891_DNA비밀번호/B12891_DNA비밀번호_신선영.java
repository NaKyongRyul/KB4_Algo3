package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_신선영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());   // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken());   // 부분문자열(비밀번호) 길이
        int ans = 0;

        st = new StringTokenizer(br.readLine());

        char[] arr = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        char[] newArr = Arrays.copyOfRange(arr, 0, P);

        for (char n : newArr) {
            if (n == 'A') a--;
            if (n == 'C') c--;
            if (n == 'G') g--;
            if (n == 'T') t--;
        }

        if (a <= 0 && c <= 0 && g <= 0 && t <= 0) {
            ans = 1;
        }


        for (int i = 1; i < S-P+1; i++) {
            char n = arr[i - 1];
            if (n == 'A') a++;
            if (n == 'C') c++;
            if (n == 'G') g++;
            if (n == 'T') t++;

            char nn = arr[i + P - 1];
            if (nn == 'A') a--;
            if (nn == 'C') c--;
            if (nn == 'G') g--;
            if (nn == 'T') t--;

            if (a <= 0 && c <= 0 && g <= 0 && t <= 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}