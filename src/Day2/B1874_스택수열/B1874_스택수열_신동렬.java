package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_신동렬 {
        public static void main(String[] args) throws IOException {
            int temp=1;
            boolean error=false;
            StringBuilder sb= new StringBuilder();

            Stack<Integer> stack=new Stack<>();
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int k= Integer.parseInt(bf.readLine());


            for (int i=0;i<k;i++){
                int N=Integer.parseInt(bf.readLine());
                for(; temp<=N;temp++){
                    stack.push(temp);
                    sb.append("+").append("\n");
                }
                if(stack.peek()==N){
                    stack.pop();
                    sb.append("-").append("\n");
                }else {error=true;}
            }
            if (error) System.out.println("NO");
            else System.out.println(sb);
        }

    }


}
