package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_신선영 {
    static int L;
    static int C;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;

    static void combination(int l, int start) {
        if (l == L) {
            int v = 0;
            int c = 0;
            for (int n : selected) {
                // 자모음 개수 확인
                if (n == 97 || n == 101 || n == 105 || n == 111 || n == 117) {
                    v++;
                } else c++;
            }
            if (v >= 1 && c >= 2) {
                for (int n : selected) System.out.print((char)n + "");
            System.out.println();
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (visited[i]) continue;
            selected[l] = arr[i];
            visited[i] = true;
            combination(l + 1, i + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // C개 중 N개 선택하는 조합

        L = Integer.parseInt(st.nextToken());   // 암호 길이
        C = Integer.parseInt(st.nextToken());   // 사용된 알파벳의 수

        arr = new int[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = ((int)st.nextToken().charAt(0));
        }

        selected = new int[L];
        visited = new boolean[C];
        Arrays.sort(arr);

        combination(0, 0);
    }
}
