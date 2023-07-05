package Day3.B2750_퀵정렬;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2750_퀵정렬_임재현 {
    public static void qs(int leftIdx, int rightIdx, int[] arr) {
        if (leftIdx == rightIdx)
            return;
        // leftIdx to pivot index
        int left = leftIdx, right = rightIdx, pivot = leftIdx;
        int middle = (left + right) / 2;
        if (arr[left] > arr[right]) { // set arr[left] < arr[right]
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        if (arr[left] < arr[pivot]) { // else pivotVal at leftIdx
            if (arr[right] < arr[pivot]) { // else pivotVal at leftIdx
                // arr[middle] to arr[left]
                int temp = arr[middle];
                arr[middle] = arr[left];
                arr[left] = temp;
            }
        }
        while (left < right) {
            while (arr[left] < arr[pivot]) {
                if (left < rightIdx)
                    left++;
                else
                    break;
            }
            while (arr[right] > arr[pivot]) {
                if (right > leftIdx)
                    right--;
                else
                    break;
            }
            if (left < right) {
                // swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // swap pivot to right
        int pivotVal = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = pivotVal;
        pivot = right;

        // divide
        qs(leftIdx, pivot, arr);
        qs(pivot + 1, rightIdx, arr);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        qs(0, N - 1, arr);

        for (int i = 0; i < N; i++) {
            builder.append(arr[i]).append("\n");
        }
        System.out.print(builder);
    }
}
