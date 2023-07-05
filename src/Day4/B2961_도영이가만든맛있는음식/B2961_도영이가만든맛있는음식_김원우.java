package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_김원우 {

    static int[] arr_bitter;
    static int[] arr_sour;
    static int n;
    static boolean [] visited;
    static int min = Integer.MAX_VALUE;

    static void subset(int num) {
        if (num == n) {

            int bit_sum = 0;
            int sour_sum = 1;
            int flag = 0;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    flag = 1;
                    bit_sum += arr_bitter[i];
                    sour_sum *= arr_sour[i];
//
//                    System.out.println("신맛 : " + arr_sour[i] + " ");
//                    System.out.println("쓴맛 : " + arr_bitter[i] + " ");

                }
            }
            if (min > (Math.abs(bit_sum - sour_sum)) && flag == 1) {
                min = (Math.abs(bit_sum - sour_sum));
//                System.out.println("bitsum : " + bit_sum + ", soursum" + sour_sum);
            }
            return;
        }

        visited[num] = true;
        subset(num + 1);

        visited[num] = false;
        subset(num+1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr_bitter = new int[n];
        arr_sour = new int[n];
        visited = new boolean[n];



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr_sour[i] = Integer.parseInt(st.nextToken());
            arr_bitter[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(Math.abs(arr_sour[0] - arr_bitter[0]));
            return;
        }

        subset(0);
        System.out.println(min);

    }
}
