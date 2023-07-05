package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1874_스택수열_신선영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        // 정답 부호 저장
        ArrayList <String> ansList = new ArrayList<>();
        // 수열 저장
        int[] numList = new int[n];
        boolean able = true;

        // 문제풀이에 사용할 스택
        Stack <Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            numList[i] = Integer.parseInt(st.nextToken());
        }

        // 1부터 n까지의 수를 스택에 넣었다가 뽑아 놓는다
        int current = 1;

        // 수열 첫번째부터 하나씩 확인
        for (int num : numList) {
            // 현재 넣을 수 있는 값과 같은 경우: 넣었다 뺀 걸로 침
            if (num == current) {
                ansList.add("+");
                ansList.add("-");
                current++;
            }
            // 현재 넣을 수 있는 값보다 큰 경우
            else if (num > current) {
                while (current <= num) {
                    stack.push(current);
                    current++;
                    ansList.add("+");
                }
                stack.pop();
                ansList.add("-");
            }
            // 현재 넣을 수 있는 값보다 작은 경우
            else {
                if (num == stack.peek()) {
                    ansList.add("-");
                    stack.pop();
                } else {
                    able = false;
                    break;
                }

            }
        }

        if (able) {
            for (String a : ansList) {
                System.out.println(a);
            }
        } else {
            System.out.println("NO");
        }

    }
}
