package Day10.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_신동렬 {

/*
0 a b  => 합집합 -> union
1 a b => find
find(0)==find(2)
find(0)==find(3)
연결 하고 찍으면 true.
 */

    static int n,m;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        StringBuilder sb= new StringBuilder();
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n+1];
        for(int i=1; i<=n;i++){
            arr[i]=i;
        }
        for(int i=0; i<m; i++){
            st= new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            if(a==0){
                union(b,c);
            }
            else if(a==1){
                if(find(b)==find(c)) sb.append("YES"+"\n");
                else sb.append("NO"+"\n");
            }
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if(x==arr[x] )return x;
        return arr[x]=find(arr[x]);
    }

    private static void union(int x, int y) {
        x=find(x);
        y=find(y);
        if(x!=y){
            if (x<y) arr[y] =x;
            else arr[x]=y;
        }
    }
}

