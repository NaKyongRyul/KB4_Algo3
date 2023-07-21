import java.util.Arrays;

public class B2750_병합정렬_황지현 {
	public static void mergeSort(int [] arr,int [] tmp, int left, int right) {
		if(left>=right) return;
		int center=(left+right)/2;
		
		//쪼개기
		mergeSort(arr,tmp, left,center);
		mergeSort(arr,tmp, center+1,right);
		
		//병합
		int ld=left;
		int rd=center+1;
		int cd=left;
		while(ld<=center&&rd<=right) {
			if(arr[ld]<=arr[rd]) {
				tmp[cd++]=arr[ld++];
			}
			else {
				tmp[cd++]=arr[rd];
				}
			}
		if(ld>center) {
			for(int i=rd;rd<=right;i++) {
				tmp[i]=arr[i];
			}
		}
		else {
			for(int i=ld;ld<=center;i++) {
				tmp[i]=arr[i];
			}
		}
		for(int i=0;i<=right;i++) {
			arr[i]=tmp[i];
		}

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] arr=new int[n];
		int [] tmp=new int[n];
		for (int i=0;i<n;i++) arr[i]=sc.nextInt();
		mergeSort(arr,tmp,0,n-1);
		System.out.println(Arrays.toString(arr));
	}
}
