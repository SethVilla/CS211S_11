import java.util.ArrayList;
import java.util.Random;

public class RandomDrawing<T> implements RandomDrawingInterface<T> {

    private final Random random = new Random();;

    private final ArrayList<T> entries = new ArrayList<>();;

    private final boolean allowsDuplicates;

    RandomDrawing(boolean allowsDuplicates) {
        this.allowsDuplicates = allowsDuplicates;
    }



    @Override
    public boolean addEntry(T entry) {
        if (!allowsDuplicates) {
            for (T e : entries) {
                if (entry.equals(e)) {
                    return false;
                }
            }
        }
        return entries.add(entry);
    }

    @Override
    public T selectWinner(boolean removeWinner) {

        if (size() == 0) {
            return null;
        }

        int winningIndex = random.nextInt(entries.size());

        if (removeWinner) {
            return entries.remove(winningIndex);
        }

        return entries.get(winningIndex);
    }

    @Override
    public int size() {
        return entries.size();
    }

    public boolean allowsDuplicates() {

        return allowsDuplicates;
    }

    @Override
    public void displayEntries() {
        System.out.println("\n");
        for (T entry: entries) {
            System.out.println(entry + "\n");
        }
    }
}
