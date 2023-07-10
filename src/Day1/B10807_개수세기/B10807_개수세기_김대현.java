package Day1.B10807_개수세기;

public class B10807_개수세기_김대현 {
  public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt=0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int v = sc.nextInt();
	
		for(int i =0; i<N; i++) {
			if(arr[i]==v) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
