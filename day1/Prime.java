package test;
import java.util.*;
public class Prime {
	public static void main(String args[]) {
		int n;
		System.out.println("Enter number:");
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		
		int count =0;
		int  sum=0;
		int num=2;
		while(count < n) {
			boolean isPrime=true;
			for(int i=2;i<=Math.sqrt(num);i++) {
				if(num%i==0) {
					isPrime=false;
					break;
				}
			}
			if(isPrime) {
				System.out.println(num+ " ");
				sum+=num;
				count++;
			}
			num++;
		}
		double average = (double) sum/n;
		
		System.out.println("Sum of first "+n+" prime num:"+ sum);
		System.out.println("Avg of first "+n+" prime num:"+average);
		
		sc.close();
	}

}
