import RingBuffer.BufferFullException;
import RingBuffer.RingBuffer;

import java.util.List;

public class Producer implements Runnable{

    Integer generateDataAmount;
    RingBuffer ringBuffer;

    Producer(RingBuffer ringBuffer,
             Integer generateDataAmount) {
        this.generateDataAmount = generateDataAmount;
        this.ringBuffer = ringBuffer;
    }

    @Override
    public void run() {
        List<Integer> data = Utils.generateIntegerArray(generateDataAmount, 0,9);

        try {
            ringBuffer.put(data);
        } catch (BufferFullException | InterruptedException e) {
            System.out.println("Buffer is full");
        }
    }
}
