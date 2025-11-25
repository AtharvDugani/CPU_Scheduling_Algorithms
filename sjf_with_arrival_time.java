import java.util.Scanner;

class Process3 {
    int pid, arrivalTime, burstTime, completionTime, waitingTime, turnaroundTime;

    // Constructor to initialize process details
    public Process3(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class sjf_with_arrival_time {
    public void run() {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input for number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        Process3[] processes = new Process3[n];

        // Step 2: Input Arrival Time (AT) and Burst Time (BT)
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Arrival Time for Process P" + (i + 1) + ": ");
            int at = sc.nextInt();
            System.out.print("Enter Burst Time for Process P" + (i + 1) + ": ");
            int bt = sc.nextInt();
            processes[i] = new Process3(i + 1, at, bt);
        }

        // Step 3: Sort processes by Arrival Time (AT) using Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (processes[j].arrivalTime > processes[j + 1].arrivalTime) {
                    // Swap processes[j] and processes[j+1]
                    Process3 temp = processes[j];
                    processes[j] = processes[j + 1];
                    processes[j + 1] = temp;
                }
            }
        }

        int currentTime = 0, completed = 0;
        boolean[] isCompleted = new boolean[n];

        // Step 4: Process Execution
        while (completed < n) {
            int minIndex = -1;
            int minBurstTime = Integer.MAX_VALUE;

            // Find the process with the shortest burst time that has arrived
            for (int i = 0; i < n; i++) {
                if (!isCompleted[i] && processes[i].arrivalTime <= currentTime) {
                    if (processes[i].burstTime < minBurstTime) {
                        minBurstTime = processes[i].burstTime;
                        minIndex = i;
                    }
                }
            }

            // If no process is available, move time forward
            if (minIndex == -1) {
                currentTime++;
            } else {
                // Execute the selected process
                Process3 p = processes[minIndex];
                p.completionTime = currentTime + p.burstTime;
                p.turnaroundTime = p.completionTime - p.arrivalTime;
                p.waitingTime = p.turnaroundTime - p.burstTime;

                // Update variables
                currentTime = p.completionTime;
                isCompleted[minIndex] = true;
                completed++;
            }
        }

        // Step 5: Display Results
        System.out.println("\nProcess\t Arrival Time\tBrust Time\tTrun Around Time\tWaiting Time");
        double totalWT = 0, totalTAT = 0;
        for (Process3 p : processes) {
            System.out.println("P" + p.pid + "\t\t\t" + p.arrivalTime + "\t\t\t\t" + p.burstTime + "\t\t\t\t"
                    + p.turnaroundTime + "\t\t\t\t" + p.waitingTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        // Step 6: Calculate and display average waiting time and turnaround time
        System.out.println("\nAverage Turnaround Time: " + (totalTAT / n));
        System.out.println("Average Waiting Time: " + (totalWT / n)+"\n\n\n");

        sc.close();
    }
}
