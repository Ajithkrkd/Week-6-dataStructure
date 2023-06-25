
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class MinHeap {
    // heap is mainly build or construct using "Array" here i use "Array list" for
    // construction
    // in MinHeap the least element is fount on the root

    List<Integer> heap;

    MinHeap() {
        heap = new ArrayList<>();
    }

    // hear Iam Creating A constructor for passing a arry as a argument to this
    // constructor so I Can Build that
    // Array rto heap

    MinHeap(List<Integer> array) {
        buildHeap(array);
    }

    // here Iam Writing a function for Buillding A Array to heap
    // first fond the last parent

    public void buildHeap(List<Integer> array) {
        heap = array;
        for (int i = getParent(heap.size() - 1); i >= 0; i--) {
            shifDown(i);
        }

    }

    // here to functions to move element to down and up , int this function we got
    // the "index" of "last parent"
    // steps : ->
    // ____________________________________________
    // first Iam maked a variable and asighn the end index to it.
    // after that Iam find the left child of last parent
    // start a while loop upto to left index going to grater than endIndex

    private void shifDown(int currIndex) {
        int endIndex = heap.size() - 1;
        int leftIndex = getLeftChild(currIndex);

        while (leftIndex <= endIndex) {
            int rightIndex = getRightChild(currIndex);
            int indexToShift;
            if (rightIndex <= endIndex && heap.get(rightIndex) < heap.get(leftIndex)) {

                indexToShift = rightIndex;
            } else {
                indexToShift = leftIndex;
            }

            if (heap.get(currIndex) > heap.get(indexToShift)) {

                Collections.swap(heap, currIndex, indexToShift);
                leftIndex = getLeftChild(currIndex);

            } else {
                return;
            }
        }

    }

    private void shifUp(int currIndex) {
        int parentIndex = getParent(currIndex);

        while (parentIndex > 0 && heap.get(parentIndex) > heap.get(currIndex)) {
            Collections.swap(heap, currIndex, parentIndex);
            currIndex = parentIndex;
            parentIndex = getParent(parentIndex);
        }

    }

    // here peek(); this function to get the top element "root";

    public int peek() {
        if (!heap.isEmpty()) {
            return heap.get(0);
        } else {
            return -1;
        }
    }

    // to remove a element
    // steps
    // __________________________________________
    // remove is only in the peek element
    // first swap the peek element and the last elment then remove last element then
    // shift down the peek
    public void removeElement() {
        if (!heap.isEmpty()) {
            Collections.swap(heap, 0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            shifDown(0);
        } else {
            System.out.println("Empty heap");
        }

    }

    // here is insertion
    // first we insert the value into the last element and shift up
    public void insert(int value) {
        heap.add(value);
        shifUp(heap.size() - 1);
    }

    // here the function to get the child elements and parent element

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    // this function to display heap elements
    public void display() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
    }

    // here is the main function

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(6, 2, 8));
        MinHeap heap1 = new MinHeap(array);

        heap1.insert(23);
        heap1.display();
    }

}
