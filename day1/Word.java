package test;
import java.util.*;
public class Word {
	public static void main(String args[]) {
		System.out.print("Enter number:");
		String[] arr= {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		String output="";
		while(n>0) {
			output=arr[n%10]+output;
			n=n/10;
			
		}
		System.out.println(output);
		
	}
	
	
	

}
