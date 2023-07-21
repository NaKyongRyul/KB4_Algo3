package Day10.B1197_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1197_최소신장트리_김휘경 {
    static int[] parent;
    static Node[] edges;
    static int sum;

    static void union(int a, int b){
        // 부모 찾기
        a = find(a);
        b = find(b);

        if(a != b){ // 부모가 다른 경우
            if(a < b){
                parent[b] =a;
            }else{
                parent[a] = b;
            }

        }

    }
    static int find(int num){
        if(parent[num] == num){ // 루트 노드인 경우
            return num;
        }
        return parent[num] = find(parent[num]); // 부모찾아서 리턴 -> 여기서 시간초과 문제 해결함

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        sum = 0;

        // 초기화
        edges = new Node[E];
        parent = new int[V+1];
        Arrays.setAll(parent, i -> i); // 이거 빼먹지 말기!!

        for(int i = 0; i < E; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken()); // 가중치

            edges[i] = new Node(u, v, weight); // 간선 추가


        }

        Arrays.sort(edges, (o1, o2) -> o1.weight - o2.weight); // 정렬


        for(Node node : edges){
            if(find(node.start) != find(node.end)){ // 사이클 형성되지 않으면, 간선 선택
                union(node.start, node.end); // 연결 추가

                sum += node.weight; // 가중치 합 구하기

            }
        }

        System.out.println(sum);

        /*
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i).toString());
        }

         */


    }

    static class Node{

        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }

    }
}
