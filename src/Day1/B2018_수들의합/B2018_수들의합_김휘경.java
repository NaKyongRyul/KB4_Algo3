package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_김휘경 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int count = 0;
        for(int start = 1; start <= n; start++) {
            sum = start;
            for (int end = start + 1; end <= n; end++) {

                sum += end;
                if (sum == n) {
                    count += 1;
                    break;
                }else if(sum > n){
                    break;
                }

            }

        }
        System.out.println(count+1);

    }
}
