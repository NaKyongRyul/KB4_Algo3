package Day6.B1920_수찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_임재현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);

        token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(token.nextToken());
            int low = 0;
            int high = N - 1;
            int mid = (low + high) / 2;
            boolean flag = false;
            while (low <= high) {
                mid = (low + high) / 2;
                if (arr[mid] == target) {
                    flag = true;
                    break;
                }
                if (low == high)
                    break;
                if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println(flag ? 1 : 0);
        }
    }
}
