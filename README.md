# Java-Data-Structures-Algorithms
The following Contains various helpful data structure classes.

Please refer to Groovy-Data-Structures-Algorithms for an updated version of this repository. Which can easily be converted from groovy to a java library if needed.

This repository is set to be Archived and unlikely to receive updates in the future.

### Includes:

#### Lists:
* SinglyLinkedList
* DoublyLinkedList
* CircularDoublyLinkedList

#### Maps:
* CircularDoublyLinkedMap: A Map implementation of a CircularDoublyLinkedList. Near exactly same as CircularDoublyLinkedList but with a key-value pair.

#### Tables: Structure is based of Google Gauva's Tables
* CircularDoublyLinkedTable: A Table implementation of a CircularDoublyLinkedList. Similar to CircularDoublyLinkedList but with a row-column-value triplet.

#### Trees:
* BinaryTree
* TernaryTree
* BinaryIndexedTree (Aka Fenwick Tree):
* TernaryIndexedTree: Self explanatory, a Fenwick Tree with 3 nodes instead of 2.
* Trie: Work in Progress

#### Hashing:
* HashList: Same as a list, but uses a Hash Constant to determine the index of the value stored. Backed by a Map: Work in Progress: No delete function
* HashTableOA: Open Addressing based HashTable: Work in Progress
* HashTableSC: Seperate Chaining base HashTable: Work in Progress

#### Algorithms:
* FibonacciHeap: Work in Progress
* QuasiGroupGenerator: Can create QuasiGroups of size n with an order of magnitute n, to form a Latin Square.
* DammAlgorithm: Can calculate a check digit using Damm's Algorithm. Requires the QuasiGroupGenerator. Work in Progress: Validation using Damm's Algorithm does not work, as the QuasiGroups are randomly generated.
* DammAlgorithmStore: Stores previously generated DammAlgorithms. With add & remove

## Apache Licence 2.0
Copyright [2018] [Martin Kelly]

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
