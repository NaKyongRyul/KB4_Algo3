package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_이소형 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }

        int min, idx, temp;
        for (int i = 0; i < n - 1; i++) {
            min = nums[i];
            idx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    idx = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }
}
