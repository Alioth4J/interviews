public class DoubleBuffer<T> {

    private AtomicReference<T> readBuffer;

    private T writeBuffer;

    private BufferFactory factory;

    public DoubleBuffer(BufferFactory factory) {
        this.factory = factory;
        this.readBuffer = new AtomicReference<>(factory.create());
        this.writeBuffer = factory.create();
    }

    public T read() {
        return readBuffer.get();
    }

    public void write(Consumer<T> consumer) {
        consumer.accept(writeBuffer);
        T oldReadBuffer = readBuffer.get();
        factory.copy(writeBuffer, oldReadBuffer);
        T tmp = writeBuffer;
        writeBuffer = oldReadBuffer;
        readBuffer.set(tmp);
    }

}
