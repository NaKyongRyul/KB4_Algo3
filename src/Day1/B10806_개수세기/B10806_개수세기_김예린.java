package Day1.B10806_개수세기;

import java.util.Scanner;

public class B10806_개수세기_김예린 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] arr = new int[N];
        int cnt = 0;

        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int f = sc.nextInt();


        for (int i = 0; i < arr.length; i ++){
            if (f == arr[i]){
                cnt ++;
            }
        }

        System.out.println(cnt);
    }
}
