package Day9.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정_신동렬 {

    static int [][] time;
    static int cnt;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        time=new int[N][2];
        for(int i =0 ;i<N; i++){
            st=new StringTokenizer(bf.readLine());
            time[i][0]=Integer.parseInt(st.nextToken());
            time[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time,(t1, t2)-> ((t1[1] == t2[1]) ? (t1[0] - t2[0]) : (t1[1] - t2[1])) );

        int fulltime=0;
        for(int i=0; i<N; i++){
            if(fulltime<=time[i][0]) {
                fulltime = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
