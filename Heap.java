import java.util.*;
class Heap<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("El heap está vacío.");
        }

        T root = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, lastItem);
            siftDown(0);
        }

        return root;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("El heap está vacío.");
        }

        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public int size() {
        return heap.size();
    }

    public T get(int index) {
        if (index < 0 || index >= heap.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }

        return heap.get(index);
    }
    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            siftDown(largestIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}