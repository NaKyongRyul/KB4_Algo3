package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.abs;

public class B2961_도영이가만든맛있는음식_김예린 {
    static int N, cal_s, cal_b, result, cnt;
    static int[] sour, bitter;
    static boolean [] isSelected;

    static void subset(int num){
        if (num == N){

            cal_s = 1;
            cal_b = 0;
            for (int i = 0; i<N; i++){
                if (isSelected[i]) {
                    cal_s *= sour[i];
                    cal_b += bitter[i];
                }

            }
            if (cnt++ == 0) return;     // 아무 재료도 들어오지 않을 때 예외처리
            if (result > abs(cal_s - cal_b)){
                result = abs(cal_s - cal_b);

            }
            return;

        }

        isSelected[num] = false;
        subset(num + 1);

        isSelected[num] = true;
        subset(num + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        isSelected = new boolean[N];
        sour = new int[N];
        bitter = new int[N];
        result = Integer.MAX_VALUE;
        cnt = 0;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sour[i] = S;
            bitter[i] = B;
        }
        subset(0);

        System.out.println(result);
    }
}
