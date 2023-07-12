package Day3.B2750_버블정렬;

import java.io.*;

public class B2750_버블정렬_이도원 {

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n - 1; i++) { // 정렬된 수의 개수
            for (int j = 0; j < n - 1 - i; j++){
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }

        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
