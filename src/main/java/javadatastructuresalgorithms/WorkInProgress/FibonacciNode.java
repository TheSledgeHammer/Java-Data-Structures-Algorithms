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

public class FibonacciNode<V>  {

    private V value;
    private double priority;
    private int degree;
    private boolean marked;
    private FibonacciNode<V> parent;
    private FibonacciNode<V> child;
    private FibonacciNode<V> next;
    private FibonacciNode<V> prev;

    public FibonacciNode(V value) {
        setValue(value);
        setPriority(priority);
        setDegree(degree);
        setMarked(marked);
        setParent(parent);
        setChild(child);
        setNext(next);
        setPrev(prev);
    }

    public FibonacciNode(V value, double priority) {
        setValue(value);
        setPriority(priority);
        setDegree(degree);
        setMarked(marked);
        setParent(parent);
        setChild(child);
        setNext(next);
        setPrev(prev);
    }

    public void setParent(FibonacciNode<V> parent) {
        this.parent = parent;
    }

    public void setChild(FibonacciNode<V> child) {
        this.child = child;
    }

    public void setNext(FibonacciNode<V> next) {
        this.next = next;
    }

    public void setPrev(FibonacciNode<V> prev) {
        this.prev = prev;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public FibonacciNode<V> Parent() {
        return parent;
    }

    public FibonacciNode<V> Child() {
        return child;
    }

    public FibonacciNode<V> Next() {
        return next;
    }

    public FibonacciNode<V> Prev() {
        return prev;
    }

    public V getValue() {
        return value;
    }

    public double getPriority() {
        return priority;
    }

    public int getDegree() {
        return degree;
    }

    public boolean getMarked() {
        return marked;
    }
}
