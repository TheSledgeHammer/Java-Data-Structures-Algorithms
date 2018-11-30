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

package main.java.datastructuresalgorithms.DataStructureExperimental.NodeTypes;

import main.java.datastructuresalgorithms.DataStructureExperimental.NodeInterfaces.IMapNode;

public class MapNode<K,V> implements IMapNode<K,V> {

    private K key;
    private V value;
    private MapNode<K,V> next;
    private MapNode<K,V> prev;

    public MapNode(K key, V value) {
        setKey(key);
        setValue(value);
        setNext(null);
        setPrev(null);
    }

    public void setNext(MapNode<K,V> next) {
        this.next = next;
    }

    public void setPrev(MapNode<K,V> prev) {
        this.prev = prev;
    }

    public MapNode<K,V> Next() {
        return next;
    }

    public MapNode<K,V> Prev() {
        return prev;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public V getValue() {
        return value;
    }
}
