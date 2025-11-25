import java.util.*;

class Process5 {
    int pid;
    int burstTime;
    int remainingTime;
    int waitingTime = 0;
    int turnaroundTime = 0;

    Process5(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class RoundRobin {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process5[] processes = new Process5[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Burst Time for P" + (i + 1) + ": ");
            int bt = sc.nextInt();
            processes[i] = new Process5(i + 1, bt);
        }

        System.out.print("Enter Time Quantum: ");
        int timeQuantum = sc.nextInt();

        int currentTime = 0;
        boolean done;

        // Execute processes in a loop until all are done
        do {
            done = true;
            for (int i = 0; i < n; i++) {
                Process5 p = processes[i];
                if (p.remainingTime > 0) {
                    done = false;

                    if (p.remainingTime > timeQuantum) {
                        currentTime += timeQuantum;
                        p.remainingTime -= timeQuantum;
                    } else {
                        currentTime += p.remainingTime;
                        p.waitingTime = currentTime - p.burstTime;
                        p.remainingTime = 0;
                        p.turnaroundTime = currentTime;
                    }
                }
            }
        } while (!done);

        // Print Results
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
        int totalWT = 0, totalTAT = 0;
        for (Process5 p : processes) {
            System.out.println("P" + p.pid + "\t\t\t" + p.burstTime + "\t\t\t\t" + p.waitingTime + "\t\t\t\t" + p.turnaroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }
        double avgWT = (double) totalWT / n;
        double avgTAT = (double) totalTAT / n;

        System.out.println("\nAverage Waiting Time: " + avgWT);
        System.out.println("Average Turnaround Time: " + avgTAT+"\n\n\n");


    }

}
