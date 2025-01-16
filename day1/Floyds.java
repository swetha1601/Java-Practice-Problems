package test;
import java.util.*;
public final class Floyds {
	public static void main(String args[]) {
		int n;
		System.out.println("Enter number:");
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		int val=1;
		for(int i=1;i<n;i++) {
			
			for(int j=1;j<=i;j++) {
				System.out.print(val+" ");
				val++;
			}
			System.out.println();
			
		}
	}

}
