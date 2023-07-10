import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B11659_구간합_송봉섭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = sc.nextInt();
        int sum =0;

        int[] arr = new int[N];
        int[] sumList = new int[N+1];
        sumList[0] = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            // 5 4 3 2 1 -> 0 5 9 12 14 15
            sum += arr[i];
            sumList[i+1] = sum;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int startIndex = sc.nextInt();
            int lastIndex = sc.nextInt();
            //int sub = sumList[lastIndex-startIndex];
            int sub = sumList[lastIndex] - sumList[startIndex-1];
            stringBuilder.append(sub);
            stringBuilder.append("\n");
            sum = 0;
        }
        System.out.println(stringBuilder);

    }
}
