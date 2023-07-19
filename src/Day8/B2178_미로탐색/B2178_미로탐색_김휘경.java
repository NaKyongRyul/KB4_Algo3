package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

 
public class B2178_미로탐색_김휘경 {

    static boolean[][] isVisited;
    static int N;
    static int M;
    static int[][] graph;

    // 동서남북 이동
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    static boolean check(int x, int y){ // 이동 가능한 범위인지 확인
        if(x >= 0 && x < N && y >= 0 && y < M){
            return true;
        }else{
            return false;
        }
    }

    static void bfs(int x, int y){ // 최단거리 구하가ㅣ
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        isVisited[x][y] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            isVisited[node.x][node.y] = true; // 방문체크
            //System.out.println(node.x + ", " + node.y);

            for(int i = 0; i < 4; i++){
                // 이동
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if(check(nextX, nextY)){ // 이동 범위 화인
                    if(!isVisited[nextX][nextY] && graph[nextX][nextY] == 1){ // 이동 가능한 경우
                        // 이동
                        queue.offer(new Node(nextX, nextY));
                        isVisited[x][y] = true;
                        graph[nextX][nextY] += graph[node.x][node.y]; // 이동거리 갱신
                    }

                }
            }

        }



    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        // 초기화
        isVisited = new boolean[N][M];
        graph = new int[N][M];

        // 그래프 생성
        for(int i = 0; i < N; i ++){
            String line = br.readLine();
            String[] line2 = line.split("");
            for(int j = 0; j < line2.length; j++){
                graph[i][j] = Integer.parseInt(line2[j]);
            }
        }

        // 최소값 구하기 - bfs
        bfs(0, 0);
        System.out.println(graph[N-1][M-1]);


    }
}
