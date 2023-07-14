package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2961_도영이가만든맛있는음식_이소형 {

    static int n;
    static boolean[] isSelected;
    static int[] sList;
    static int[] bList;
    static int result = 999999999;
    static int temp;
    static int sSum = 1;
    static int bSum = 0;
    static int cnt = 0;

    static void subset(int i) {

        if (i == n) {
            if (cnt < 1) return;
            temp = Math.abs(sSum - bSum);
            if (temp < result) result = temp;
            return;
        }

        if (isSelected[i]) {
            sSum /= sList[i];
            bSum -= bList[i];
            cnt--;
        }
        isSelected[i] = false;
        subset(i + 1);

        if (!isSelected[i]) {
            sSum *= sList[i];
            bSum += bList[i];
            cnt++;
        }
        isSelected[i] = true;
        subset(i + 1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        isSelected = new boolean[n];

        sList = new int[n];
        bList = new int[n];
        String[] strings;
        for (int i = 0; i < n; i++) {
            strings = reader.readLine().split(" ");

            sList[i] = Integer.parseInt(strings[0]);
            bList[i] = Integer.parseInt(strings[1]);
        }

        subset(0);
        System.out.println(result);
    }
}
