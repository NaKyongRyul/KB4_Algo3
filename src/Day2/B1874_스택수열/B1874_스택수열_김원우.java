package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B1874_스택수열_김원우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> ans = new ArrayDeque<>();
        Deque<Integer> tmp = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> arr = new ArrayDeque<>();
        Deque<Character> sign = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        } // deque에 1~n까지 삽입

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        tmp.add(deque.removeFirst());
        sign.add('+');
        while (!deque.isEmpty()) {

            if (tmp.size() == 0) {
                tmp.add(deque.removeFirst());
                sign.add('+');
            }

            Integer chk = tmp.getLast();
            if (chk.equals(arr.getFirst())) {
                ans.addLast(chk);
                tmp.removeLast();
                arr.removeFirst();
                sign.add('-');
            }
            else{
                tmp.add(deque.removeFirst());
                sign.add('+');
            }
        }
//        System.out.println(tmp.toString());

        int flag = 0;
        while (!tmp.isEmpty()) {
            if (!tmp.getLast().equals(arr.getFirst())) {
                System.out.println("NO");
                flag = 1;
                break;
            }
            ans.add(tmp.removeLast());
            arr.removeFirst();
            sign.add('-');
        }
        if (flag == 0) {
            int len = sign.size();
            for (int i = 0; i < len; i++) {
                System.out.println(sign.removeFirst());
            }
        }
    }
}
