package Day5.B1182_부분수열의합;

import java.util.Scanner;



public  class B1182_부분수열의합_김준서 {
    static boolean[] isVisited;
    static boolean[][] list;
    static int N, cnt =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int S = sc.nextInt();
        int sum = 1, answer = 0;
        int[] arr = new int[N];
        isVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            sum *= 2;
        }
        list = new boolean[sum][N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        jib(0);
        for (int i = 0; i < sum - 1; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (list[i][j]) {
                    temp += arr[j];
                }
            }
            if (temp == S) {
                answer+=1;
            }
        }
        System.out.println(answer);
    }

    public static void jib(int level) {
        if (level == N){
            for (int i = 0; i < N; i++) {
                list[cnt][i] = isVisited[i];
            }
            cnt++;
            return;
        }
        isVisited[level]=true;
        jib(level + 1);
        isVisited[level]=false;
        jib(level + 1);
    }
}
