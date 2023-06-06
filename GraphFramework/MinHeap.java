/* Team members:
Raghad Hawsawi 2105869 - Najd Khalid 2006156 - Wed Aljahdali 2105502 - Renad Baghdadi 2006538

Resources
1)  Levitin, A. (2012). Introduction to the design and analysis of algorithms. Pearson.
2)  Dijkstra Algorithm: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/

Section:
CP1
 */
package GraphFramework;

import java.util.*;

public class MinHeap {

  private int capacity;
  int size = 0;
  private heapNode[] heap;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    this.heap = new heapNode[capacity];
  }


  public int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  public int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  public int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  public boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  public boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  public boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  public heapNode leftChild(int parentIndex) {
    return heap[getLeftChildIndex(parentIndex)];
  }

  public heapNode rightChild(int parentIndex) {
    return heap[getRightChildIndex(parentIndex)];
  }

  public heapNode parent(int childIndex) {
    return heap[getParentIndex(childIndex)];
  }
  
  public heapNode get(Vertex v) {
      
      for ( int i = 0; i < heap.length; i++) {
          if( heap[i].getNode().equals(v)) return heap[i];
      }
      
      return null;
  }

  public void swap(int index1, int index2) {
    heapNode element = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = element;
  }

  private void ensureCapacity() {
    if (size == capacity) {
      heap = Arrays.copyOf(heap, capacity * 2);
      capacity = capacity * 2;
    }
  }
  
  //We use merge sort instead since its B(O) is nlog n
  public void sort() {
      mergeSort(heap, 0, size -1);
  }
  
  public void merge(heapNode arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        heapNode L[] = new heapNode[n1];
        heapNode R[] = new heapNode[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getWeight() <= R[j].getWeight()) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public void mergeSort(heapNode arr[], int l, int r)
    {
        if (l < r) {
 
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
  
  

  // Time Complexity : O(1)
  public heapNode peek() {
    if (size == 0) {
      return null;
    }
    return heap[0];
  }

  // Time Complexity : O( Log n)
  public heapNode poll() {
    if (size == 0) {
      return null;
    }
    heapifyDown();
    heapNode element = heap[0];

    heap[0] = heap[size - 1];
    size--;
    heapifyDown();
    return element;
  }

  // Time Complexity : O( Log n)
  public void add(heapNode item) {
    ensureCapacity();
    heap[size] = item;
    size++;
    heapifyUp();
  }

  private void heapifyUp() {
    int index = size - 1;

    while (hasParent(index) && parent(index).weight > heap[index].weight) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  private void heapifyDown() {
    int index = 0;

    while (hasLeftChild(index)) {
      int smallestChildIndex = getLeftChildIndex(index);

      if (hasRightChild(index) && rightChild(index).weight < leftChild(index).weight) {
        smallestChildIndex = getRightChildIndex(index);
      }

      if (heap[index].weight < heap[smallestChildIndex].weight) {
        break;
      } else {
        swap(index, smallestChildIndex);
      }
      index = smallestChildIndex;
    }
  }

  public void printHeap() {
    for (int i = 0; i < size; i++) {
      System.out.println(heap[i].getNode().getLabel() + " " + heap[i].getWeight());
    }
  }

}