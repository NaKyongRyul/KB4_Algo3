package Day2.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B12891_DNA비밀번호_전민형 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int ran;
		int leng;
		int a,c,g,t,an,cn,gn,tn,cnt;

		an=0;
		cn=0;
		gn=0;
		tn=0;
		cnt=0;

		String str = reader.readLine();
		String [] com = str.split(" ");

		ran = Integer.parseInt(com[0]);
		leng = Integer.parseInt(com[1]);


		str = reader.readLine();
		com = str.split("");

		str = reader.readLine();

		String [] ranN = str.split(" ");

		a = Integer.parseInt(ranN[0]);
		c = Integer.parseInt(ranN[1]);
		g = Integer.parseInt(ranN[2]);
		t = Integer.parseInt(ranN[3]);



		int left = 0;
		int right = 1;


		for(right = 1; right<=ran; right++) {




			switch(com[right-1]) {

			case "A" : an++;
			break;

			case "C" : cn++;
			break;

			case "G" : gn++;
			break;

			case "T" : tn++;
			}
			


			if(right-left==leng) {
				
				if(a<=an && c<=cn && g<=gn && t<=tn) {
					cnt++;
				}

				left++;
				switch(com[left-1]) {

				case "A" : an--;
				break;

				case "C" : cn--;
				break;

				case "G" : gn--;
				break;

				case "T" : tn--;
				}


					
				}


		}


		System.out.println(cnt);

	}

}


