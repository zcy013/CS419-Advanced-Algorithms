package lab1;

public class Job implements Comparable<Job> {
	private int index, time;// job number and time it need
	private Job nextJob;

	public Job(int index) {
		this.index = index;
	}

	public Job(int index, int time) {
		this.index = index;
		this.time = time;
	}

	public int getIndex() {
		return index;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public void setNextJob(Job nextJob) {
		this.nextJob = nextJob;
	}

	public boolean hasNextJob() {
		return nextJob != null;
	}

	public Job getNextJob() {
		return nextJob;
	}

	public Job getLastJob() {
		if (!this.hasNextJob())
			return this;
		Job next = this.nextJob;
		while (next.hasNextJob()) {
			next = next.getNextJob();
		}
		return next;
	}

	@Override
	public String toString() {
		return "Job" + index;
	}

	@Override
	public int compareTo(Job job) {
		return job.getTime() - this.getTime();
	}
}
