import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDequeTest {
    @Test
    /**This performs interspersed addFirst and addLast calls.*/
    public void addFirstAndaddLastTest(){
        Deque<Integer> lld = new ArrayDeque<>();
        lld.addLast(10);
        lld.addLast(11);
        lld.addLast(12);
        assertThat(lld.toList()).containsExactly(10,11,12).inOrder();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.toList()).containsExactly(3,2,1,10,11,12).inOrder();
    }

    @Test
    /** This check get() performance on abnormal value, and normal value has constant time*/
    public void getTest(){
        Deque<Integer> lld = new ArrayDeque<>();
        lld.addFirst(10);
        lld.addFirst(11);
        assertThat(lld.get(2)).isNull();
        assertThat(lld.get(-1)).isNull();
        assertThat(lld.get(0)).isEqualTo(11);
        assertThat(lld.get(1)).isEqualTo(10);
    }

    @Test
    /** This performs the removeFirstandremoveLast actions*/
    public void removeFirstandremoveLastTest() {
        Deque<Integer> lld = new ArrayDeque<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        lld.addLast(9);
        lld.addLast(8);
        assertThat(lld.removeFirst()).isEqualTo(3);
        assertThat(lld.removeFirst()).isEqualTo(2);
        assertThat(lld.removeLast()).isEqualTo(8);
        assertThat(lld.toList()).containsExactly(1, 9).inOrder();

        Deque<Integer> lld2 = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            lld2.addLast(10);
        }
        for (int j = 0; j < 15; j++) {
            lld2.removeLast();
        }
    }



}
