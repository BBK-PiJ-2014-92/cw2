public class FractionCalculator {

	public Fraction evaluate(Fraction fraction, String inputString) {
		String[] splitNumbers = inputString.split(" ");
		String rememberedOp = null;
		for (int count = 0; count < splitNumbers.length; count++) {
			if (splitNumbers[count].equals("/" || "+" || "-" || "+") {
				rememberedOp = splitNumbers[count];
			} else if (splitNumbers[count].equals("a" || "A" || "abs") {

			} else if (splitNumbers[count].equals("n" || "N" || "neg") {

			} else if (splitNumbers[count].equals("c" || "C" || "clear") {

			} else if (splitNumbers[count].contains{"/") {
				if (rememberedOp = null) {
					fraction = tempFraction (String[] splitNumbers, count);
				} else {
					if (rememberedOp.equals("+") {
								fraction = fraction.add(new Fraction(num, denom));
							}
						}
					}
				}

	public Fraction tempFraction (String[] splitNumbers, int count) {
		if (splitNumbers[count].charAt(i).equals("/") {
			for (int i = 0; i < splitNumbers[count].length; i++) {
				if (splitNumbers[count].charAt(i).equals("/") {
					int num = Integer.parseInt(splitNumbers[count].substring(0, i));
					int denom = Integer.parseInt(splitNumbers[count].substring(i+1, splitNumbers[count].length -1);
				}
			}
			return new Fraction(num, denom);
		}else {
			int num = Integer.parseInt(splitNumbers[count])
			int denom = 1;
			return new Fraction(num, denom);
		}
	}

	public Fraction operator