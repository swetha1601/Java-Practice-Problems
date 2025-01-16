package test;
import java.util.*;

public class Nofarmstong {
	public static void main(String args[]) {
		
		for(int i=1;i<1000;i++) {
			int num=i;
			int sum=0;
			
			while(i!=0) {
				int x=i%10;
				sum+= Math.pow(x, 3);
				i/=10;
				
			}
			if(num==sum) {
				System.out.println(num);
			}
			
			i=num;
		}	
	}
}
