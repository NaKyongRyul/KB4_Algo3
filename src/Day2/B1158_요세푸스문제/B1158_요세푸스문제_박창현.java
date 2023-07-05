package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_박창현 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> res = new ArrayDeque<>();
        //int[] a = new int[N];
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        while (!q.isEmpty()){
            for (int i = 0; i < M-1; i++) {
                q.add(q.poll());
            }
            res.add(q.poll());
        }
        System.out.print("<");
        while (!res.isEmpty()) {
            System.out.print(res.poll());
            if (!res.isEmpty())System.out.print(", ");
        }
        System.out.print(">");
    }
}
/*

        System.out.println(M-1%arr.size());
        arr.remove(0);
        System.out.println((M-1)*2%arr.size());
        arr.remove(0);
        System.out.println((M-1)*3%arr.size());
        arr.remove(0);
 */