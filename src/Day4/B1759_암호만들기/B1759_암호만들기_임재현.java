import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_임재현 {
    static int L, C;
    static char[] arr;
    static char[] selected;

    static void combination(int count, int index) {
        if (count == L) {
            int checker = 0;
            for (int i = 0; i < L; i++) {
                if (selected[i] == 'a'
                        || selected[i] == 'e'
                        || selected[i] == 'i'
                        || selected[i] == 'o'
                        || selected[i] == 'u')
                    checker++;
            }
            if (checker < 1 || L - checker < 2)
                return;
            for (int i = 0; i < L; i++)
                System.out.print(selected[i]);
            System.out.println();
            return;
        }
        for (int i = index; i < C; i++) {
            selected[count] = arr[i];
            combination(count + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        L = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        arr = new char[C];
        selected = new char[L];

        token = new StringTokenizer(br.readLine());
        int _i = 0;
        while (token.hasMoreTokens()) {
            arr[_i++] = token.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        combination(0, 0);
    }
}
