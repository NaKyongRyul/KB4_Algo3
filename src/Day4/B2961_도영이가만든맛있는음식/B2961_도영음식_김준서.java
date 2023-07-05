package Day4.B2961_도영이가만든맛있는음식;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B2961_도영음식_김준서  {
    static int[] shin;
    static int[] ssun;
    static int[] shinAvail;
    static int[] ssunAvail;
    static boolean [][] arr;
    static boolean [] isSelected;
    static int cnt,N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer=1000000000;
        N = sc.nextInt();
        shin = new int[N];
        ssun = new int[N];
        int num=1;
        for (int i = 0; i < N; i++) {
            num*=2;
        }
        arr = new boolean[num][N];
        for (int i = 0; i < N; i++) {
            shin[i] = sc.nextInt();
            ssun[i] = sc.nextInt();
        }
        shinAvail = new int[num];
        ssunAvail = new int[num];
        isSelected = new boolean[N];
        subset(0);
        for (int i = 0; i < num - 1; i++) {
            if (shinAvail[i] == 0) {
                shinAvail[i]=1;
            }
            for (int j = 0; j < N; j++) {
                if (arr[i][j]) {
                    shinAvail[i] *= shin[j];
                    ssunAvail[i] += ssun[j];
                }
            }
        }
        for (int i = 0; i < num - 1; i++) {
            answer=Math.min(answer,Math.abs(shinAvail[i]-ssunAvail[i]));
        }
        System.out.println(answer);
    }

    public static void subset(int number) {
        if(number==N){
            for (int i = 0; i < N; i++) {
                arr[cnt][i]=isSelected[i];
            }
            cnt++;
            return;
        }
        isSelected[number]=true;
        subset(number + 1);
        isSelected[number]=false;
        subset(number+1);
    }


}