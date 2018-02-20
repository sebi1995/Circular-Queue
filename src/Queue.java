import java.util.Arrays;

public class Queue {

    private int[] vector;
    private static int H;//head - beginning
    private static int T;//tail - end
    private StringBuilder qsb;

    Queue(int size) {
        vector = new int[size];
        qsb = new StringBuilder();
        H = 0;
        T = 0;
    }

    public int enqueue(int input) { //add to queue
        if (T == vector.length) {
            if (H == 0) {
                return -40;
            } else {
                vector[0] = input;
                return T = 1;
            }
        } else {
            if (T < H) {
                if (T + 1 == H) {
                    return -40;
                } else {
                    if (T == 0) {
                        return vector[++T] = input;
                    } else {
                        return vector[T++] = input;
                    }
                }
            } else {
                return vector[T++] = input;
            }
        }
    }

    public int dequeue() { //take turn
        if (H == vector.length) {
            if (T == 0 || T == 1) {
                return -50;
            } else return H = 1;
        } else {
            if (H + 1 == T) {
                return -50;
            } else {
                return ++H;
            }
        }
    }

    @Override
    public String toString() {
        qsb.delete(0, qsb.length());
        if (H < T) {
            for (int i = 0; i < H; ++i) {
                qsb.append("\033[0;32m").append(vector[i]).append("\033[0m").append(" ");
            }
            for (int i = H; i < vector.length; ++i) {
                qsb.append("\033[0;91m").append(vector[i]).append("\033[0m").append(" ");
            }
        } else {
            for (int i = 0; i < T; ++i) {
                qsb.append("\033[0;91m").append(vector[i]).append("\033[0m").append(" ");
            }
            for (int i = T; i < H; ++i) {
                qsb.append("\033[0;32m").append(vector[i]).append("\033[0m").append(" ");
            }
            for (int i = H; i < vector.length; ++i) {
                qsb.append("\033[0;91m").append(vector[i]).append("\033[0m").append(" ");
            }
        }
        return qsb.toString();
    }
}