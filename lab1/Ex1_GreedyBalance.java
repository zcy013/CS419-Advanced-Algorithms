/**
 * Load Balancing Problem
 * 
 * @Input: 	m identical machines: M_1, M_2, ..., M_m
 * 			n jobs: J_1, J_2, ..., J_n
 * 			Processing time of each job: t_j(j= 1, 2, ..., n)
 * 
 * Use greedy algorithm:
 * 		At each step, assign a job to the machine with the smallest load in an arbitrary order of jobs.
 * 
 * @Output:	Makespan T = max {T_1, T_2, ..., T_n}
 * 			(T_i is the total working of machine i)
 */

package lab1;

import java.util.Scanner;

public class Ex1_GreedyBalance {
	static int machine_number, job_number;
	static Job[] jobs;
	static Job[] jobsArrangment;
	static int[] loads;

	public void initialize() {// initialize number of machines, number of jobs and time of each job
		Scanner in = new Scanner(System.in);
		machine_number = in.nextInt();
		job_number = in.nextInt();
		// System.out.printf("%d machines, %d jobs\n", machine_number, job_number);
		jobsArrangment = new Job[machine_number];
		jobs = new Job[job_number];
		loads = new int[machine_number];
		for (int j = 0; j < job_number; ++j) {// read and set job number
			jobs[j] = new Job(in.nextInt());
		}
		for (int j = 0; j < job_number; ++j) {// read and set job time
			jobs[j].setTime(in.nextInt());
			// System.out.printf(" t%d=%d", jobs[j].getIndex(), jobs[j].getTime());
		}
		in.close();
	}

	public void scheduling() {// assign jobs to machines
		for (int j = 0; j < job_number; ++j) {
			int i = findMinLoad();
			if (jobsArrangment[i] == null)
				jobsArrangment[i] = jobs[j];
			else {
				jobsArrangment[i].getLastJob().setNextJob(jobs[j]);
			}
			loads[i] += jobs[j].getTime();
		}
	}

	public void printResult() {// output result
		for (int i = 0; i < jobsArrangment.length; ++i) {
			System.out.print("\nMachine" + (i + 1) + ": ");
			Job thisJob = jobsArrangment[i];
			while (thisJob != null) {
				System.out.printf("%s(%d) ", thisJob, thisJob.getTime());
				thisJob = thisJob.getNextJob();
			}
		}
	}

	private int findMinLoad() {// find machine that will finish jobs at the earliest
		int minLoad = loads[0];
		int index = 0;
		for (int i = 1; i < machine_number; ++i) {
			if (loads[i] < minLoad) {
				minLoad = loads[i];
				index = i;
			}
		}
		return index;
	}

	public int getMakespan() {// get the longest working time of machines
		int maxLoad = loads[0];
		for (int i = 1; i < machine_number; ++i) {
			if (loads[i] > maxLoad) {
				maxLoad = loads[i];
			}
		}
		return maxLoad;
	}

}
