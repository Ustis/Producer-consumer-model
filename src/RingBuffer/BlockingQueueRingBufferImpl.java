package RingBuffer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueRingBufferImpl implements RingBuffer {

    public Integer maxBufferSize;
    public BlockingQueue<Integer> ringBuffer;

    public BlockingQueueRingBufferImpl(Integer size) {
        ringBuffer = new LinkedBlockingQueue<Integer>();
        this.maxBufferSize = size;
    }

    @Override
    public synchronized void put(List<Integer> dataList) throws BufferFullException {

        System.out.println("Состояние буфера до добавления");
        printInnerPart();

        if (ringBuffer.size() == maxBufferSize) {
            throw new BufferFullException();
        } else if (ringBuffer.size() + dataList.size() >= maxBufferSize) {
            ringBuffer.addAll(dataList.subList(0, maxBufferSize - ringBuffer.size()));
        } else {
            ringBuffer.addAll(dataList);
        }

        System.out.println("Состояние буфера после добавления");
        printInnerPart();
    }

    @Override
    public synchronized List<Integer> poll(Integer amount) throws BufferEmptyException {

        List<Integer> result = new ArrayList<>();
        Integer elemBuffer;

        System.out.println("Состояние буфера до удаления");
        printInnerPart();

        if (ringBuffer.size() == 0)
            throw new BufferEmptyException();

        for (int i = 0; i < amount; ++i) {
            elemBuffer = ringBuffer.poll();

            if (elemBuffer == null)
                break;

            result.add(elemBuffer);
        }

        System.out.println("Состояние буфера после удаления");
        printInnerPart();

        return result;
    }

    public synchronized void printInnerPart() {
        for (Object object : ringBuffer) {
            System.out.print(object.toString() + " ");
        }
        System.out.println();
    }

}
