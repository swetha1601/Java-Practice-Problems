package test;
import java.util.Scanner;

public class sod {
	public static void main(String args[]) {
		int sum=0;
		int n;
		System.out.println("Enter num:");
		Scanner obj=new Scanner(System.in);
		n=obj.nextInt();
		
		while(n!=0){
			
			sum+=n%10;
			n=n/10;
			
		}
		
		System.out.println(sum);
		
	}

}
