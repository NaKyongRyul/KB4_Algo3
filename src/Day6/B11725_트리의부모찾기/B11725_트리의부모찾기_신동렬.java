package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_신동렬 {

        static int N;
        static boolean [] isVisited;
        static ArrayList<Integer> tree[];
        static int result [];
        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N= Integer.parseInt(st.nextToken());
            isVisited=new boolean[N+1];
            tree=new ArrayList[N+1];
            result=new int[N+1];

            //1.N개만큼 빈 리스트 만들어주기
            for(int i=0; i<N+1; i++){
                tree[i]=new ArrayList<>();
            }
            for(int i=1; i<N; i++){
                st=new StringTokenizer(bf.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                tree[a].add(b);
                tree[b].add(a);
            }
            //루트부터 재귀
            DFS(1);
            for(int i=2; i<=N; i++){
                System.out.println(result[i]);
            }
        }
        static void DFS(int num){
            isVisited[num]=true;
            for(int i:tree[num]){
                if(!isVisited[i]){
                    result[i]=num;
                    DFS(i);
                }
            }
        }
    }


