package collections;

import java.util.Comparator;
import java.util.PriorityQueue;

class Item {
    public static Comparator<Item> ascById = (o1, o2) -> o1.id > o2.id ? 1 : -1;
    public static Comparator<Item> descById = (o1, o2) -> o1.id > o2.id ? -1 : 1;

    Integer id;
    String name;

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("id=%d, name=%s", this.id, this.name);
    }
}

class ItemContainComparable extends Item implements Comparable<Item> {
    public ItemContainComparable(Integer id, String name) {
        super(id, name);
    }

    @Override
    public int compareTo(Item o) {
        return this.id > o.id ? 1 : -1;
    }
}

public class PriorityQueueApp {

    public static <T> void printUntilEmpty(PriorityQueue<T> queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static void main(String[] args) {
        PriorityQueue<ItemContainComparable> queueICC = new PriorityQueue<>();
        queueICC.add(new ItemContainComparable(3, "c"));
        queueICC.add(new ItemContainComparable(5, "e"));
        queueICC.add(new ItemContainComparable(1, "a"));

        printUntilEmpty(queueICC);

        PriorityQueue<Item> queue = new PriorityQueue<>(Item.descById);
        queue.add(new Item(3, "c"));
        queue.add(new Item(5, "e"));
        queue.add(new Item(1, "a"));

        printUntilEmpty(queue);
    }
}
