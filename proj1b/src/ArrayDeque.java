import java.util.ArrayList;
import java.util.List;

public class ArrayDeque<T> implements Deque<T> {
    public static void main(String[] args) {
        Deque<Integer> lld2 = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            lld2.addLast(10);
        }
        for (int j = 0; j < 13; j++) {
            lld2.removeLast();
        }
    }

    private int size;
    private static double REFACTOR = 2.0;
    private  int first_index = 0;
    private T[] items;
    private int nextFirst=0;
    private int nextLast=1;

    public ArrayDeque(){
        size = 0;
        items = (T[]) new Object[8];
    }

    @Override
    public void addFirst(T x) {
        checkSize(true);
        size+=1;
        items[nextFirst] = x;
        nextFirst -= 1;
        if (nextFirst<0){
            nextFirst = items.length-1;
        }

    }

    @Override
    public void addLast(T x) {
        checkSize(true);
        size += 1;
        items[nextLast] = x;
        nextLast += 1;
        if (nextLast>=items.length){
            nextLast = 0;
        }
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        if (!isEmpty()){
            for (int i=0; i<size; i++){
                if (get(i)!=null){
                    returnList.add(get(i));
                }
            }
            return returnList;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        T p = get(0);
        if (p == null){
            return null;
        }

        nextFirst += 1;
        if (nextFirst > items.length){
            nextFirst = 0;
        }

        size-=1;
        checkSize(false);
        return p;
    }

    @Override
    public T removeLast() {
        T p = get(size-1);
        if (p == null){
            return null;
        }

        nextLast -= 1;
        if (nextLast < 0){
            nextLast = items.length-1;
        }
        size-=1;
        checkSize(false);
        return p;
    }

    @Override
    public T get(int index) {
        if (index>=size | index < 0){
            return null;
        }
        int bidIndex = nextFirst + 1 + index;
        if (bidIndex>=items.length){
            bidIndex -= (items.length);
        }

        return items[bidIndex];
    }

    public void resize(){
        //scale up
        T[] a = (T[]) new Object[(int)(items.length*REFACTOR)];
        for (int i=0; i<size; i++){
            if (nextFirst+i+1< size){
                a[i] = items[i+1+nextFirst];
            }else{
                a[i] = items[nextFirst+1+i-size];
            }
        }
        items = a;
        nextFirst = items.length-1;
        nextLast = size;
    }

    public void checkSize(boolean isScaleUp){
        //rearrange the array
        if (size<items.length/4 && !isScaleUp){
            //scale down
            REFACTOR = 0.5;
            resize();
        }else if (size == items.length){
            //scale up
            REFACTOR = 2.0;
            resize();
        }
        return ;
    }

    private void resizeDown() {
        //scale down
        T[] a = (T[]) new Object[items.length*(int) REFACTOR];
        for (int i=0; i<size; i++){
            if (nextFirst+i+1< size){
                a[i] = items[i+1+nextFirst];
            }else{
                a[i] = items[nextFirst+1+i-size];
            }
        }
        items = a;
        nextFirst = items.length-1;
        nextLast = size;
    }


}
