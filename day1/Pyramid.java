package test;
import java.util.*;
public class Pyramid {
	public static void main(String args[]) {
        int n;
        System.out.println("Enter no. of rows:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        
        for (int i = n; i >= 1; i--) {
            
            for (int space = 0; space < n - i; space++) {
                System.out.print(" ");
            }
            
            
            int k = 0;
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j <= i) {
                    System.out.print(j + " ");
                } else {
                    System.out.print((2 * i - j) + " ");
                }
            }
            
            
            System.out.println();
        }
    }
	
	

}
