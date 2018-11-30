/**************************************************************************************************
 * Copyright [2018] [Martin Kelly]                                                                *
 *                                                                                                *
 * Licensed under the Apache License, Version 2.0 (the "License");                                *
 * you may not use this file except in compliance with the License.                               *
 * You may obtain a copy of the License at                                                        *
 *                                                                                                *
 * http://www.apache.org/licenses/LICENSE-2.0                                                     *
 *                                                                                                *
 * Unless required by applicable law or agreed to in writing, software                            *
 * distributed under the License is distributed on an "AS IS" BASIS,                              *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                       *
 * See the License for the specific language governing permissions and                            *
 * limitations under the License.                                                                 *
 **************************************************************************************************/

package src.main.java.javadatastructuresalgorithms.Algorithms;

import java.util.*;

public class QuasiGroupGenerator {
	
	private int size;
	private int numbersNeeded;
	private HashMap<Integer, Set<Integer>> row = new LinkedHashMap<>();

	public QuasiGroupGenerator(int size) {
		setSize(size);
		createQuasiPart1();
		createQuasiPart2();
	}

	public QuasiGroupGenerator(String size) {
		setSize(Integer.valueOf(size));
		createQuasiPart1();
		createQuasiPart2();
	}

	private void setSize(int size) {
		this.size = size;
	}

	public int Size() {
		return size;
	}
	
	public String SizeToString() {
		return Integer.toString(size);
	}
	
	public int SizeToStringLength() {
		return String.valueOf(size).length();
	}

	public Set<Integer> getRow(int index) {
		return this.row.get(index);
	}

	public Object[] getColumn(int index) {
		return getRow(index).toArray();
	}

	public int getValue(int index1, int index2) {
		return (int) getColumn(index1)[index2];
	}

	/* Create a single Quasigroup of size */
	private Set<Integer> createQuasiPart1() {
		Random rand = new Random();
		numbersNeeded = Size();
		
		if(Size() < numbersNeeded) {
			throw new IllegalArgumentException("Can't ask for more numbers than are available");
		}

		Set<Integer> arr = new LinkedHashSet<>();

		while(arr.size() < numbersNeeded) {
			Integer next = rand.nextInt(Size());
			arr.add(next);
		}
		return arr;
	}

	/* Create a Quasigroup of order size aka(Latin Square) */
	private void createQuasiPart2() {
		for(int i = 0; i < Size(); i++) {
			this.row.put(i, createQuasiPart1());
		}
	}

	/* Prints QuasiGroup as a Table */
	public void print() {
		for(int i = 0; i < Size(); i++) {
			this.row.put(i, createQuasiPart1());
			System.out.println(/*"Row " + i + */getRow(i));
		}
	}
}
