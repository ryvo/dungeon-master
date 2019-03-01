package cz.ryvo.dm.action;

import java.util.LinkedList;

public class EventBuffer<T> {

    private final int size;
    private final LinkedList<T> list;

    public EventBuffer(int size) {
        this.size = size;
        this.list = new LinkedList<>();
    }

    public boolean put(T o) {
        return (list.size() < size) && list.add(o);
    }

    public T get() {
        return (!list.isEmpty()) ? list.removeFirst() : null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
