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

//Basic HashTable that uses Seperate Chaining
public class HashTableSC<K,V> {

    private LinkedList<HashEntry<K,V>> bucket;
    private HashEntry<K,V> head;
    private int size = 0;

    private int bucketSize = 10;
    private double loadFactor = 0.7;
    private int TotalLoad = (int) (loadFactor * bucketSize);

    public HashTableSC(K key, V value) {
        setBucketSize(bucketSize);
        setLoadFactor(loadFactor);
        setTotalLoad();
        head = BucketEntry(key, value);
        //head = new HashEntry<K,V>(key, value);
        bucket = new LinkedList<HashEntry<K,V>>();
    }

    public HashTableSC(K key, V value, int bucketSize, double loadFactor) {
        setBucketSize(bucketSize);
        setLoadFactor(loadFactor);
        setTotalLoad();
        head = BucketEntry(key, value);
        //head = new HashEntry<K,V>(key, value);
        bucket = new LinkedList<HashEntry<K,V>>();
    }

    public HashTableSC() {
        setBucketSize(bucketSize);
        setLoadFactor(loadFactor);
        setTotalLoad();
        head = null;
        bucket = new LinkedList<HashEntry<K,V>>();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        HashEntry<K,V> node = new HashEntry<K,V>(key, value);
        if(size() == getTotalLoad()) {
            reHash();
        }
        if(size == 0 || head == null) {
            node.setNext(node);
            node.setPrev(node);
            head = node;
        } else {
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public V get(K key) {
        int idx = HashFunction(key);
        HashEntry<K,V> node = head;//bucket.get(idx);
        while(node != null) {
            if(node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.Next();
        }
        return null;
    }

    private HashEntry<K,V> BucketEntry(K key, V value) {
        HashEntry<K,V> temp = new HashEntry<K,V>(key, value);
        int idx = HashFunction(key);
        if(bucket.isEmpty()) {
            for(int i = 0; i < getBucketSize(); i++) {
                bucket.add(i, null);
            }
        }
        bucket.set(idx, temp);
        return bucket.get(idx);
    }

    private void reHash() {
        HashEntry<K,V> temp = head;
        setBucketSize((getBucketSize() * 2) + 1);
        setTotalLoad();
        int idx = HashFunction(temp.getKey());
        if(bucket.isEmpty()) {
            for(int i = 0; i < getBucketSize(); i++) {
                bucket.add(i, null);
            }
        }
        bucket.set(idx, temp);

        for(int j = 0; j < size; j++) {
            bucket.set(idx, temp);
        }
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

    private int HashFunction(K key) {
        return (key.hashCode() % getBucketSize());//Integer.lowestOneBit(key.hashCode() * key.hashCode()) & Integer.toHexString(key.hashCode()).hashCode() & 0x7fffffff % getBucketSize();
    }
}
/*
    public static int HashFunction(int key) {
        System.out.println(Integer.highestOneBit(key * capacity) % capacity);
        System.out.println(Integer.toHexString(key).hashCode() % capacity);
        System.out.println(Integer.toHexString(key * capacity).hashCode() % capacity);
        System.out.println(Integer.lowestOneBit(key * key) % capacity);
        System.out.println((Integer.lowestOneBit(key * key) & Integer.toHexString(key).hashCode() & 0x7fffffff) % capacity);

        return Integer.toHexString(key * capacity).hashCode() % capacity;
    }
            System.out.println();
        System.out.println("Load " + getTotalLoad());
        System.out.println("Buckets " + getBucketSize());
        System.out.println("Size " + size);
    */