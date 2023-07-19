package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_신동렬 {

    static int N;
    static int M;
    static int [][] arr;
    static int []dx={-1,1,0,0};
    static int [] dy={0,0,-1,1};
    static boolean [][]isVisited;


    public static void main(String[] args) throws IOException {


        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        isVisited=new boolean[N][M];

        arr=new int[N][M];
        for(int i=0; i<N;i++){
            String[] input=bf.readLine().split("");
            for(int j=0; j<M; j++){

                arr[i][j]=Integer.parseInt(input[j]);
            }
        }
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);

    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        isVisited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowrow = now[0];
            int nowcor = now[1];
            if(nowrow==N-1 && nowcor==M-1)break;
            for (int i = 0; i < 4; i++) {
                int nxtrow = nowrow + dx[i];
                int nxtcor = nowcor + dy[i];

                if (nxtrow < 0 || nxtrow >= N || nxtcor < 0 || nxtcor >= M) continue;
                if (arr[nxtrow][nxtcor] == 0) continue;
                if (isVisited[nxtrow][nxtcor]) continue;
                queue.add(new int[]{nxtrow, nxtcor});
                arr[nxtrow][nxtcor] = arr[nowrow][nowcor] + 1;
                isVisited[nowrow][nxtcor] = true;

            }


        }
    }
}
