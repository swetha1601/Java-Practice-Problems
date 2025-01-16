package test;
import java.util.Scanner;

public class sumofn {
	
	public static void main(String args[]) {
		int sum=0;
		int n;
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter number:");
		n=scanner.nextInt();
		for(int i=0;i<=n;i++) {
			sum+=i;
		}
		System.out.println(sum);
		
		
	}

}
