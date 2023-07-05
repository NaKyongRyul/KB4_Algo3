package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110_공유기설치_김원우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int start = 1;
        int end = house[n-1] - house[0];
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cur = house[0];
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                if (cur + mid <= house[i]) {
                    cnt++;
                    cur = house[i];
                }
            }
            if (cnt >= c) {
                // 정해진 공유기의 갯수보다 많이 세워졌다면
                // 간격을 넓혀야 함.
                start = mid + 1;
                ans = mid;
            }
            else{
                // 반대의 경우는 간격 줄여야함.
                end = mid-1;
            }
        }
        System.out.println(ans);
    }
}
