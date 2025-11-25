import java.util.Scanner;

class Process1 {
    int pid, arrivalTime, burstTime, completionTime, turnaroundTime, waitingTime;

    Process1(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class fcfs_with_arrival_time {
    public void run() {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of processes
        System.out.print("Enter number of processes: ");
        int n = scanner.nextInt();
        Process1[] processes = new Process1[n];

        // Input: Arrival Time & Burst Time for each process
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Arrival Time for P" + (i + 1) + ": ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Enter Burst Time for P" + (i + 1) + ": ");
            int burstTime = scanner.nextInt();
            processes[i] = new Process1(i + 1, arrivalTime, burstTime);
        }

        // Sorting processes based on Arrival Time
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (processes[i].arrivalTime > processes[j].arrivalTime) {
                    Process1 temp = processes[i];
                    processes[i] = processes[j];
                    processes[j] = temp;
                }
            }
        }

        // Calculating Completion Time, Turnaround Time, and Waiting Time
        int currentTime = 0;
        int totalWaitingTime = 0, totalTurnaroundTime = 0;

        for (int i = 0; i < n; i++) {

            // This if statement is to handle ideal time case
            // If the current time is less than the arrival time of the process,
            // the CPU is idle, so we fast forward the time to the arrival time of the process.
            if (currentTime < processes[i].arrivalTime) {
                currentTime = processes[i].arrivalTime;
            }
            processes[i].completionTime = currentTime + processes[i].burstTime;
            processes[i].turnaroundTime = processes[i].completionTime - processes[i].arrivalTime;
            processes[i].waitingTime = processes[i].turnaroundTime - processes[i].burstTime;

            totalWaitingTime += processes[i].waitingTime;
            totalTurnaroundTime += processes[i].turnaroundTime;

            currentTime = processes[i].completionTime;
        }

        double averageWaitingTime = (double) totalWaitingTime / n;
        double averageTurnaroundTime = (double) totalTurnaroundTime / n;


        // Printing Results
        System.out.println();
        System.out.println("\nProcess\t Arrival Time\tBrust Time\tTrun Around Time\tWaiting Time");
        for (Process1 p : processes) {

            System.out.println("P" + p.pid + "\t\t\t" + p.arrivalTime + "\t\t\t\t" + p.burstTime + "\t\t\t\t"
                    + p.turnaroundTime + "\t\t\t\t" + p.waitingTime);
        }
        System.out.println("\nAverage Turnaround Time: " + averageTurnaroundTime);
        System.out.println("Average Waiting Time: " + averageWaitingTime+"\n\n\n");



    }
}
