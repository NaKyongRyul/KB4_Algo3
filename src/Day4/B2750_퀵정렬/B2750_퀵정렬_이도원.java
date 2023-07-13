package Day4.B2750_퀵정렬;

import java.io.*;

public class B2750_퀵정렬_이도원 {
    public static void swap(int[] arr, int left, int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = left++;
        while(left <= right){
            while (left <= right && arr[left] < arr[pivot]) left++;
            while (left <= right && arr[right] > arr[pivot]) right--;
            if (left < right) swap(arr, left, right);
        }
        swap(arr, pivot, right);
        pivot = right;
        return pivot;
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left >= right) return;

        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, n - 1);

        for (int num : arr){
            System.out.println(num);
        }
    }
}
