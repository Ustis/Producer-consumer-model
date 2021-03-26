package RingBuffer;

import java.util.List;

public interface RingBuffer {

    void put(List<Integer> dataList) throws BufferFullException, InterruptedException;

    List<Integer> poll(Integer amount) throws BufferEmptyException, InterruptedException;
}
