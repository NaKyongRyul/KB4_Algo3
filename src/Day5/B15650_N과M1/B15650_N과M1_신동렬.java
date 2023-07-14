package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M1_신동렬 {

    static int N;
    static int R;
    static int select[];

    static int arr[];
    private static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String str[] =bf.readLine().split(" ");
        N=Integer.parseInt(str[0]);
        R=Integer.parseInt(str[1]);
        arr=new int[N];
        for(int i=0; i<N;i++){
            arr[i]=  i+1;
        }
        select = new int [R];
        isSelected= new boolean[N]; // 초기화

        combination(0,0);
    }

    private static void combination(int idx, int size) {
        if(size ==R){
            for(int i=0; i<R; i++) System.out.print(arr[select[i]]+" ");
            System.out.println();
            return;}

        //재귀확장
        for (int i=idx; i<N; i++){
            if(isSelected[i])continue;

            isSelected[i]=true;
            select[size]=i;
            combination(i,size+1);

            isSelected[i]=false;// 여기까지는 그냥 순열

        }
    }
}

