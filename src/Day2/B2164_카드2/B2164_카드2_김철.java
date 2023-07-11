package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_카드2_김철 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
        	q.offer(i);
        }
        
        while(q.size() > 1) {
        	q.poll();
        	int change = q.poll();
        	q.offer(change);
        }
        bw.write(q.poll()+"");
        bw.close();
	}
}
