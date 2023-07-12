package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_조승빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Tower> stack = new Stack<>();

        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int towerHeight = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (towerHeight <= stack.peek().height) {
                    System.out.print(stack.peek().num + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) System.out.print("0 ");
            stack.add(new Tower(i, towerHeight));
        }
    }
}

class Tower {
    int num;
    int height;

    protected Tower(int num, int height) {
        this.num = num;
        this.height = height;
    }
}
