
public class MTest {

	public static void main(String[] args) {
		int[] arr = {6,4,3,7,1,9,8};
		
		mergeSort(arr,arr.length);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	static int[] buff;
	public static void mergeSort(int[] a, int n) {
		buff = new int[n];
		
		mSort(a,0,n-1);
	}
	public static void mSort(int[] a, int left, int right) {
		if(left<right) {
			int center = (left+right)/2;
			int p =0;
			int j= 0;
			int k=left;
			
			mSort(a,left,center);
			mSort(a,center+1,right);
			
			for(int i=left;i<=center;i++) {
				buff[p++]=a[i];
			}
			
		}
	}
}
