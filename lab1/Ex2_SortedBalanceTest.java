package lab1;

public class Ex2_SortedBalanceTest {

	public static void main(String[] args) {
		Ex2_SortedBalance sb = new Ex2_SortedBalance();
		sb.initialize();
		sb.scheduling();
		// sb.printResult();
		System.out.println(sb.getMakespan());
	}

}
