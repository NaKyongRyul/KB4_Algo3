package Day4.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_병합정렬_이소형 {

    public static int[] arr;

    public static int[] mergeSort(int left, int right) {
        if (left == right) return new int[] {arr[left]};

        int center = (left + right) / 2;    // 중앙
        int[] l = mergeSort(left, center);    // 왼쪽
        int[] r = mergeSort(center + 1, right);   // 오른쪽
        int leftSize = l.length, rightSize = r.length;
        int[] temp = new int[leftSize + rightSize];
        int leftIdx = 0, rightIdx = 0, idx = 0;
        for (; leftIdx < leftSize && rightIdx < rightSize; idx++) {
            if (l[leftIdx] < r[rightIdx]) temp[idx] = l[leftIdx++];
            else temp[idx] = r[rightIdx++];
        }
        for (; leftIdx < l.length; leftIdx++) {
            temp[idx++] = l[leftIdx];
        }
        for (; rightIdx < r.length; rightIdx++) {
            temp[idx++] = r[rightIdx];
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        int[] result = mergeSort(0, n - 1);

        for (int e :
                result) {
            System.out.println(e);
        }
    }
}
