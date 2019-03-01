package cz.ryvo.dm.action;

import java.util.LinkedList;

public class EventQueue<T> {

    private final int size;
    private final LinkedList<T> list;

    public EventQueue(int size) {
        this.size = size;
        this.list = new LinkedList<>();
    }

    public boolean put(T o) {
        return (o != null) && (list.size() < size) && list.add(o);
    }

    public T get() {
        return (!list.isEmpty()) ? list.removeFirst() : null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }
}
