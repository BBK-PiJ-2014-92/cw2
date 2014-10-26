public class FractionCalculator {

	public Fraction evaluate(Fraction fraction, String inputString) {
		String[] splitNumbers = inputString.split(" ");
		String rememberedOp = null;
		for (int count = 0; count < splitNumbers.length; count++) {
			if (splitNumbers[count].equals("/") ||splitNumbers[count].equals("+") ||splitNumbers[count].equals("-") ||splitNumbers[count].equals("+")) {
				rememberedOp = splitNumbers[count];
			} else if (splitNumbers[count].equals("a") ||splitNumbers[count].equals("A") ||splitNumbers[count].equals("abs")) {
				fraction = fraction.absValue();
			} else if (splitNumbers[count].equals("n") ||splitNumbers[count].equals("N") ||splitNumbers[count].equals("neg")) {
				fraction = fraction.negate();
			} else if (splitNumbers[count].equals("c") ||splitNumbers[count].equals("C") ||splitNumbers[count].equals("clear")) {
				fraction.setNumerator(0);
				fraction.setDenominator(1);
			} else if (splitNumbers[count].contains("/")) {
				if (rememberedOp == null) {
					fraction = tempFraction(splitNumbers, count);
				} else {
					fraction = operator(rememberedOp, fraction, tempFraction (splitNumbers, count));
				}
			}
		}
	}
	public Fraction tempFraction(String[] splitNumbers, int count) {
		if (splitNumbers[count].contains("/")) {
			for (int i = 0; i < splitNumbers[count].length(); i++) {
				String singleArray = splitNumber[count]
				if (singleArray.charAt(i).equals("/")) {
					if (!singleArray.contains("[0-9]+") ||!singleArray.contains("/")) {
						System.out.println("Error");
						fraction.setNumerator(0);
						fraction.setDenominator(1);
						break;
					}else {
						int num = Integer.parseInt(splitNumbers[count].substring(0, i));
						int denom = Integer.parseInt(splitNumbers[count].substring(i+1, splitNumbers[count].length() -1));
						return new Fraction(num, denom);
					}
				}
			}
		} else {
			int num = Integer.parseInt(splitNumbers[count]);
			int denom = 1;
			return new Fraction(num, denom);
		}
	}

	public Fraction operator(String rememberedOp, Fraction fraction, Fraction tempFraction) {
		if (rememberedOp.equals("+")) {
			rememberedOp = null;
			return fraction = fraction.add(tempFraction);
		}else if (rememberedOp.equals("-")) {
			rememberedOp = null;
			return fraction = fraction.subtract(tempFraction);
		}else if (rememberedOp.equals("*")) {
			rememberedOp = null;
			return fraction = fraction.multiply(tempFraction);
		}else {
			rememberedOp = null;
			return fraction = fraction.divide(tempFraction);
		}
	}
}