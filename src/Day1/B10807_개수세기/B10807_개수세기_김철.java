package Day1.B10807_개수세기;

import java.io.*;
import java.util.*;

public class B10807_개수세기_김철 {
//
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int v = Integer.parseInt(br.readLine());
        
        for(int i : arr){
            if(i == v) result++;
        }
        
        bw.write(result + "");
        bw.close();
        
    }
}