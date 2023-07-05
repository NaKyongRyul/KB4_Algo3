package Day3.B2750_선택정렬;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2750_선택정렬_임재현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            // find minimum
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < N; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
