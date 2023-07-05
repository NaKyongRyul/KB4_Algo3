package Day7.B11724_연결요소의개수;

import java.util.Scanner;

public class B11724_연결요소의개수_김태선 {
	
    public static int[][] arr;
    public static int[] visit;
    public static int count = 0;
 
    public static void dfs(int x) {
 
        if (visit[x] == 1) {
            return;
        } else {
            visit[x] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[x][i] == 1 && visit[i] != 1) {
                dfs(i);
            }
        }
 
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n + 1][n + 1];
        visit = new int[n + 1];
 
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
 
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0) {
                dfs(i);
                count++;
            }
        }
 
        System.out.println(count);
 
    }
}