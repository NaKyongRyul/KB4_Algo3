package Day9.B2839_설탕배달;

import java.io.*;
import java.util.*;

public class B2839_설탕배달_김철 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int tempN = N;
        boolean remain = true;

        while(true) {
            if(tempN % 5 == 0) {
                count += tempN / 5;
                break;
            }
            tempN -= 3;
            count += 1;
            if(tempN == 0){
                break;
            }
            else if(tempN < 3) {
                remain = false;
                break;
            }
        }

        if(remain) bw.write(count+"");
        else bw.write("-1");
        bw.close();
    }
}
