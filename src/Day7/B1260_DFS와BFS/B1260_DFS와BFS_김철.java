package Day7.B1260_DFS와BFS;

import java.io.*;
import java.util.*;

public class B1260_DFS와BFS_김철 {
    static int N,M,V;
    static ArrayList<Integer>[] arrList;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        V = Integer.parseInt(token.nextToken());

        arrList = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            arrList[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            arrList[start].add(end);
            arrList[end].add(start);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(arrList[i]);

        }

        visited = new boolean[N+1];
        DFS재귀(V);
        bw.write("\n");

        visited = new boolean[N+1];
        DFS스택(V);
        bw.write("\n");

        visited = new boolean[N+1];
        BFS(V);
        bw.write("\n");

        bw.close();
    }

    static void DFS재귀(int nowNode) throws IOException{
        bw.write(nowNode + " ");
        visited[nowNode] = true;
        if(arrList[nowNode].size() > 0){
            for(int i : arrList[nowNode]){
                if(visited[i]) continue;
                DFS재귀(i);
            }
        }
        else return;
    }

    static void DFS스택(int nowNode) throws IOException{
        bw.write(nowNode + " ");
        visited[nowNode] = true;
        stack.push(nowNode);
        while(!stack.isEmpty()){
        	// flag로 스택에서 제거할지 말지 결정
            boolean flag = false;
            int now = stack.peek();
            
            // 자식을 탐색 과정 중에
            for(int i : arrList[now]){
                if(visited[i]) continue;
                visited[i] = true;
                stack.push(i);
                bw.write(i + " ");
                flag = true;
                break;
            }
            if(!flag) stack.pop();
        }
    }

    static void BFS(int nowNode) throws IOException{
        bw.write(nowNode + " ");
        visited[nowNode] = true;
        q.offer(nowNode);
        while(!q.isEmpty()){
            int now = q.poll();

            for(int i : arrList[now]){
                if(visited[i]) continue;
                visited[i] = true;
                q.offer(i);
                bw.write(i + " ");
            }
        }
    }
}
