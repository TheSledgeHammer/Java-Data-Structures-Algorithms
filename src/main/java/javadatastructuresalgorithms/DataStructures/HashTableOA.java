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

package javadatastructuresalgorithms.DataStructures;

import javadatastructuresalgorithms.DataStructures.NodeTypes.HashEntry;

import java.util.LinkedList;
import java.util.List;

public class HashTableOA<K,V>  {

    //Hash add and retrieval WORKS!!!
    //Uses to help fix HashTableSC
    // Needs collision resolution to add to bucket at idx + n (until free space)
    // Retrieve or delete from bucket at idx + n

    public List<HashEntry<K,V>> bucketEntry1;
    private HashEntry<K,V> head;
    private int size = 0;

    private int bucketSize = 10;
    private double loadFactor = 0.7;
    private int TotalLoad = (int) (loadFactor * bucketSize);

    public HashTableOA(K key, V value) {
        head = new HashEntry<>(key, value);
        createBucketTable(bucketSize, loadFactor);
    }

    public HashTableOA() {
        head = null;
        createBucketTable(bucketSize, loadFactor);
    }

    public HashTableOA(K key, V value, int bucketSize, double loadFactor) {
        head = new HashEntry<>(key, value);
        createBucketTable(bucketSize, loadFactor);
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        HashEntry<K,V> node = new HashEntry<K,V>(key, value);
        addBucketEntry(key, value);
        //Add collision check
        ResolveHashCollision(node);
        size++;
    }

    public V get(K key) {
        int idx = Hash1(key);
        HashEntry<K,V> node = bucketEntry1.get(idx);
        while(node != null) {
            if(node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.Next();
        }
        return null;
    }

    //Todo: retrieve prev node,
    public void ResolveHashCollision(HashEntry<K,V> node) {
        int idx = Hash1(node.getKey());
        HashEntry<K,V> prevNode = node;
        int idx1 = Hash2(prevNode.getKey(), prevNode.getValue());//would be the node at idx
        if(bucketEntry1.get(idx) != null || bucketEntry1.get(idx) == node) {
            bucketEntry1.set(idx, node);
            //hashEntries1.set(idx1, prevNode);
        }
        System.out.println(idx);
        System.out.println(idx1);
    }

    private void addBucketEntry(K key, V value) {
        HashEntry<K,V> node = new HashEntry<K,V>(key, value);
        int idx = Hash1(key);
        bucketEntry1.set(idx, node);
    }

    private void removeBucketEntry(K key) {
        int idx = Hash1(key);
        bucketEntry1.remove(idx);
    }

    private void createBucketTable(int bucketSize, double loadFactor) {
        setBucketSize(bucketSize);
        setLoadFactor(loadFactor);
        bucketEntry1 = new LinkedList<HashEntry<K,V>>();
        for(int i = 0; i < getBucketSize(); i++) {
            bucketEntry1.add(i, null);
        }
    }

    public int getHash1(K key) {
        return Hash1(key);
    }

    private int Hash1(K key) {
        return (key.hashCode() % getBucketSize());
    }

    public int getHash2(K key, V value) {
        return Hash2(key, value);
    }

    private int Hash2(K key, V value) {
        return (key.hashCode() + value.hashCode()) % getBucketSize();
    }

    public void setLoadFactor(double loadFactor) {
        this.loadFactor = loadFactor;
    }

    public void setBucketSize(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    private void setTotalLoad() {
        this.TotalLoad = (int) (getLoadFactor() * getBucketSize());
    }

    public double getLoadFactor() {
        return loadFactor;
    }

    public int getBucketSize() {
        return bucketSize;
    }

    public int getTotalLoad() {
        return TotalLoad;
    }

    public HashEntry<K,V> getNode(int i) {
        HashEntry<K,V> p = null;
        if(i < size / 2) {
            p = head.Next();
            for(int j = 0; j < i; j++) {
                p = p.Next();
            }
        } else {
            p = head;
            for(int j = size - 1; j > i; j--) {
                p = p.Prev();
            }
        }
        return p;
    }
}
/*
    private MapNode<K,V> root;
    private int size = 0;

    public NormalMap(K key, V value) {
        super(key, value);
        root = new MapNode<>(key, value);
    }

    public NormalMap() {
        super(null, null);
        root = null;
    }

    public boolean isEmpty() {
        if(root == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        MapNode<K,V> node =  new MapNode<K,V>(key, value);
        if(size == 0 || root == null) {
            node.next = node;
            node.prev = node;
            root = node;
        } else {
            root.prev = node;
            node.next = root;
            root = node;
        }
        size++;
    }

    public void delete() {
        if(size == 0) {
            return;
        } else {
            System.out.println("\n deleting node " + root.value + " from start");
            root = root.next;
            size--;
        }
    }

    public MapNode<K,V> getNode(int i) {
        MapNode<K,V> p = null;
        if(i < size / 2) {
            p = root.next;
            for(int j = 0; j < i; j++) {
                p = p.next;
            }
        } else {
            p = root;
            for(int j = size; j > i; j--) {
               p = p.prev;
            }
        }
        return p;
    }

    public V get(K key) {
        while(HasNext()) {
            root.key = searchNextKey(key);
            if(root.key == key) {
                return root.value;
            }
        }
        return null;
    }

    public boolean HasNext() {
        if(root.next != null) {
            return true;
        }
        return false;
    }

    public boolean HasPrev() {
        if(root.prev != null) {
            return true;
        }
        return false;
    }

    public K searchNextKey(K key) {
        while(HasNext()) {
            root = root.next;
            if(root.key.equals(key)) {
                return root.key;
            }
        }
        return null;
    }

    public V searchNextValue(V value) {
        while(HasNext()) {
            root = root.next;
            if(root.value.equals(value)) {
                return root.value;
            }
        }
        return null;
    }

    public K searchPrevKey(K key) {
        while(HasPrev()) {
            root = root.prev;
            if(root.key.equals(key)) {
                return root.key;
            }
        }
        return null;
    }

    public V searchPrevValue(V value) {
        while(HasPrev()) {
            root = root.prev;
            if(root.value.equals(value)) {
                return root.value;
            }
        }
        return null;
    }

    public int indexOfKey(K key) {
        int index = 0;
        while(HasNext()) {
            index++;
            if(getNode(index).key.equals(key)) {
                break;
            }
        }
        if(index < 0) {
            return 0;
        }
        return index - 1;
    }

}
*/