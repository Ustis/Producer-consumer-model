import RingBuffer.BufferEmptyException;
import RingBuffer.RingBuffer;

import java.util.List;

public class Consumer implements Runnable {

    Integer consumeDataAmount;
    RingBuffer ringBuffer;

    Consumer(RingBuffer ringBuffer,
             Integer consumeDataAmount) {
        this.consumeDataAmount = consumeDataAmount;
        this.ringBuffer = ringBuffer;
    }

    @Override
    public void run() {
        try {
            ringBuffer.poll(consumeDataAmount);
        } catch (BufferEmptyException | InterruptedException e) {
            System.out.println("Buffer is empty");
        }
    }
}
