package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9742_순열_김원우 {

    static boolean [] visited;
    static char [] arr;
    static int target_cnt;
    static int cnt;
    static boolean flag;

//    static void permutation(int[] arr, int R, int r, int[] temp, int cnt) {
//
//    }

    static void permutation(char [] arr, int R, int r, int [] temp) {
        if (R == r) {
            cnt++;
            if (target_cnt == cnt) {
                for (int i = 0; i < R; i++) {
                    System.out.print(arr[temp[i]]);
                }
                flag = true;
                System.out.println();
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp[r] = i;
            permutation(arr, R, r + 1, temp);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;

        while ((input = br.readLine()) != null){
            st = new StringTokenizer(input);
            arr = st.nextToken().toCharArray();
            target_cnt = Integer.parseInt(st.nextToken());
            visited = new boolean[arr.length];
            cnt = 0;
            flag = false;

            int R = arr.length;
            int[] temp = new int[R];

            for (int i = 0; i < R; i++) {
                System.out.print(arr[i]);
            }
            System.out.print(" " + target_cnt + " = ");
            permutation(arr, R, 0, temp);

            if (!flag) {
                System.out.println("No permutation");
            }


        }

    }
}
