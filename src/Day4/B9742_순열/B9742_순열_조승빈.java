package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B9742_순열_조승빈 {
    static ArrayList<StringBuilder> result = new ArrayList<>();
    static boolean[] visited;
    static char[] words;
    static char[] select;
    static String line;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            line = st.nextToken();
            target = Integer.parseInt(st.nextToken());

            words = line.toCharArray();
            visited = new boolean[words.length];
            select = new char[words.length];

            permutation(0);

            if(result.size() < target)
                System.out.println(input + " = No permutation");
            else
                System.out.println(input + " = " + result.get(target - 1));

            result.clear();
        }
    }

    private static void permutation(int selectionCnt) {
        if(selectionCnt == line.length()) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < select.length; i++)
                sb.append(select[i]);
            result.add(sb);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            select[selectionCnt] = words[i];
            visited[i] = true;
            permutation(selectionCnt + 1);
            visited[i] = false;
        }
    }
}
