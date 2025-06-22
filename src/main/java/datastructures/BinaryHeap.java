package datastructures;

import java.util.Comparator;

public class BinaryHeap<T extends Comparable> {
    private DynamicArray<T> elements = new DynamicArray<>();

    private Comparator<T> comparator;

    public BinaryHeap() {
    }

    public BinaryHeap(Comparator<T> customComparator) {
        this.comparator = customComparator;
    }

    public void insert(T value) {
        elements.add(value);

        if(elements.size() > 1) {
            heapify();
        }
    }

    private void heapify() {
        if(comparator != null) {
            heapifyUsingComparator();
        }
        else {
            heapifyUsingComparable();
        }
    }

    private void heapifyUsingComparator() {
        int curIdx = elements.size();
        while(curIdx != 1) {
            int parentIdx = curIdx/2 - 1;
            if(comparator.compare(elements.get(curIdx - 1), elements.get(parentIdx)) < 0) {
                T temp = elements.get(curIdx - 1);
                elements.set(curIdx - 1, elements.get(parentIdx));
                elements.set(parentIdx, temp);
            }
            curIdx = parentIdx + 1;
        }
    }

    private void heapifyUsingComparable() {
        int curIdx = elements.size();
        while(curIdx != 1) {
            int parentIdx = curIdx/2 - 1;
            if(elements.get(curIdx - 1).compareTo(elements.get(parentIdx)) < 0) {
                T temp = elements.get(curIdx - 1);
                elements.set(curIdx - 1, elements.get(parentIdx));
                elements.set(parentIdx, temp);
            }
            curIdx = parentIdx + 1;
        }
    }

    private void shiftDown() {
        if(comparator != null) {
            shiftDownUsingComparator();
        }
        else {
            shiftDownUsingComparable();
        }
    }

    private void shiftDownUsingComparator() {
        int curIdx = 1;
        while(curIdx < elements.size()) {
            int leftIdx = curIdx * 2;
            int rightIdx = curIdx * 2 + 1;
            if(leftIdx <= elements.size() && rightIdx <= elements.size()) {
                T leftEl = elements.get(leftIdx - 1);
                T rightEl = elements.get(rightIdx - 1);
                int minIdx = comparator.compare(leftEl, rightEl) < 0 ? leftIdx : rightIdx;
                T minEl = comparator.compare(leftEl, rightEl) < 0 ? leftEl : rightEl;
                //if parent greater than child, swap
                if(comparator.compare(elements.get(curIdx - 1), elements.get(minIdx - 1)) > 0) {
                    elements.set(minIdx - 1,elements.get(curIdx - 1));
                    elements.set(curIdx - 1, minEl);
                    curIdx = minIdx;
                }
                else {
                    break;
                }
            }
            else if(leftIdx <= elements.size()) {
                if(comparator.compare(elements.get(curIdx - 1), elements.get(leftIdx - 1)) > 0) {
                    T temp = elements.get(leftIdx - 1);
                    elements.set(leftIdx - 1, elements.get(curIdx - 1));
                    elements.set(curIdx - 1, temp);
                }
                break;
            }
            else {
                break;
            }
        }
    }

    private void shiftDownUsingComparable() {
        int curIdx = 1;
        while(curIdx < elements.size()) {
            int leftIdx = curIdx * 2;
            int rightIdx = curIdx * 2 + 1;
            if(leftIdx <= elements.size() && rightIdx <= elements.size()) {
                T leftEl = elements.get(leftIdx - 1);
                T rightEl = elements.get(rightIdx - 1);
                int minIdx = leftEl.compareTo(rightEl) < 0 ? leftIdx : rightIdx;
                T minEl = leftEl.compareTo(rightEl) < 0 ? leftEl : rightEl;
                //if parent greater than child, swap
                if(elements.get(curIdx - 1).compareTo(elements.get(minIdx - 1)) > 0) {
                    elements.set(minIdx - 1,elements.get(curIdx - 1));
                    elements.set(curIdx - 1, minEl);
                    curIdx = minIdx;
                }
                else {
                    break;
                }
            }
            else if(leftIdx <= elements.size()) {
                if(elements.get(curIdx - 1).compareTo(elements.get(leftIdx - 1)) > 0) {
                    T temp = elements.get(leftIdx - 1);
                    elements.set(leftIdx - 1, elements.get(curIdx - 1));
                    elements.set(curIdx - 1, temp);
                }
                break;
            }
            else {
                break;
            }
        }
    }

    public T peek() {
        if(elements.size() == 0) {
            throw new IllegalStateException("Binary Heap is empty");
        }

        return elements.get(0);
    }

    public T poll() {
        if(elements.size() == 0) {
            throw new IllegalStateException("Binary Heap is empty");
        }

        int lastIdx = this.elements.size() - 1;
        T temp = this.elements.get(lastIdx);
        this.elements.set(lastIdx, this.elements.get(0));
        this.elements.set(0, temp);
        T lastEl = this.elements.delete(lastIdx);

        if(elements.size() > 1) {
            shiftDown();
        }

        return lastEl;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

}
