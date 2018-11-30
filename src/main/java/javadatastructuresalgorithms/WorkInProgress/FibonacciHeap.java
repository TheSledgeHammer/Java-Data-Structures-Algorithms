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

package src.main.java.javadatastructuresalgorithms.WorkInProgress;


import src.main.java.javadatastructuresalgorithms.DataStructures.CircularDoublyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FibonacciHeap<V> {

    private int degree = 0;
    private boolean marked = false;
    private int size = 0;
    public CircularDoublyLinkedList<FibonacciNode<V>> root;
    private FibonacciNode<V> min = null;

    public FibonacciHeap(V value) {
        root = new CircularDoublyLinkedList<FibonacciNode<V>>();
    }

    public FibonacciHeap(V value, double priority) {
        root = new CircularDoublyLinkedList<FibonacciNode<V>>();
    }

    public FibonacciHeap() {
        root = null;
    }

    public FibonacciNode<V> Min() {
        if(isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        return min;
    }

    public boolean isEmpty() {
        return min == null;
    }

    public int size() {
        return size;
    }

    public FibonacciNode<V> enQueue(V value, double priority) {
        checkPriority(priority);
        FibonacciNode<V> node = new FibonacciNode<V>(value, priority);
        node.setParent(node);

        min = mergeLists(min, node);
        size++;
        return node;
    }

    public static <V> FibonacciHeap<V> merge(FibonacciHeap<V> one, FibonacciHeap<V> two) {
        FibonacciHeap<V> result = new FibonacciHeap<V>();
        result.min = mergeLists(one.min, two.min);
        result.size = one.size + two.size;

        one.size = two.size = 0;
        one.min = null;
        two.min = null;
        return result;
    }

    public FibonacciNode<V> deQueueMin() {
        if(isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        size--;
        FibonacciNode<V> node = min;

        if(node.Next() == min) {
            min = null;
        } else {
            min.Prev().setNext(min.Next());
            min.Next().setPrev(min.Prev());
            min = min.Next();
        }

        if(node.Child() != null) {
            FibonacciNode<?> curr = node.Child();
            do {
                curr.setParent(null);
                curr = curr.Next();
            } while(curr != node.Child());
        }
        min = mergeLists(min, node.Child());
        if(min == null) {
            return node;
        }

        List<FibonacciNode<V>> treeTable = new ArrayList<>();

        List<FibonacciNode<V>> toVisit = new ArrayList<>();

        for(FibonacciNode<V> curr = min; toVisit.isEmpty() || toVisit.get(0) != curr; curr = curr.Next()) {
            toVisit.add(curr);
        }
        for(FibonacciNode<V> curr : toVisit) {
            while (true) {
                while (curr.getDegree() >= treeTable.size()) {
                    treeTable.add(null);
                }
                if (treeTable.get(curr.getDegree()) == null) {
                    treeTable.set(curr.getDegree(), curr);
                    break;
                }
                FibonacciNode<V> other = treeTable.get(curr.getDegree());
                treeTable.set(curr.getDegree(), null);
                FibonacciNode<V> Min = (other.getPriority() < curr.getPriority() ? other : curr);
                FibonacciNode<V> Max = (other.getPriority() < curr.getPriority() ? curr : other);
                Max.Next().setPrev(Max.Prev());
                Max.Prev().setNext(Max.Next());

                Max.setNext(Max.Prev());
                Max.setPrev(Max);
                Min.setChild(mergeLists(Min.Child(), Max));
                Max.setParent(Min);
                Max.setMarked(false);
                Min.setDegree(degree++);
               curr = Min;
            }
            if(curr.getPriority() <= min.getPriority()) {
                min = curr;
            }
        }
        return node;
    }

    public void delete(FibonacciNode<V> node) {

    }

    private static <V> FibonacciNode<V> mergeLists(FibonacciNode<V> one, FibonacciNode<V> two) {
        if(one == null && two == null) {
            return null;
        } else if (one != null && two == null) {
            return one;
        } else if(one == null && two != null) {
            return two;
        } else{
            FibonacciNode<V> nodeOne = one.Next();
            one.setNext(two.Next());
            one.Next().setPrev(one);
            two.setNext(nodeOne);
            two.Next().setPrev(two);
            return one.getPriority() < two.getPriority() ? one : two;
        }
    }

    private void checkPriority(double priority) {
        if (Double.isNaN(priority)) {
            throw new IllegalArgumentException(priority + " is invalid.");
        }
    }
}
