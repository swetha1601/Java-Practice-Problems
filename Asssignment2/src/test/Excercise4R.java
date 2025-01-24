package test;
import java.util.*;
public class Excercise4R {
	 private static int matrix[][] = {
		        {1, 7, 3, 9, 5, 3},
		        {6, 2, 3},
		        {7, 5, 1, 4, 0},
		        {1, 0, 2, 9, 6, 3, 7, 8, 4}
		    };
	 
	  public static void main(String args[]) {
		  
		  
		  if(args.length != 1) {
			  System.out.println("Please provide a single a intger between 0 and 9:");
			  return;
		  }
		  
		  int target = -1;
	        try {
	            target = Integer.parseInt(args[0]);
	        } catch (NumberFormatException e) {
	            System.out.println("Error: The argument must be an integer.");
	            
	            return;
	        }
		  
		  if(target < 0 || target >9) {
			  System.out.println("The number must be between 0  and 9");
			  return;
			  
		  }
		  
		  boolean found= false;
		  
		  for(int i=0;i<matrix.length;i++) {
			  for (int j=0;j<matrix[i].length;j++) {
				  if (matrix[i][j]==target) {
					  System.out.println("Number "+ target+" found at position: (  "+ i+ " , "+ j + " )");
					  found=true;
					  break;
				  }
			  }
			  if(found) break;
		  }
		  if(!found) {
			  System.out.println("Number "+ target + " not found in the matrix");
		  }
		  
		  	  
		 
	  }
	

}
