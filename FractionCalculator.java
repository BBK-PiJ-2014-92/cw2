public class FractionCalculator {

	public Fraction evaluate(Fraction fraction, String inputString) {
		String[] splitNumbers = inputString.split(" ");
		for (int count = 0; count < splitNumbers.length; count++) {
			if (splitNumbers[count].equals("/" || "+" || "-" || "+") {


			} else if (splitNumbers[count].equals("a" || "A" || "abs") {

			} else if (splitNumbers[count].equals("n" || "N" || "neg") {

			} else if (splitNumbers[count].equals("c" || "C" || "clear") {

			} else if (splitNumbers[count].contains{
				for (int i = 0; i < splitNumbers[count].length; i++) {
					if (splitNumbers[count].charAt(i).equals("/") {
						int num = Integer.parseInt(splitNumbers[count].substring(0, i));
						int denom = Integer.parseInt(splitNumbers[count].substring(i+1, splitNumbers[count].length -1);
						fraction.numerator = num;
						fraction.denominator = denom;
					} else {
						int num = Integer.parseInt(splitNumbers[count]);
						fraction.numerator = num;
						fraction.denominator = 1;
				}

	public Fraction operation(String[] splitNumbers, int count) {
		if (splitNumber[count].equals("+")