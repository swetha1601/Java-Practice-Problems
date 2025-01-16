package test;
import java.util.Scanner;


public class armstrong {
	
	public static void main(String args[]) {
		int n;
		int sum=0;
		System.out.println("Enter num:");
		Scanner obj=new Scanner(System.in);
		n=obj.nextInt();
		int z=n;
		while(n!=0) {
			int x=n%10;
			sum+=Math.pow(x,3);
			n=n/10;
		}
		if(z==sum) {
			System.out.println("Armstrong number");
		}else {
			System.out.println("not Armstrong");
		}
		
	}

}
