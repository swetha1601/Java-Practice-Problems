package test;
import java.util.*;
public class Nofpalindrome {
	public static void main(String args[]) {
		
		System.out.println("Enter Number:");
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			int num=i;
			int reverse=0;
			while(i!=0) {
				int digit=i%10;
				reverse=reverse*10+digit;
				i/=10;
			}
			if(num==reverse) {
				System.out.println(num);
			}
			i=num;
			
			
		}
		sc.close();
	}

}
