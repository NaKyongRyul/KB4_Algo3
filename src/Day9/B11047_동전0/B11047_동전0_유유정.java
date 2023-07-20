package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B11047_동전0_유유정 {
	static int N;
	static int K;
	static int [] coin;
	static int count;
public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String s = bf.readLine();
	String [] strs = s.split(" ");
	N = Integer.parseInt(strs[0]);
	K = Integer.parseInt(strs[1]);
	coin = new int [N];
	for(int i=0;i<N;i++) {
		coin[i]= Integer.parseInt(bf.readLine());
	}
	searchCoin(K);
	System.out.println(count);
}
private static void searchCoin(int k) {
	int now=0;
	int index = N-1;
	while(now != k) {
//		System.out.println("now : "+ now);
		if(coin[index]<=k-now && index >=0) {
			now +=coin[index];
			count++;
			}
		else index--;
	}
	return;
	
}
}
