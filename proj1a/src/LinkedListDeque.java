import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {
    public static void main(String[] args) {
        Deque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(10);
        lld.addFirst(10);
        lld.addFirst(10);
        lld.removeFirst();

    }

    private int size;
    private Node<T> sentinel;
    private Node<T> first;
    private Node<T> last;


    public static class Node<T> {
        public Node<T> prev;
        public T item;
        public Node<T> next;
        public Node(Node<T> p, T i, Node<T> n){
            prev = p;
            item = i;
            next = n;
        }

    }

    public LinkedListDeque(){
        sentinel = new Node(null, 22,null);
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        first = sentinel.next;
        last = sentinel.prev;

    }

    @Override
    public void addFirst(T x) {
        size += 1;

        Node<T> p = new Node<>(sentinel, x, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
        first = p;

        if(p.next == sentinel){
            last = p;
        }
    }

    @Override
    public void addLast(T x) {
        size += 1;
        Node<T> p = new Node<>(last, x, sentinel);
        last.next = p;
        sentinel.prev = p;
        last = p;

        if(p.prev == sentinel){
            first = p;
        }

    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();

        Node<T> temp = sentinel.next;

        while (temp != sentinel){
            returnList.add(temp.item);
            temp = temp.next;
        }

        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        sentinel.next = first.next;
        first.next.prev = sentinel;
        first = sentinel.next;

        return null;
    }

    @Override
    public T removeLast() {
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        last = last.prev;

        return null;
    }

    @Override
    public T get(int index) {
        if ((index>size) | (index<0)){
            return null;
        }
        Node<T> temp = first;

        for (int i=0; i<size; i++){

            if(i == index){
                return temp.item;
            }
            temp = temp.next;

        }
        return first.item;
    }

    @Override
    public T getRecursive(int index) {
        if ((index>size) | (index<0)){
            return null;
        }
        if (index == 0){
            return first.item;
        }
        return getRecursive(index-1);
    }
}
