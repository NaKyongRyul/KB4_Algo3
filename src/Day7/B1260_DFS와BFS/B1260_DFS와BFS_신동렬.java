package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260_DFS와BFS_신동렬 {

    static int N;
    static int M;
    static int V;

    static ArrayList<Integer>[] graph;

    static StringBuilder result;
    static boolean isVisited[];
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());


        //인접리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1; i<N+1; i++) Collections.sort(graph[i]);

        result = new StringBuilder();
        isVisited = new boolean[N + 1];
        dfs(V);
        System.out.println(result);


        isVisited = new boolean[N + 1];
        result=new StringBuilder();
        bfs(V);
        System.out.println(result);
    }



    private static void dfs(int v){
        Stack<Integer> stack = new Stack<>();
        if(isVisited[v]==false){
            stack.push(v);
            isVisited[v]= true;}

        while(!stack.isEmpty()){
            int now= stack.pop();
            result.append(now+" ");
            for(int next: graph[now]){
                if (isVisited[next])continue;
                dfs(next);
            }

        }

    }

    private static void bfs(int v) {
        Queue<Integer> queue= new ArrayDeque<>();
        isVisited[v]=true;
        queue.add(v);
        while(!queue.isEmpty()){
            int now= queue.poll();
            result.append(now+" ");
            for(int next: graph[now]){
                if(!isVisited[next])
                {   isVisited[next]=true;
                    queue.add(next);}
            }

        }
    }
}
