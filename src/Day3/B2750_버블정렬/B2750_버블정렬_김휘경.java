package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 버블정렬
 */
public class B2750_버블정렬_김휘경 {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int target;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1; j++)
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
        }

        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }

    }


}
