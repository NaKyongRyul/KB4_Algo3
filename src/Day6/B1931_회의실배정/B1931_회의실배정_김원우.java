package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정_김원우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(arr, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));
        Arrays.sort(arr, ((o1, o2) -> {
            return o1[1] - o2[1];
        }));


        int cnt = 1;
        int now = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] < now) {
                continue;
            } else {
//                System.out.println(arr[i][1]);
                now = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
