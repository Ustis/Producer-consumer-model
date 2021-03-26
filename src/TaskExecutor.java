import RingBuffer.RingBuffer;
import RingBuffer.BlockingQueueRingBufferImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskExecutor {

    TaskExecutor(Integer producerCount,
                 Integer consumerCount,
                 Integer generateDataAmount,
                 Integer consumeDataAmount,
                 Integer bufferSize){
        List<Runnable> runnableList = new ArrayList<>();
        RingBuffer ringBuffer = new BlockingQueueRingBufferImpl(bufferSize);

        for(int i=0;i<producerCount;++i) {
            runnableList.add(new Producer(ringBuffer, generateDataAmount));
        }
        for(int i=0;i<consumerCount;++i){
            runnableList.add(new Consumer(ringBuffer,consumeDataAmount));
        }

        Collections.shuffle(runnableList);

        for (var elem:runnableList) {
            elem.run();
        }
    }
}
