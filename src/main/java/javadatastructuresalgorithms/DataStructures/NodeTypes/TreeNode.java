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

package src.main.java.javadatastructuresalgorithms.DataStructures.NodeTypes;

import src.main.java.javadatastructuresalgorithms.DataStructures.NodeInterfaces.INodeValue;

public class TreeNode<V> implements INodeValue<V> {

    private V value;
    private TreeNode<V> right;
    private TreeNode<V> left;
    private TreeNode<V> middle;

    public TreeNode(V value) {
        setValue(value);
        setLeft(null);
        setRight(null);
        setMiddle(null);
    }

    public void setRight(TreeNode<V> right) {
        this.right = right;
    }

    public void setLeft(TreeNode<V> left) {
        this.left = left;
    }

    public void setMiddle(TreeNode<V> middle) {
        this.middle = middle;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    public TreeNode<V> Right() {
        return right;
    }

    public TreeNode<V> Left() {
        return left;
    }

    public TreeNode<V> Middle() {
        return middle;
    }

    @Override
    public V getValue() {
        return value;
    }

}
