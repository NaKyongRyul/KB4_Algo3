package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B11659_구간합구하기_김혜인{
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
	
	
	int N = Integer.parseInt(token.nextToken());
	int M = Integer.parseInt(token.nextToken());

	token = new StringTokenizer(bf.readLine());
	
	int [] array = new int[N+1];
	for(int i = 1; i<N+1; i++) {
		array[i] = array[i-1] + Integer.parseInt(token.nextToken());
	}
	
	for(int i = 0 ; i<M; i++) {
		
		token = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(token.nextToken());
		int b = Integer.parseInt(token.nextToken());
		
		System.out.println(array[b]-array[a-1]);
	
 }
}
}
