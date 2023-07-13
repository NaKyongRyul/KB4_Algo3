package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9742_순열_신동렬 {



    //배열 자체를 스태틱으로 선언해서 전역으로 접근가능하게 작성
    static char[] arr;

    static int R; //몇개 뽑을지
    static int [] select; //지금까지 뭘 선택했느지 저장하기 위한 배열
    static boolean [] isSelected;
    static int count;
    static int N;//찾아야하는 위치
    static boolean result;

    static Character [] ans;

    //2. 중복 허용 X 순열. 선택을 했는지 저장할 마킹 배열이 필요함
    public static void permutation(int r){

        //종료조건
        if(r==R){
            count++;
            if(count==N)
            {   result=true;
                for(int i=0; i<select.length;i++)
                    ans[i]=arr[select[i]];
            };
            return;
        }
        //재귀확장
        for(int i=0; i<arr.length;i++){
            //i=어떤걸 선택할지? i=0 => A선택 / i=1 => B선택 ==> isSelcected[i]==true면 선택된거. 아니면 선택안된거
            //선택한 경우 =skip
            if(isSelected[i]==true) continue;

            //선택
            select[r]=i;// 집어 넣고
            isSelected[i]=true; //선택했으니까 true로 바꿔줘야해

            permutation(r+1);
            if(result==true)return;

            //선택 해제
            isSelected[i]=false;// 재귀 돌고나서 다시 초기화해줘야지
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input=null;
        while ((input=bf.readLine()) != null) {
            st= new StringTokenizer(input);
            String str=st.nextToken();

            N=Integer.parseInt(st.nextToken());
            arr=str.toCharArray();
            R = arr.length;
            select = new int[R];
            isSelected = new boolean[R];
            ans=new Character[R];
            count=0;
            result=false;

            permutation(0);
            if(result){
                System.out.print(str+" "+ N+" = ");
                for (int i=0; i<R;i++)
                    System.out.print(ans[i]);
            }
            else {
                System.out.print(str + " " + N + " = " );
                System.out.print("No permutation");
            }
            System.out.println();
        }

    }
}


