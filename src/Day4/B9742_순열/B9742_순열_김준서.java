package Day4.B9742_순열;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B9742_순열_김준서 {
    static String string;
    static int[] selection;
    static int N, terminate;
    static int cur_num;
    static  boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        String input = "";
        while((input=br.readLine())!=null &&!input.isEmpty()) {
            terminate = 0;
            st = new StringTokenizer(input, " ");
            string = st.nextToken().toString();
            N = Integer.parseInt(st.nextToken());
            int tp = 1;
            for (int i = 1; i <= string.length(); i++) {
                tp*=i;
            }
            if (tp < N) {
                System.out.println(string+" "+  N+" = " + "No permutation");
                continue;
            }
            visited = new boolean[N];
            cur_num = 1;
            selection = new int[string.length()];
            permutation(0);
        }
    }

    public static void permutation(int level) {
        if (terminate==1) {
            return;
        }
        if (level == string.length()){
            if (cur_num == N) {
                System.out.print(string+" "+  N+" = ");
                for (int i = 0; i < string.length(); i++) {
                    System.out.print(string.charAt(selection[i]));
                }
                System.out.println();
                terminate=1;
                return;
            }
            cur_num++;
            return;
        }
        for (int i = 0; i < string.length(); i++) {
            if (visited[i]) {
                continue;
            }
            selection[level]=i;
            visited[i]=true;
            permutation(level+1);
            visited[i]=false;
        }
    }
}
