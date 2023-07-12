package Day3.B1158_요세푸스문제;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B1158_요세푸스문제_이소형 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder builder = new StringBuilder();
        builder.append("<");
        int cur, idx = k - 1;
        while (list.size() > 1) {
            cur = list.remove(idx);

            builder.append(cur);
            builder.append(", ");
            idx = (idx + k - 1) % list.size();
        }

        builder.append(list.get(0));
        builder.append(">");
        System.out.println(builder);
    }
}
