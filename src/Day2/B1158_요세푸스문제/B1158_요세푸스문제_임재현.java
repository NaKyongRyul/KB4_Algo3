package Day2.B1158_요세푸스문제;

import java.util.ArrayList;
import java.util.Scanner;

public class B1158_요세푸스문제_임재현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int idx = -1;
        System.out.print("<");
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
        while (true) {
            idx = (idx + K) % N;
            int target = arr.get(idx);
            System.out.print(target);
            arr.remove(idx);
            N--;
            idx--;
            if (arr.size() == 0)
                break;
            System.out.print(", ");
        }
        System.out.println(">");

        sc.close();
    }
}
