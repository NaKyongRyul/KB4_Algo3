package Day1.B10806_개수세기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10806_개수세기_김준서 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int answer = 0;
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int thatNum = Integer.parseInt(token.nextToken());
        for (int num : arr) {
            if (num == thatNum) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
