import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_송봉섭 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        quickSort(arr, 0, N-1);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int pivot = arr[(left+right)/2];
        int temp;

        // 5 2 3 4 1
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            // pivot 보다 큰값 , 작은값
            if (i<=j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } // 값 바꾸고 진행
           // System.out.println(" in while = " + Arrays.toString(arr));
        }
        //System.out.println(Arrays.toString(arr));

        if(left < j){
            quickSort(arr , left, j );
        }
        if (right > i) {
            quickSort(arr , i , right);
        }

    }
}


