package Structures;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class QuasiGroupGenerator {
	
	private int size;
	private Set<Integer> copy = new LinkedHashSet<>();
	
	/**
	 * Max: The desired Quasigroup size
	 * @param sets the max Quasigroup size
	 */
	public QuasiGroupGenerator(int size) {
		setSize(size);
		setCopyOf(copy);
	}
	
	/**
	 * Max: The size (use getMax() over String.length())
	 * @param sets the max Quasigroup size from a String.
	 */
	public QuasiGroupGenerator(String size) {
		setSize(Integer.valueOf(size));
		setCopyOf(copy);
	}

	private void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * The value of Max
	 * @return Max value
	 */
	public int getSize() {
		return size;
	}
	
	public String getMaxAsString() {
		return Integer.toString(size);
	}
	
	public int getMaxStringLength() {
		return String.valueOf(size).length();
	}
	
	private void setCopyOf(Set<Integer> copy) {
		this.copy = copy;
	}
	
	public Set<Integer> CopyOf() {
		return copy;
	}
	
	/**
	 * Create a Quasigroup of Order specified by max
	 * @return Quasigroup of value max
	 */
	public Set<Integer> createQuasigroup() {
		Random rand = new Random();
		int max = getSize();
		int numbersNeeded = max;
		
		if(max < numbersNeeded) {
			throw new IllegalArgumentException("Can't ask for more numbers than are available");
		}
		
		Set<Integer> arr = new LinkedHashSet<>();
		
		while(arr.size() < numbersNeeded) {
			Integer next = rand.nextInt(max) + 1;
			arr.add(next);
		}
		copy.addAll(arr);
		return arr;
	}
	
	public void createQuasiTable(int i, int row) {
		LinkedHashMap<Integer, Set<Integer>> arr = new LinkedHashMap<>();
		arr.put(i, copy);
		System.out.println(arr.get(row));
	}
	
	/**
	 * Prints Quasigroup in a tabled format
	 */
	public void printQuasigroup() {
		for(int i = 0; i < createQuasigroup().size(); i++) {	
			System.out.println(createQuasigroup());
		}		
	}
}
