package test;
import java.util.*;
public class Pattern{
    public static void main(String[] args) {
        int n;
        System.out.println("Enter rows:");
        Scanner sc= new  Scanner (System.in);
        n=sc.nextInt();
        
        
        
        for (int i = 1; i <= n; i++) {
            
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            
            for (int num = 1; num <= i; num++) {
                System.out.print(num + " ");
            }
            
            System.out.println();
        }
    }
}
