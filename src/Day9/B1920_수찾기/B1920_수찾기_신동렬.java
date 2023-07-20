package Day9.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_신동렬 {

    static int N,M;
    static int result[];

    static int arr[];

    //바이너리 서치 N 번 해서 결과값 배열에 담고, 출력

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(bf.readLine());
        arr=new int[N];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N; i++)
        {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        M=Integer.parseInt(bf.readLine());
        result=new int[N];
        st=new StringTokenizer(bf.readLine());
        Arrays.sort(arr);
        for(int i=0;i<M; i++)
        {
            bst(arr,Integer.parseInt(st.nextToken()));
        }

    }
    public static void bst(int[] arr, int target){
        int low=0;
        int high=arr.length-1;

        while(low<=high){
            int mid= (low+high)/2;
            if (arr[mid]==target) {System.out.println(1);
                return;}
            else if (arr[mid]>target) high=mid-1;
            else low=mid+1;
        }
        System.out.println(0);


    }
}
