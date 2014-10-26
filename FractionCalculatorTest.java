public class FractionCalculatorTest {

	public static void main(String[] args) {
		FractionCalculator fc = new FractionCalculator();
		System.out.println("Welcome to Fraction Calculator by Ahmed Almazidi");
		System.out.println("Please enter a line of numbers to be evaluated. Numbers and operators must be separated by spaces");
		System.out.println("Type 'q' or 'Q' to exit this program");
		boolean finished = false;
		Fraction fraction = new Fraction(0, 1);
		while (!finished){
			String input = System.console().readLine();
			if (input.equals("q") || input.equals("Q") || input.equals("quit") || input.equals("Quit")){
				System.out.println("Goodbye");
				finished = true;
			} else {
				fraction = fc.evaluate(fraction, input);
			}
		}
	}
}