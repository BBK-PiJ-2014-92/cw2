public class FractionCalculatorTest {

	public static void main(String[] args) {
		new FractionCalculator fc = new FractionCalculator();
		System.out.println("Welcome to my Fraction Calculator by Ahmed Almazidi");
		System.out.println("Please enter a line of numbers to be evaluated. Type 'q' or 'Q' to exist this program");
		boolean finished = false;
		new Fraction fraction = new Fraction(0, 1);
		while (!finished){
			String input = System.console().readLine();
			if (input.contains('q') || input.contains('Q') || input.contains('quit') || input.contains('Quit')){
				System.out.println("Goodbye");
				finished = true;
			} else {
				fraction = evaluate(fraction, input);
			}
		}
	}

