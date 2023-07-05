package Day8.B9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663_NQueen_박창현 {
    static int[] arr;
    static int[] sel;
    static boolean[] isSel;
    static int r;
    static int count = 0;

    static void action(int nr) {//,int[] sel, boolean[] isSel) {
        if (nr == r) {
//            for (int i = 0; i < r; i++) {
//                System.out.print(sel[i]);
//            }
//            System.out.println();
            count++;
            return;
        }
        for (int i = 0; i < r; i++) {
            if (isSel[i]) continue;//직선검사

            boolean flag = false;//대각선검사
            for (int j = nr - 1; j >= 0; j--) {
                if (Math.abs(sel[j] - i) == nr - j) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;


            isSel[i] = true;
            sel[nr] = i;
            action(nr + 1);//,sel.clone(),isSel.clone());
//            System.out.println(i+"\t"+ Arrays.toString(isSel) + "\t" + Arrays.toString(sel));
            isSel[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        r = Integer.parseInt(bf.readLine());
        arr = new int[r];
        sel = new int[r];
        isSel = new boolean[r];
        action(0);
        System.out.println(count);
    }
}
