import java.util.Scanner;

class Process2{
    int pid, bursttime, completionTime, waitingTime, turnaroundTime;
    public Process2(int pid1, int bursttime1){
        this.pid = pid1;
        this.bursttime = bursttime1;
    }
}

public class fcfs_with_no_arrival_time {
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        Process2[] processes = new Process2[n];

        for (int i = 0; i < processes.length; i++) {
            System.out.print("Enter Burst Time for P" + (i + 1) + ": ");
            int burstTime = sc.nextInt();
            processes[i] = new Process2(i + 1, burstTime);

        }
        int totalWaitingTime = 0, totalTurnaroundTime = 0;
        int currentTime = 0; // To track process completion

        // Calculate Completion Time, Turnaround Time, and Waiting Time
        for (int i = 0; i < n; i++) {
            processes[i].waitingTime = currentTime;  // Waiting time is the previous completion time
            processes[i].completionTime = currentTime + processes[i].bursttime;
            processes[i].turnaroundTime = processes[i].completionTime; // Since arrival is 0

            // Update total waiting and turnaround times
            totalWaitingTime += processes[i].waitingTime;
            totalTurnaroundTime += processes[i].turnaroundTime;

            // Move to next process
            currentTime = processes[i].completionTime;
        }

        double averageWaitingTime = (double) totalWaitingTime / n;
        double averageTurnaroundTime = (double) totalTurnaroundTime / n;


        System.out.println();
        System.out.println("\nProcess\t\t\tBurst Time\t\tWaiting Time\t\tTurnaround Time");
        for (Process2 p : processes) {
            System.out.println("P" + p.pid + "\t\t\t" + p.bursttime + "\t\t\t" + p.waitingTime + "\t\t\t\t" + p.turnaroundTime);
        }
        System.out.println("\nAverage Turnaround Time: " + averageTurnaroundTime);
        System.out.println("Average Waiting Time: " + averageWaitingTime+"\n\n\n");


    }
}
