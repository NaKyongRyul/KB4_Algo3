package Day4.B15650_N과M1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B15650_N과M1_김준서 {
    static int N;
    static int M;
    static int[] arr;
    public static void combination(int level, int start) {
        if (level == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i]+" ");

            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            arr[level]=i;
            combination(level+1,i+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        combination(0,1);
    }


}


