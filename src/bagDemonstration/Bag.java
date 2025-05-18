package bagDemonstration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Bag<T> implements Iterable<T> {
	private List<T> items;
	
	/**
	 * Bag Is Implemented with the ArrayList Method
	 */
	public Bag() {
		this.items = new ArrayList<>();
	}
	
	/**
	 * Method For Adding Items To The Bag
	 * @param item user inputed item
	 */
	public void add(T item) {
		this.items.add(item);
	}
	
	/**
	 * Method For Removing An Item From The Bag
	 * @param item user inputed item
	 */
	public void remove (T item) {
		this.items.remove(item);
	}
	
	/**
	 * Method For Checking Whether An Item is In The Bag
	 * @param item user inputed item
	 * @return if item in bag returns true, if not returns false
	 */
	public boolean contains(T item) {
		return this.items.contains(item);
	}
	
	/**
	 * Method For Counting The Amount Of A Specific Element In The Bag
	 * @param item user inputed item
	 * @return integer of amount of specific item in bag
	 */
	public int count(T item) {
		int count = 0;
		for(T i : items) {
			if(i.equals(item)) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Iterator Method
	 */
	@Override
	public Iterator<T> iterator() {
		return this.items.iterator();
	}

	/**
	 * Main Method Allows User To Run All Associated Commands For Adding,Removing,Checking, And Iterating Through Items
	 * @param args
	 */
	public static void main(String[] args) {
	    boolean runProgram = true;
	    Scanner scnr = new Scanner(System.in);
	    Bag<String> newBag = new Bag<>();
	    String userInput;

	    System.out.println("Please Choose An Operation");
        System.out.println("To Add An Item To The Bag Please Type ADD");
        System.out.println("To Remove An Item From The Bag Please Type REMOVE");
        System.out.println("To Check For An Item In The Bag Please Type CHECK");
        System.out.println("To See How Many Duplicate Elements Are In THe Bag Type Count");
        System.out.println("To List All Current Items Please Type LIST");
        System.out.println("To Close The Program Please Type X");
	    
        /**
         * Loop Will Prompt Users To Run A Command To Do Something With The Bag.
         */
	    while (runProgram) {
	    	System.out.println("COMMAND: ");
	        String userCMD = scnr.nextLine();

	        switch (userCMD.toLowerCase()) {
	            case "add":
	                System.out.print("Enter item to add: ");
	                userInput = scnr.nextLine();
	                newBag.add(userInput);
	                break;
	            case "remove":
	                System.out.print("Enter item to remove: ");
	                userInput = scnr.nextLine();
	                newBag.remove(userInput);
	                break;
	            case "check":
	                System.out.print("Enter item to check: ");
	                userInput = scnr.nextLine();
	                System.out.println(newBag.contains(userInput) ? "Item is in the bag." : "Item not found.");
	                break;
	            case "count":
	            	System.out.print("Enter item to count: ");
	            	userInput = scnr.nextLine();
	            	System.out.println(newBag.count(userInput));
	            	break;
	            case "list":
	                System.out.println("Current items in the bag:");
	                for (String item : newBag) {
	                    System.out.println("- " + item);
	                }
	                break;
	            case "x":
	                scnr.close();
	                runProgram = false;
	                System.out.println("Goodbye.");
	                break;
	            default:
	                System.out.println("Invalid command. Try again.");
	        }
	    }
	}
	
}
