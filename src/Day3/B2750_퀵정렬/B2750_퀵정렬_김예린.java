package Day3.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2750_퀵정렬_김예린 {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int start, int end){  // return 받아야 하기 때문에 void X
        int pivot = start;
        int left = start + 1;
        int right = end;

        // 엇갈릴 때 까지 반복
        while (left <= right){
            while (left <= right && arr[left] <= arr[pivot]){
                left++;
            }
            while (left<=right && arr[right] >= arr[pivot]){
                right--;
            }

            // 엇갈린 경우
            if (left > right){
                swap(arr, right, pivot);
            }
            else {
                swap(arr, pivot+1, right);
            }
        }
        return right;
    }

    public static void quickSort(int[] arr, int start, int end){
        // 종료조건
        if (start >= end){
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);    // 재귀
        quickSort(arr, pivot+1, end);


    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        for (int i=0; i <N; i++){
            st = new StringTokenizer(bf.readLine());
            int inp = Integer.parseInt(st.nextToken());
            arr[i] = inp;
        }
        quickSort(arr, 0 , arr.length-1);
        for (int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
    }



}
