package test;
import java.util.*;
public class Palindrome {
	public static void main(String args[]) {
		int n;
		System.out.println("Enter number:");
		Scanner obj=new Scanner(System.in);
		n=obj.nextInt();
		int temp=n;
		int reverse=0;
		while(temp!=0) {
			int digit=temp%10;
			reverse=reverse*10+digit;
			temp/=10;
		}
		if(n==reverse) {
			System.out.println("Is Palindrome");
		}else {
			System.out.println("Not Palindrome");
		}
		
	}

}
