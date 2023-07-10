package Day1.B2018_수들의합;

import java.util.*;
import java.io.*;

public class B2018_수들의합5_이도원 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int s = 1;
        int e = 1;
        int sum = 1;
        int answer = 0;

        while(true){
            if (s < e) break;

            if (sum < n) {
                s++;
                sum += s;
            }
            else {
                if (sum == n) answer++;
                sum -= e;
                e++;
            }
        }
        System.out.println(answer);
    }
}
