package Day4.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_병합정렬_최예빈 {
    static int[] buff;

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int center = (left + right) / 2;
        int i; // i로 left~right 탐색 
        int pa = left; // arr 를 하한부터 채우기 위한 인덱스
        int pb = 0; // buff 를 하한부터 탐색하기 위한 인덱스
        int buffSize = 0; // 버퍼에 저장한 길이

        mergeSort(arr, left, center);
        mergeSort(arr, center + 1, right);

        // 버퍼에 배열 앞부분 저장
        for (i = left; i <= center; i++) {
            buff[buffSize++] = arr[i];
        }

        // 배열 뒷부분을 버퍼에 있는 배열 앞부분과 비교하여 더 작은것 부터 하나씩 배열에 병합
        while (i <= right && pb < buffSize) {
            arr[pa++] = (buff[pb] <= arr[i]) ? buff[pb++] : arr[i++];
        }

        // 뒷부분을 다 넣었는데 버퍼에 남아있는 게 있으면
        while (pb < buffSize) {
            arr[pa++] = buff[pb++];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        buff = new int[N];
        mergeSort(arr, 0, N - 1);
        buff = null;

        for (int i = 0; i < N; i++) System.out.println(arr[i]);
    }

}
