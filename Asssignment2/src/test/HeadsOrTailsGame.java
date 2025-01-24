package test;
import java.util.*;
 class HeadOrTails{
	 public String getHeadsOrTails() {
		 
		 int tossResult= (int)(Math.random()*2);
		 
		 
		 return switch (tossResult) {
		 case 0 -> "Heads";
		 case 1 -> "Tails";
		 default -> throw new IllegalStateException("Unexpected value : "+ tossResult);
		 }; 
	 }
 }
 
 class HeadsOrTailsTest{
	 public static void main(String args[]) {
		 HeadOrTails coin =  new HeadOrTails();
		 
		 String result= coin.getHeadsOrTails();
		 
		 System.out.println("The coin toss result is: "+ result);
		 
	 }
 }
 
 public class HeadsOrTailsGame{
	 
	 public static void main(String args[]) {
		 
		 HeadOrTails coin= new HeadOrTails();
		 
		 
		 Scanner input = new Scanner(System.in);
		 
		 System.out.println("Guess the coin toss(Heads/Tails)");
		 
		 String guess= input.nextLine().trim();
		 
		 
		 if(!guess.equalsIgnoreCase("Heads")&&!guess.equalsIgnoreCase("Tails")) {
			 System.out.println("Invalid input.Please enter Heads/Tails");
			 return;
			 
		 }
		 
		 String tossResult = coin.getHeadsOrTails();
		 
		 System.out.println("The coin result is : "+ tossResult);
		 
		 if(guess.equalsIgnoreCase(tossResult)) {
			 System.out.println("You win!! Your guess is correct");
			 
		 }else {
			 System.out.println("You loose!! Your guess was incorrect");
		 }
		 
		 input.close();
		 
		 
	 }
	 
	 
	 
	 
	 
	 
 }
