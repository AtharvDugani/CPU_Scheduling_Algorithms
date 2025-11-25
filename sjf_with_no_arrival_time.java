import java.util.Scanner;

class Process4 {
    int pid, burstTime, waitingTime, turnaroundTime;

    public Process4(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
    }
}
public class sjf_with_no_arrival_time {
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process4[] processes = new Process4[n];

        // Input burst times
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Burst Time for Process P" + (i + 1) + ": ");
            int bt = sc.nextInt();
            processes[i] = new Process4(i + 1, bt);
        }

        // Manual sorting using nested loop (Selection Sort)
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (processes[j].burstTime < processes[minIndex].burstTime) {
                    minIndex = j;
                }
            }

            // Swap processes[i] and processes[minIndex]
            Process4 temp = processes[i];
            processes[i] = processes[minIndex];
            processes[minIndex] = temp;
        }

        // Calculate waiting time and turnaround time
        int currentTime = 0, totalWT = 0, totalTAT = 0;

        for (int i = 0; i < n; i++) {
            processes[i].waitingTime = currentTime;
            processes[i].turnaroundTime = currentTime + processes[i].burstTime;

            currentTime += processes[i].burstTime;
            totalWT += processes[i].waitingTime;
            totalTAT += processes[i].turnaroundTime;
        }

        // Output
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
        for (Process4 p : processes) {
            System.out.println("P" + p.pid + "\t\t\t" + p.burstTime + "\t\t\t" + p.waitingTime + "\t\t\t\t" + p.turnaroundTime);
        }

        double avgWT = (double) totalWT / n;
        double avgTAT = (double) totalTAT / n;

        System.out.println("\nAverage Waiting Time: " + avgWT);
        System.out.println("Average Turnaround Time: " + avgTAT+"\n\n\n");
    }
}
