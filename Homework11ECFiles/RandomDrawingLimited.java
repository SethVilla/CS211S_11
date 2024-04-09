public class RandomDrawingLimited<T> extends RandomDrawing<T> implements RandomDrawingInterface<T> {

    @FunctionalInterface
    interface Filter<T> {
        boolean filter(T item);
    }

    private final Filter<T> filter;
    RandomDrawingLimited(boolean allowsDuplicates, Filter<T> filter) {
        super(allowsDuplicates);
        this.filter = filter;
    }

    @Override
    public boolean addEntry(T entry) {
        if (filter.filter(entry)) {
           return super.addEntry(entry);
        } else {
            return false;
        }
    }
}
