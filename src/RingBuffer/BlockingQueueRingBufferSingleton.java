package RingBuffer;

@Deprecated
public final class BlockingQueueRingBufferSingleton {

    private  static volatile BlockingQueueRingBufferImpl ringBuffer;

    private BlockingQueueRingBufferSingleton(Integer size){
        ringBuffer = new BlockingQueueRingBufferImpl(size);
    }

    public static BlockingQueueRingBufferImpl getInstance() throws Exception {
        BlockingQueueRingBufferImpl result = ringBuffer;
        if (result != null) {
            return result;
        }
        synchronized(BlockingQueueRingBufferSingleton.class) {
            if (ringBuffer == null) {
                throw new Exception();
            }
            return ringBuffer;
        }
    }

    public static BlockingQueueRingBufferImpl getInstance(Integer size) {
        BlockingQueueRingBufferImpl result = ringBuffer;
        if (result != null) {
            return result;
        }
        synchronized(BlockingQueueRingBufferSingleton.class) {
            if (ringBuffer == null) {
                new BlockingQueueRingBufferSingleton(size);
            }
            return ringBuffer;
        }
    }
}
