# CPU Scheduling Algorithms in Java

## **Overview**

This project implements multiple CPU scheduling algorithms in **Java**, designed to simulate how an operating system schedules processes. Each algorithm is written in a separate file, and a **main driver program** integrates all algorithms, allowing the user to choose which scheduling technique to run.

The project helps in understanding how different scheduling techniques affect process execution time, waiting time, and turnaround time.

---

## **Features**

* Modular Java design (each algorithm in its own class/file)
* User-friendly driver program to select the algorithm
* Accurate calculation of:

  * Waiting Time
  * Turnaround Time
  * Completion Time
* Clear tabular output of results

---

## **Implemented Scheduling Algorithms**

### 1. **First Come First Serve (FCFS)**

* Non-preemptive
* Processes are executed in the order they arrive.

### 2. **Shortest Job First (SJF)**

* Non-preemptive
* Selects the process with the shortest burst time.

### 3. **Shortest Remaining Time First (SRTF)** *(optional if included)*

* Preemptive version of SJF.

### 4. **Priority Scheduling**

* Non-preemptive
* Higher priority processes are executed first.

### 5. **Round Robin (RR)**

* Preemptive
* Each process gets CPU in fixed time quantum.

---

## **Folder Structure**

```
├── src
│   ├── FCFS.java
│   ├── SJF.java
│   ├── PriorityScheduling.java
│   ├── RoundRobin.java
│   ├── Process.java
│   └── MainDriver.java
└── README.md
```

---

## **How It Works**

1. User runs **MainDriver.java**.
2. A menu is displayed to select the desired scheduling algorithm.
3. The program accepts process details (PID, arrival time, burst time, priority).
4. The selected algorithm computes and displays:

   * Gantt Chart (if implemented)
   * Waiting Time
   * Turnaround Time
   * Average Waiting & Turnaround Time
5. Results are printed in a clean table.

---

## **Example Output**

```
Choose Scheduling Algorithm:
1. FCFS
2. SJF
3. Priority
4. Round Robin
Enter choice: 1

Process   Arrival   Burst   Waiting   Turnaround
P1           0        4        0          4
P2           1        3        3          6
P3           2        1        5          6
```

---

## **Technologies Used**

* Java (Core Java)
* OOP Concepts
* Arrays / Collections

---

## **Future Enhancements**

* Add GUI for easier input
* Add real-time Gantt chart visualization
* Add multilevel queue scheduling
* Implement I/O-bound and CPU-bound process simulation

---

## **Contributors**

* Atharv Dugani
* [Friends/Team Members]

---

## **License**

This project is for academic and learning purposes only.
