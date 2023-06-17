
class PriorityQueueHeap<T extends Comparable<T>> {
    private Heap<PriorityQueueNode<T>> heap;

    public PriorityQueueHeap() {
        heap = new Heap<>();
    }

    public void enqueue(T item, int priority) {
        PriorityQueueNode<T> node = new PriorityQueueNode<>(item, priority);
        heap.insert(node);
    }

    public T dequeue() {
        PriorityQueueNode<T> node = heap.remove();
        return node.getItem();
    }

    public T front() {
        PriorityQueueNode<T> node = heap.peek();
        return node.getItem();
    }

    public T back() {
        int lastIndex = heap.size() - 1;
        PriorityQueueNode<T> node = heap.get(lastIndex);
        return node.getItem();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Clase interna para representar los nodos de la cola de prioridad
    private class PriorityQueueNode<T extends Comparable<T>> implements Comparable<PriorityQueueNode<T>> {
        private T item;
        private int priority;

        public PriorityQueueNode(T item, int priority) {
            this.item = item;
            this.priority = priority;
        }

        public T getItem() {
            return item;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(PriorityQueueNode<T> other) {
            return Integer.compare(other.getPriority(), priority);
        }
    }
    
}