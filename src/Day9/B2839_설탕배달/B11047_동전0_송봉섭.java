package Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class B11047_동전0_송봉섭 {

    static int N;
    static int K;
    static int[] money;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        N = Integer.parseInt(strings[0]);
        K = Integer.parseInt(strings[1]);
        money = new int[N];

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        Integer[] moneySort = Arrays.stream(money).boxed().toArray(Integer[]::new);
        Arrays.sort(moneySort, Collections.reverseOrder());

//        System.out.println(Arrays.toString(moneySort));
        count = 0;
        int sum = 0;

        for (int n : moneySort) {
            while (sum+n <= K) {
                sum += n;
                count++;
            }
            if (sum == K) {
                break;
            }
        }

        System.out.println(count);
    }
}
