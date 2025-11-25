import java.util.Scanner;

public class Driver_program {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("****Wellcome to CPU Scheduling Algorithm in Java*****");
        System.out.println("In This Program we have tried to implement Scheduling Algorithm from Operating System Through JAVA");
        while (true) {
            System.out.println("Choose any algorithm from below option:");
            System.out.println("1. For First Come First Serve algorithm");
            System.out.println("2. For Shortest Job First algorithm");
            System.out.println("3. For Round Robin algorithm");
            System.out.println("4. Exit");

            System.out.print("Enter you choice: ");
            int choice1 = sc.nextInt();


            switch (choice1) {
                case 1:
                    System.out.println("There are further 2 option for FCFS: ");
                    System.out.println("1. Without arrival time");
                    System.out.println("2. With arrival time");
                    System.out.print("What is your choice: ");
                    int choice2 = sc.nextInt();
                    if (choice2 == 1) {
                        fcfs_with_no_arrival_time fcfs_no_at = new fcfs_with_no_arrival_time();
                        fcfs_no_at.run();
                    }
                    else{
                        fcfs_with_arrival_time fcfs_with_at = new fcfs_with_arrival_time();
                        fcfs_with_at.run();
                    }
                    break;

                case 2:
                    System.out.println("There are further 2 option for SJF: ");
                    System.out.println("1. Without arrival time");
                    System.out.println("2. With arrival time");
                    System.out.print("What is your choice: ");
                    int choice3 = sc.nextInt();
                    if (choice3 == 1) {
                        sjf_with_no_arrival_time sjf_no_at = new sjf_with_no_arrival_time();
                        sjf_no_at.run();
                    }
                    else{
                        sjf_with_arrival_time sjf_with_at = new sjf_with_arrival_time();
                        sjf_with_at.run();
                    }
                    break;

                case 3:
                    RoundRobin rb = new RoundRobin();
                    rb.run();
                    break;
                case 4:
                    System.out.println("Exiting Program...");
                    sc.close();
                    System.out.println("Thank You for using our Program!!!!");
                    return;

                default:
                    System.out.println("Invalid Choice!!!");
                    break;
            }
        }

    }
}
