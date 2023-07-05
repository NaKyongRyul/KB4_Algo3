package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// B2750_버블정렬
public class B2750_삽입정렬_박창현 {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int a = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if(arr[j]>a) swap(arr,j+1,j);
                else break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        insertionSort(arr);
        //System.out.println(Arrays.toString(arr));
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
