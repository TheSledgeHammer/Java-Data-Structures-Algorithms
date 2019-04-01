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

package javadatastructuresalgorithms;

import javadatastructuresalgorithms.Algorithms.DammAlgorithm;
import javadatastructuresalgorithms.Algorithms.DammAlgorithmStore;
import javadatastructuresalgorithms.Algorithms.QuasiGroupGenerator;
import javadatastructuresalgorithms.DataStructures.*;
import javadatastructuresalgorithms.WorkInProgress.FibonacciHeap;
import javadatastructuresalgorithms.WorkInProgress.HashList;
import javadatastructuresalgorithms.WorkInProgress.Trie;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<ArrayList<Integer>> LL = new LinkedList<>();

        //Lists
        SinglyLinkedList<Integer> SLL = new SinglyLinkedList<>();
        DoublyLinkedList<Integer> DLL = new DoublyLinkedList<>();
        CircularDoublyLinkedList<Integer> CDLL = new CircularDoublyLinkedList<>();

        //Maps
        CircularDoublyLinkedMap<Integer, String> CDLM = new CircularDoublyLinkedMap<>();

        //Tables: Like Google Guava's table structure
        CircularDoublyLinkedTable<Integer, Integer, Integer> CDLT = new CircularDoublyLinkedTable<>();

        //Trees
        BinaryTree<Integer> BT = new BinaryTree<>();
        TernaryTree<Integer> TT = new TernaryTree<>();
        BinaryIndexedTree<Integer> BIT = new BinaryIndexedTree<>();
        TernaryIndexedTree<Integer> TIT = new TernaryIndexedTree<>();
        Trie<String> trie = new Trie<>();//WIP

        //Hashing
        HashList<String> HL = new HashList<>();//WIP
        HashTableOA<Integer, String> HTOA = new HashTableOA<>();//WIP
        HashTableSC<Integer, String> HTSC = new HashTableSC<>();//WIP

        //Heaps
        FibonacciHeap<Integer> fibHeap = new FibonacciHeap<>(); //WIP

        //Algorithms:
        QuasiGroupGenerator QGG = new QuasiGroupGenerator(10);
        DammAlgorithm DA = new DammAlgorithm(100, 10, true);//WIP: Validation of Checksum
        DammAlgorithmStore DAS = new DammAlgorithmStore();
    }
}