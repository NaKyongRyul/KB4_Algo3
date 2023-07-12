package Day3.B2493_탑;

import java.util.*;
import java.io.*;

class Info{
    int h;
    int idx;

    public Info(int h, int idx){
        this.h = h;
        this.idx = idx;
    }
}

public class B2493_탑_이도원 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Info> s = new Stack<>();
        for (int i = 1; i <= n; i++){
            int h = Integer.parseInt(st.nextToken());

            s.add(new Info(0, 0));
            while(!s.empty() && (s.peek().h < h)) s.pop();

            if (!s.empty()) System.out.print(s.peek().idx + " ");
            else System.out.print(0 + " ");
            s.add(new Info(h, i));
        }
    }
}
