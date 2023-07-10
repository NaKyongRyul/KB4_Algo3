import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10807_개수세기_송봉섭 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 1줄 1줄 읽음 , 훨편함

        int N = Integer.parseInt(reader.readLine());

        String str = reader.readLine();
        String [] strings = str.split(" "); 

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }


        int v = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int i: arr) {
            if (i == v){
                count++;
            }
        }
        System.out.println(count);

    }
}
