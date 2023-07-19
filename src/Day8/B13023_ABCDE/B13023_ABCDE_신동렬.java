package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_신동렬 {

    static int N;
    static int M;
    static ArrayList<Integer>[] graph;



    static boolean isVisited[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        //
        graph=new ArrayList[N];
        for(int i=0;i<N;i++)
            graph[i]=new ArrayList<>();
        for(int i=0; i<M; i++){
            st= new StringTokenizer(bf.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0; i<N; i++){
            isVisited=new boolean[N];
            dfs(i,0);
        }
        System.out.println(0);

    }

    static void dfs(int now, int depth){
        if(depth==4) {
            System.out.println(1);
            System.exit(0);// 이렇게 안해주니까 시간초과 떴다. 조건 만족했음 걍 종료해
        }
        isVisited[now]=true;
        for(int nextNode : graph[now]) {

            // 중복 확인
            if(isVisited[nextNode]) continue;

            // 다음 재귀
            isVisited[nextNode] = true;
            dfs(nextNode,depth+1);
            isVisited[nextNode]=false;
        }
    }
}

