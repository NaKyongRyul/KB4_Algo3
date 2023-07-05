package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2164_카드2_박창현 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>();
        int card = 0;
        int count = 1;
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        while (!q.isEmpty()){
            card=q.poll();
            if(count%2==0){
                q.add(card);
            }
            count++;
        }
        System.out.println(card);
    }
}
