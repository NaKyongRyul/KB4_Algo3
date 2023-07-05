package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1931_회의실배정_신선영 {
    static int[][] table;
    static int N;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());


        table = new int[N][2];
        ans = 1;

        ArrayList<Integer> cnt = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(table, (a1, a2) -> {
            if (a1[1] == a2[1]) return Integer.compare(a1[0], a2[0]);
            else return Integer.compare(a1[1], a2[1]);
        });

        int now = 0;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            if (table[i][0] >= now) {
                ans++;
                now = table[i][1];
            }
        }

        System.out.println(ans);
    }
}
