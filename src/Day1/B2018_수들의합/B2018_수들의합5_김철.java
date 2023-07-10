package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2018_수들의합5_김철 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=1; i<=N; i++){
            int temp = i;
            for(int j=i+1; j<=N; j++){
                temp += j;
                if(temp == N) {
                    count++;
                    break;
                }
                else if(temp > N) break;
            }
        }

        bw.write((count+1)+"");
        bw.close();
    }
}
