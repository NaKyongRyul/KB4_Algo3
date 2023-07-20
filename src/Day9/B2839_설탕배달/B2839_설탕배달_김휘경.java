package Day9.B2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B2839_설탕배달_김휘경 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        boolean check = false;

        while(N >= 0){
            if(N == 0){
                check = true;
                break;
            }

            if(N % 5 == 0){
                count += N / 5;
                check = true;
                break;
            }else{
                N -= 3;
                count++;
            }

        }


        if(!check){
            System.out.println(-1);

        }else{
            System.out.println(count);

        }


    }
}
