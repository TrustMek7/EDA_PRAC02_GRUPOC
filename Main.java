public class Main {
    public static void main(String[] args) {
        PriorityQueueHeap<String> priorityQueue = new PriorityQueueHeap<>();
        priorityQueue.enqueue("Elemento 1", 3);
        priorityQueue.enqueue("Elemento 2", 1);
        priorityQueue.enqueue("Elemento 3", 2);

        System.out.println("Elemento de mayor prioridad: " + priorityQueue.front());
        System.out.println("Elemento de menor prioridad: " + priorityQueue.back());

        while (!priorityQueue.isEmpty()) {
            String item = priorityQueue.dequeue();
            System.out.println("Elemento eliminado: " + item);
        }
    }
}