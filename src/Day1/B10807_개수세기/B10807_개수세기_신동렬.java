package Day1.B10807_개수세기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B10807_개수세기_신동렬{
    public static void main(String[] args) throws IOException {
//        //입력받기- BufferedReader
//        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));//system.in: 외부입력
//        int N =Integer.parseInt(reader.readLine());// 한줄씩 읽음
//
//        System.out.println(N);
//
//        String str=reader.readLine();// 다음줄을 하나의 문자열로 읽어와서 str에 저장
//        String [] strs =str.split(" "); //인자안에다가 쪼개는 기준을 넣어줌. 문자열인 str을 스페이스를 기준으로 쪼개서 스트링 배열에 넣어줌
//        //ex Stirng s= "2023-07-03"; S.split('-'); =>  ['2023','07','03']
//
//        int [] arr= new int[N];
//        for(int i=0; i<strs.length;i++)
//        {
//            arr[i]=Integer.parseInt(strs[i]);
//        }
//        System.out.println(Arrays.toString(arr));
//        str= reader.readLine();
//        int v=Integer.parseInt(str); // 입력받은 String 타입의 s를 int로 변환
//        System.out.println(v);

        //입력받기 2- Scanner
        int cnt=0;
        Scanner sc=new Scanner(System.in);
        int N =sc.nextInt(); //입력으로 들어오는 가장 가까운 정수값을 불러옴. 형변환 안해도 됨.
        //배열 선언
        int [] arr=new int[N];
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();// N번돌때마다 배열 값 하나하나 저장
        }
        int v= sc.nextInt();

        for (int j=0; j<arr.length; j++){
            if (arr[j] == v) cnt++;
        }
        System.out.println(cnt);
    }
}
