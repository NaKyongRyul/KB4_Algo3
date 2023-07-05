package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_김예린 {
    static int [] select;
    static boolean [] isSelected;
    static int R, M, N;
    static  void combination(int r, int start){
        if(r==M){
            for (int i=0; i<M; i++) System.out.print(select[i] + " ");
            System.out.println();
            return;
        }

        for (int i=start; i<=N; i++){
            select[r] = i;
            combination(r+1, i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int [M];
        isSelected = new boolean[N];

        combination(0, 1);
    }
}
