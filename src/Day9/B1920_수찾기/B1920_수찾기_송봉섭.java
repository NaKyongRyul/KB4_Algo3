package Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1920_수찾기_송봉섭 {
    static int N;
    static int[] arr;
    static int M;
    static int[] finds;

    private static int binarySearch(int[] arr, int find) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == find) return mid;
            else if (arr[mid] > find) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        String[] strings = br.readLine().split(" ");
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        finds = new int[M];
        strings = br.readLine().split(" ");
        for (int i = 0; i < strings.length; i++) {
            finds[i] = Integer.parseInt(strings[i]);
        }

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(finds));

        for (int find : finds) {
            //int ans = Arrays.binarySearch(arr, find);
            int ans = binarySearch(arr, find);
            if (ans < 0) {
                System.out.println(0);
            }else {
                System.out.println(1);
            }
        }

    }
}
