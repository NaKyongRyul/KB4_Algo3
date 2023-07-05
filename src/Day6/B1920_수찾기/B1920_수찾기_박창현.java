package Day6.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_박창현 {
    static int BinarySearch(int[] arr, int search) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == search) return m;
            else if (arr[m] > search) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        int[] arrN = new int[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);

        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < M; i++) {
            sb.append(BinarySearch(arrN, Integer.parseInt(st.nextToken())) < 0 ? 0 : 1).append("\n");
        }
        System.out.println(sb);
    }
}
