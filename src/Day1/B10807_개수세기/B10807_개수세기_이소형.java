package Day1.B10807_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10807_개수세기_이소형 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] strs = reader.readLine().split(" ");

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }


        int v = Integer.parseInt(reader.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == v) cnt++;
        }
        System.out.println(cnt);
    }
}
