package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class B2164_카드2_김휘경 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){ // 큐에 1~N 카드 넣기
            queue.offer(i);
        }


        while(queue.size() > 1){
            //System.out.println(queue);
            queue.poll(); // 제일 위에 있는 카드 버리기

            // 맨 위 카드 빼고 제일 아래로 넣기
            int target = queue.poll();
            queue.offer(target);
        }

        System.out.println(queue.peek());

    }

}