package Day3.B2750_선택정렬;

import java.io.*;

public class B2750_선택정렬_이도원 {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n - 1; i++){
            int minIdx = 0;
            int min = arr[i];
            for (int j = i + 1; j < n; j++){
                if (arr[j] < min){
                    min = arr[j];
                    minIdx = j;
                }
            }
            if (min != arr[i]) swap(arr, i, minIdx);
        }

        for (int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
