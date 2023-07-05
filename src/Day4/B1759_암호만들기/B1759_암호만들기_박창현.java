package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_박창현 {
    static StringBuilder result= new StringBuilder();
    static char[] arr;
    static int N;
    static int R;
    static int[] sel;
    static boolean[] isSel;

    static void combination(int r, int s) {
        StringBuilder sb = new StringBuilder();
        if (r == R) {
            boolean flag = false;
            int count = 0;
            sb.setLength(0);
            for (int i = 0; i < R; i++) {
                if(arr[sel[i]]=='a'|| arr[sel[i]]=='e'||arr[sel[i]]=='i'||arr[sel[i]]=='o'||arr[sel[i]]=='u')
                    flag=true;
                else count++;
                sb.append(arr[sel[i]]);
            }
            if (flag&&count>=2) result.append(sb).append("\n");
            return;
        }
        for (int i = s; i < arr.length; i++) {
            if (isSel[i]) continue;
            isSel[i] = true;
            sel[r] = i;
            combination(r + 1, i);
            isSel[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        sel = new int[L];
        isSel = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().toCharArray()[0];
        }
        Arrays.sort(arr);
        N = C;
        R = L;
        combination(0,0);
        System.out.println(result);
    }
}
