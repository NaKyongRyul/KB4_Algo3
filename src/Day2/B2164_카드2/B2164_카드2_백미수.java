package Day2.B2164_ī��2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_ī��2_��̼� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine()); //N���� ī��
		
		Queue <Integer> que = new ArrayDeque<Integer>();
		
		for(int i = 1; i<=N; i++) {
			que.add(i);
		}	//N���� ī�� ����
		
		for(int i=0; i<N-1; i++) {
			que.remove();	//�� �� ������
			int peek = que.peek();	//�� ���� �ִ� ����
			
			que.remove();
			que.add(peek);
		}
		System.out.println(que.peek());
	}

}
