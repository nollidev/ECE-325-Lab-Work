package ece325.labs.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** 
 * Finish this class.
 */
public class EquipmentInventory {

	/** The list of all your equipment objects */
	ArrayList<Equipment> inventory;
	/** The number of objects per type of equipment, grouped by the String description of a type */
	HashMap<String, Integer> inventoryCount;

	/** 
	 * Create an EquipmentInventory object by initializing the inventory and inventoryCount objects.
	 */
	public EquipmentInventory() {
		inventory = new ArrayList<Equipment>();
		inventoryCount = new HashMap<String, Integer>();
	}

	/**
	 * Add e to the inventory, and if the add is successful, increase the number of that equipment type in your inventoryCount.
	 * Make sure that you cannot accidentally add the same object twice.
	 * @param e The equipment object to add
	 */
	public void add(Equipment e) {
		final int EMPTY = -1;

		if (getInventoryCount(e) == EMPTY) { inventory.add(e); }	// BUG: WILL ADD EQUIPMENT TWICE
		increaseInventoryCount(e);
	}

	/**
	 * Remove e from the inventory and if successful, decrease the number of that equipment type in your inventoryCount.
	 * @param e The equipment object to remove
	 */
	public void remove(Equipment e) {
		decreaseInventoryCount(e);
	}

	/**
	 * Increase the inventoryCount for the type of equipment of e by 1.
	 * If it does not exist in the inventoryCount yet, add the type to the inventoryCount.
	 * Note: this method should be private, but to allow running unit tests on it (and make our lives easier when marking),
	 * we made this method protected. The method should never be called outside of the class. 	 
	 * @param e The type of equipment for which we want to increase the inventoryCount
	 */
	protected void increaseInventoryCount(Equipment e) {
		int count = getInventoryCount.get(e);
		++count;
		if (count == 0) { ++count; }
		inventoryCount.put(e.toString(), count);
	}

	/**
	 * Decrease the inventoryCount for the type of equipment of e by 1.
	 * If the inventoryCount for this type is now 0, remove the type from the inventoryCount.
	 * If the inventoryCount does not contain this type of equipment, do nothing.
	 * Note: this method should be private, but to allow running unit tests on it (and make our lives easier when marking),
	 * we made this method protected. The method should never be called outside of the class. 	 
	 * @param e The type of equipment for which we want to decrease the inventoryCount
	 */
	protected void decreaseInventoryCount(Equipment e) {
		final int DNE = -2;

		int count = getInventoryCount(e);
		--count;
		if (count == 0) {
			inventoryCount.remove(e.toString());
			inventory.remove(indexOf(e));
		}
		else if (count != DNE) { inventoryCount.put(e.toString(), count); }
	}

	/** 
	 * Return the number of times this type of equipment occurs in the inventory.
	 * If it doesn't occur in the inventory, return -1 (to indicate that something went wrong somewhere).
	 * @param e
	 * @return
	 */
	public Integer getInventoryCount(Equipment e) {
		if (inventoryCount.get(e) == null) { return -1; }
		return inventoryCount.get(e);
	}
	
	/**
	 * Return the String representation of the EquipmentInventory.
	 * It should look similarly to the following:
	 * [EquipmentInventory: Guitar: 3, Stool: 3, Chair: 1, Keyboard: 2]
	 * (after adding 3 guitars, 3 stools, 1 chair and 2 keyboards).
	 * The order in which the types are printed does not matter.
	 * @return the string representation of the EquipmentInventory
	 */
	public String toString() {
		int SIZE = inventoryCount.size();
		int loopCount = 0;
		
		String result = "[EquipmentInventory: ";

		for (String e: inventoryCount.keySet()) {
			++loopCount;
			result.concat(e + ": " + inventoryCount.get(e));
			if (loopCount != SIZE) { result.concat(", "); }
		}

		result.concat("]");

		return result;
	}

	public static void main(String[] args) {
		
	}
}
