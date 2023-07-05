package Day6.B11047_동전0;



import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B11047_동전0_김준서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] dong = new int[N];
        for (int i = 0; i < N; i++) {
            dong[N-1-i]=sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int cur = dong[i];
            while (target >= cur) {
                target -= cur;
                answer +=1;
            }
        }
        System.out.println(answer);
    }


}