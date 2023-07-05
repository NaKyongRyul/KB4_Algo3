package Day6.B2839_설탕배달;


import java.util.Scanner;

public class B2839_설탕배달_김준서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int target = sc.nextInt();
        int x,y;
        x = target / 5;
        while (x>=0) {
            y = (target - 5 * x) / 3;
            int temp = 5 * x + 3 * y;
            if (temp == target) {
                System.out.println(x+y);
                return;
            }
            else{
                x -= 1;
            }
        }
        System.out.println(-1);
    }
}