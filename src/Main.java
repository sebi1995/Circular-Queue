import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String RED = "\033[0;91m";
    private static final String RESET = "\033[0m";

    public static void main(String[] args) {
        boolean programRunning = true;
        System.out.println("How big do you want the queue?");
        while (programRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Queue size: ");

            try {
                int size = scanner.nextInt();
                Queue queue = new Queue(size);

                boolean running = true;

                while (running) {
                    String input = scanner.nextLine();

                    switch (input) {
                        case "e":
                            System.out.print("Enqueue value: ");
                            System.out.println(enq(queue, scanner));
                            break;
                        case "d":
                            System.out.println(deq(queue));
                            break;
                        case "h":
                            System.out.println(RED + "e <int arg>    = enqueue number given in <int arg>\n" +
                                    "d              = dequeue next in line" + RESET);
                            break;
                        default:
                            System.out.println(RED + "Invalid input: type h for help" + RESET);
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "INVALID INPUT" + RESET);
            }
        }
    }

    private static String enq(Queue queue, Scanner scanner) {
        try {
            String in = scanner.nextLine();
            int res = queue.enqueue(in);
            if (res == -40) {
                return RED + "YOU MUST DEQUEUE FIRST!" + RESET;
            }
        } catch (InputMismatchException e) {
            return RED + "INVALID INPUT" + RESET;
        }
        return queue.toString();
    }

    private static String deq(Queue queue) {
        if (queue.dequeue() == -50) {
            return RED + "YOU MUST ENQUEUE FIRST!" + RESET;
        }
        return queue.toString();
    }
}


//https://github.com/sebi1995/Circular-Queue.git