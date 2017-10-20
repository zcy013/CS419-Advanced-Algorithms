package lab1;

public class Ex1_GreedyBalanceTest {

	public static void main(String[] args) {
		Ex1_GreedyBalance gb = new Ex1_GreedyBalance();
		gb.initialize();
		gb.scheduling();
		// gb.printResult();
		System.out.println(gb.getMakespan());
	}

}
