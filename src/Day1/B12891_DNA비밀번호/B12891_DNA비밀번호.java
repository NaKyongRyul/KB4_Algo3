package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		String dna = bf.readLine();
		
		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		int a= Integer.parseInt(token.nextToken());
		int c = Integer.parseInt(token.nextToken());
		int g= Integer.parseInt(token.nextToken());
		int t = Integer.parseInt(token.nextToken());
		
		int numA=0;
		int numC=0;
		int numG=0;
		int numT = 0;
		
		for (int i=0; i<Integer.parseInt(token.nextToken()); i++) {
		
			;
		}
	}

}
