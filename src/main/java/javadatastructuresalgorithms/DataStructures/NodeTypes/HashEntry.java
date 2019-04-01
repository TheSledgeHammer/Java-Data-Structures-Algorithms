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

package javadatastructuresalgorithms.DataStructures.NodeTypes;

public class HashEntry<K,V> {

    private K key;
    private V value;
    private HashEntry<K,V> next;
    private HashEntry<K,V> prev;

    public HashEntry(K key, V value) {
        setKey(key);
        setValue(value);
        setNext(null);
        setPrev(null);
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(HashEntry<K,V> next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setPrev(HashEntry<K,V> prev) {
        this.prev = prev;
    }

    public HashEntry<K,V> Next() {
        return next;
    }

    public HashEntry<K,V> Prev() {
        return prev;
    }
}
