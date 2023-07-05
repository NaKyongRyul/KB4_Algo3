package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기_김준서 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
        int[] init = new int[2];
        for (int i = 0; i < 2; i++) {
            init[i] = Integer.parseInt(token.nextToken());
        }
        int N = init[0];
        int M = init[1];
        int[] arr = new int[N+1];
        token = new StringTokenizer(bf.readLine(), " ");
        for (int i = 1; i < N+1; i++) {
            int temp = Integer.parseInt(token.nextToken());
            arr[i] = arr[i - 1] + temp;
        }


        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(bf.readLine(), " ");
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            System.out.println(arr[to]-arr[from-1]);

        }


    }
}
