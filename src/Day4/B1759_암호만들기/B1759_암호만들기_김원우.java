package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_김원우 {

    static char [] arr;
    static int L;
    static int C;

    static int [] visited;
    static int [] temp;

    static void combination(int r, int start) {
        if (r == L) {
            int cnt = 0;
            for (int i = 0; i < L; i++) {
                if (arr[temp[i]] == 'a' || arr[temp[i]] == 'e' || arr[temp[i]] == 'i' || arr[temp[i]] == 'o' ||
                        arr[temp[i]] == 'u') {
                    cnt++;
                }
            }

            if (L - cnt >= 2 && cnt >= 1) {
                for (int i = 0; i < L; i++) {
                    System.out.print(arr[temp[i]]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            temp[r] = i;
            combination(r + 1, i);
            visited[i] = 0;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        visited = new int[C];
        temp = new int[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        combination(0,0);

    }
}
