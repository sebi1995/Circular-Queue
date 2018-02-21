import java.util.ArrayList;
import java.util.Arrays;

public class Queue {

    private ArrayList<String> vector;
    private int H;//head - beginning
    private int T;//tail - end
    private int HT = 0;
    private int size;
    private StringBuilder qsb;

    Queue(int size) {
        this.vector = new ArrayList<>(size);
        this.size = size;
        this.qsb = new StringBuilder();
        this.H = 0;
        this.T = 0;

        popEmptyQueue(size);

    }

    private void popEmptyQueue(int size) {
        for (int i = 0; i < size; ++i) {
            vector.add(" ");
        }
    }

    public int enqueue(String input) { //add to queue
        if (T == size) {
            if (H == 0) {
                return -40;
            } else {
                vector.set(0, input);
                T = 1;
            }
        } else {
            if (T < H) {
                if (T + 1 == H) {
                    return -40;
                } else {
                    if (T == 0) {
                        T++;
                        vector.set(T, input);
                    } else {
                        vector.set(T, input);
                        ++T;
                    }
                }
            } else {
                vector.set(T++, input);
            }
        }
        return 0;
    }

    public int dequeue() { //take turn
        if (H == size) {
            if (T == 0 || T == 1) {
                return -50;
            } else {
                H = 1;
            }
        } else {
            if (H + 1 == T) {
                return -50;
            } else {
                ++H;
                ++HT;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        qsb.delete(0, qsb.length());
        if (H < T) {
            for (int i = 0; i < H; ++i)
                qsb.append("\033[0;32m").append(vector.get(i)).append("\033[0m").append(" ");
            for (int i = H; i < T; ++i)
                qsb.append("\033[0;91m").append(vector.get(i)).append("\033[0m").append(" ");
            for (int i = T; i < size; ++i)
                qsb.append("\033[0;32m").append(vector.get(i)).append("\033[0m").append(" ");
        } else {
            for (int i = 0; i < T; ++i)
                qsb.append("\033[0;91m").append(vector.get(i)).append("\033[0m").append(" ");
            for (int i = T; i < H; ++i)
                qsb.append("\033[0;32m").append(vector.get(i)).append("\033[0m").append(" ");
            for (int i = H; i < size; ++i)
                qsb.append("\033[0;91m").append(vector.get(i)).append("\033[0m").append(" ");
        }
        return qsb.toString();
    }
}