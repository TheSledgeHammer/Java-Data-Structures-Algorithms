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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DammAlgorithm {

    private QuasiGroupGenerator QGG;
    private ArrayList<Integer> interim = new ArrayList<>();
    private int checkDigit;
    private int value;
    public int storeIndex = 0;

    public DammAlgorithm(int value, int size) {
        setValue(value);
        setQuasiGroupGenerator(size);
    }

    public DammAlgorithm(int value, String size) {
        setValue(value);
        setQuasiGroupGenerator(size);
    }

    public DammAlgorithm(String value, int size) {
        setValue(Integer.valueOf(value));
        setQuasiGroupGenerator(size);
    }

    public DammAlgorithm(String value, String size) {
        setValue(Integer.valueOf(value));
        setQuasiGroupGenerator(size);
    }

    private void setValue(int value) {
        this.value = value;
    }

    private void setQuasiGroupGenerator(int size) {
        this.QGG = new QuasiGroupGenerator(size);
    }

    private void setQuasiGroupGenerator(String size) {
        this.QGG = new QuasiGroupGenerator(size);
    }

    public int getValue() {
        return value;
    }

    public QuasiGroupGenerator QuasiGroupGenerator() {
        return QGG;
    }

    public ArrayList<Integer> getInterimValue() {
        return interim;
    }

    public int getCheckDigit() {
        return checkDigit;
    }

    //Default is false
    public void printQuasiGroup() {
        QGG.Print();
    }

    public void CalculateChecksum() {
        int rowIndex = 0;
        int temp = 0;

        for(int i = 0; i < inputLength(); i++) {
            temp = QGG.getValue(rowIndex, ValueAtInputIndex(i));
            rowIndex = temp;
            interim.add(i, rowIndex);
        }
        checkDigit = QGG.getValue(temp, temp);
    }

    public void Validate() {
        int idx = inputLength() - 1;
        int ValidCheckDigit = QGG.getValue(ValueAtInputIndex(idx), ValueAtInputIndex(idx));
        //System.out.println(ValidCheckDigit);
    }

    private int inputLength() {
        return String.valueOf(getValue()).length();
    }

    private int ValueAtInputIndex(int index) {
        String aString = String.valueOf(getValue());
        char ch = aString.charAt(index);
        int val = Character.getNumericValue(ch);
        return val;
    }

    /*
    public String verify() {
       String s = String.valueOf(getValue());
       String t = String.valueOf(getCheckDigit());
       return s.concat(t);
    }*/
}
