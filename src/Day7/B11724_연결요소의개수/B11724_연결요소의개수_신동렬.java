package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_신동렬 {

    static int N;
    static int M;
    static ArrayList<Integer>[]graph;
    static boolean isVisited[];
    static int ans;
    private static void dfs(int num){
        Stack<Integer> stack = new Stack<>();
        isVisited[num]=true;
        stack.push(num);
        while (!stack.isEmpty()){
            int now=stack.pop();

            for(int next: graph[now]){
                if(isVisited[next])continue;
                stack.push(next);
                isVisited[next]=true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N= Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        graph=new ArrayList[N+1];
        for (int i=0; i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st=new StringTokenizer(bf.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        isVisited=new boolean[N+1];
        ans=0;
        for(int i=1; i<=N ;i++){
            if(isVisited[i]==false){
                dfs(i);
                ans+=1;
            }

        }
        System.out.println(ans);
    }
}
