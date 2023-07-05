package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9742_순열_임재현 {
    static char[] arr;
    static int N;
    static boolean[] visited;
    static int count;
    static char[] selected;
    static boolean flag;

    static void permutation(int r) {
        if (r == arr.length) {
            count++;
            if (count == N) {
                for (int i = 0; i < arr.length; i++)
                    System.out.print(arr[i]);
                System.out.print(" " + N + " = ");
                for (int i = 0; i < selected.length; i++)
                    System.out.print(selected[i]);
                System.out.println();
                flag = true;
            }
        }
        if (count >= N)
            return;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            selected[r] = arr[i];
            permutation(r + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            String str = input.split(" ")[0];
            N = Integer.parseInt(input.split(" ")[1]);
            arr = str.toCharArray();
            visited = new boolean[arr.length];
            selected = new char[arr.length];
            flag = false;
            count = 0;
            permutation(0);

            if (flag)
                continue;
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i]);
            System.out.println(" " + N + " = No permutation");
        }
    }
}
