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

import javadatastructuresalgorithms.DataStructures.NodeInterfaces.INodeValue;

public class ListNode<V> implements INodeValue<V> {

    private V value;
    private ListNode<V> next;
    private ListNode<V> prev;

    public ListNode(V value) {
        setValue(value);
        setNext(null);
        setPrev(null);
    }

    public void setNext(ListNode<V> next) {
        this.next = next;
    }

    public void setPrev(ListNode<V> prev) {
        this.prev = prev;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    public ListNode<V> Next() {
        return next;
    }

    public ListNode<V> Prev() {
        return prev;
    }

    @Override
    public V getValue() {
        return value;
    }
}
