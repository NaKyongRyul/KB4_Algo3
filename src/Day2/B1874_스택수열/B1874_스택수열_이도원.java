package Day2.B1874_스택수열;

import java.util.*;
import java.io.*;

public class B1874_스택수열_이도원 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int curNum = arr[idx];
        for (int i = 1; i <= n; i++){
            s.add(i);
            sb.append("+\n");

            while(!s.empty() && s.peek() == curNum){
                s.pop();
                sb.append("-\n");
                if (idx < (n - 1)) curNum = arr[++idx];
            }
        }

        if(s.empty()) System.out.print(sb);
        else System.out.println("NO");
    }
}