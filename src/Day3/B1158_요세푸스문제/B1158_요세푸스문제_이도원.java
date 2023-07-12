package Day3.B1158_요세푸스문제;


import java.util.*;
import java.io.*;

public class B1158_요세푸스문제_이도원 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        int idx = 0;
        while(answer.size() < n){
            int cnt = 0;

            while(true){
                if (!visited[idx]) cnt++;
                if (cnt == k) break;

                if (idx == n - 1) idx = 0;
                else idx++;
            }

            visited[idx] = true;
            answer.add(arr[idx]);
        }

        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < n - 1; i++){
            sb.append(answer.get(i));
            sb.append(", ");
        }
        sb.append(answer.get(n - 1));
        sb.append(">");

        System.out.println(sb);
    }
}