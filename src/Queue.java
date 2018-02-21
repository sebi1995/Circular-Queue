import java.util.ArrayList;
import java.util.Arrays;

public class Queue {
    private ArrayList<String> vector;
    private ArrayList<String> colours;
    private int H;//head - beginning
    private int T;//tail - end
    private int HT = 0;
    private int size;
    private StringBuilder qsb;

    Queue(int size) {
        vector = new ArrayList<>(size);
        colours = new ArrayList<>(size);
        this.size = size;
        qsb = new StringBuilder();
        H = -1;
        T = -1;

        popEmptyQueue(size);

    }

    private void popEmptyQueue(int size) {
        for (int i = 0; i < size; ++i) {
            vector.add(" ");
            colours.add(" ");
        }
    }

    public int enqueue(String input) { //add to queue
        if (T == size - 1) {
            if (H == -1 || H == 0) {
                return -40;
            } else {
                T = 0;
                vector.set(T, input);
                colours.set(T, "r");
                return 0;
            }
        } else if (T + 1 == H) return -40;

        vector.set(++T, input);
        colours.set(T, "r");

        return 0;
    }

    public int dequeue() { //take turn
        if (H == -1 && T == -1) return -50;
        if (H == size - 1) {
            if (T == 0) {
                return -50;
            } else {
                H = -1;
            }
        } else if (H + 1 == T) return -50;

        colours.set(++H, "g");

        return 0;
    }

    @Override
    public String toString() {
        qsb.delete(0, qsb.length());

        for (int i = 0; i < size; ++i) {
            switch (colours.get(i)) {
                case "r":
                    qsb.append("\033[0;91m").append(vector.get(i)).append("\033[0m").append(" ");
                    break;
                case "g":
                    qsb.append("\033[0;32m").append(vector.get(i)).append("\033[0m").append(" ");
                    break;
            }
        }

        return qsb.toString();
    }
}