package bagDemonstration;

import java.util.*;

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
	 * Method For Getting The Numerical Count Of Elements Within A Bag
	 * @return number of elements in the bag as an Integer
	 */
	public int size() {
		return this.items.size();
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
	 * Method For Creating A New Bag That Has Only One Copy Of Each Element In The bag
	 * @return New Bag With Only One Of Each Item From The Original List
	 */
	public Bag<T> distinct(){
		Bag<T> distinctBag = new Bag<>();
		Set<T> seen = new HashSet<>();
		for(T item : this.items) {
			if(!seen.contains(item)) {
				seen.add(item);
				distinctBag.add(item);
			}
		}
		for (T item : distinctBag) {
			System.out.println("- " + item);
		}
		return distinctBag;
	}
	
	/**
	 * Merges otherBag with NewBag
	 * @param otherBag Bag 2
	 */
	public void merge(Bag<T> otherBag) {
		for (T item : otherBag) {
			this.add(item);
		}
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
	    /**
	     * Will Determine Which Bag The Methods Will Affect
	     * False (Default) Will Edit newBag
	     * True Will Edit otherBag
	     */
	    boolean editBag = false;
	    Bag<String> newBag = new Bag<>();
	    Bag<String> otherBag = new Bag<>();
	    String userInput;

	    System.out.println("Please Choose An Operation");
	    System.out.println("To Switch Between Bags Type SWITCH");
        System.out.println("To Add An Item To The Bag Please Type ADD");
        System.out.println("To Remove An Item From The Bag Please Type REMOVE");
        System.out.println("To Check For An Item In The Bag Please Type CHECK");
        System.out.println("To Get A Count Of How Many Items Are In The Bag Type SIZE");
        System.out.println("To See How Many Duplicate Elements Are In THe Bag Type COUNT");
        System.out.println("To List All Current Items Please Type LIST");
        System.out.println("To Make A Distinct List That Removes Duplicates Type DISTINCT");
        System.out.println("To Merge Bag 1 And Bag 2 Type MERGE");
        System.out.println("To Close The Program Please Type X");
	    
        /**
         * Loop Will Prompt Users To Run A Command To Do Something With The Bag.
         */
	    while (runProgram) {
	    	System.out.println("COMMAND: ");
	        String userCMD = scnr.nextLine();

	        switch (userCMD.toLowerCase()) {
	        	case "switch":
	        		if(editBag == false) {
	        			editBag = true;
	        			System.out.println("Now Editing Bag 2");
	        		} else {
	        			editBag = false;
	        			System.out.println("Now Editing Bag 1");
	        		}
	        		break;
	            case "add":
	                System.out.print("Enter item to add: ");
	                userInput = scnr.nextLine();
	                if(editBag == false) {
	                	newBag.add(userInput);	
	                } else {
	                	otherBag.add(userInput);
	                }
	                break;
	            case "remove":
	                System.out.print("Enter item to remove: ");
	                userInput = scnr.nextLine();
	                if(editBag == false) {
	                	newBag.remove(userInput);
	                } else {
	                	otherBag.remove(userInput);
	                }
	                break;
	            case "check":
	                System.out.print("Enter item to check: ");
	                userInput = scnr.nextLine();
	                if(editBag == false) {
	                	System.out.println(newBag.contains(userInput) ? "Item is in the bag." : "Item not found.");	
	                } else {
	                	System.out.println(otherBag.contains(userInput) ? "Item is in the bag." : "Item not found.");	
	                }
	            case "size":
	            	if(editBag == false) {
		            	System.out.println("There Are " + newBag.size() + " Items In The Bag!");	
	            	} else {
		            	System.out.println("There Are " + otherBag.size() + " Items In The Bag!");
	            	}
	            	break;
	            case "count":
	            	System.out.print("Enter item to count: ");
	            	userInput = scnr.nextLine();
	            	if(editBag == false) {
	            		System.out.println(newBag.count(userInput));	
	            	} else {
	            		System.out.println(otherBag.count(userInput));
	            	}
	            	break;
	            case "list":
	                System.out.println("Current items in the bag:");
	                if(editBag == false) {
		                for (String item : newBag) {
		                    System.out.println("- " + item);
		                }
	                } else {
		                for (String item : otherBag) {
		                    System.out.println("- " + item);
		                }
	                }
	                break;
	            case "distinct":
	            	if(editBag == false) {
	            		newBag.distinct();
	            	} else {
	            		otherBag.distinct();
	            	}
	            	break;
	            case "merge":
	            	newBag.merge(otherBag);
	            	System.out.println("Bag 2 Successfully Merged");
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
