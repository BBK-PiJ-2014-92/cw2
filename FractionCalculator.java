public class FractionCalculator {
	private String rememberedOp;

	public FractionCalculator() {
		this.rememberedOp = "";
	}

	public Fraction evaluate(Fraction fraction, String inputString) {
		String[] splitNumbers = inputString.split(" ");
		for (int count = 0; count < splitNumbers.length; count++) {
			if (splitNumbers[count].equals("/") ||splitNumbers[count].equals("+") ||splitNumbers[count].equals("-") ||splitNumbers[count].equals("*")) { //This sets the operator
				this.rememberedOp = splitNumbers[count];
			} else if (splitNumbers[count].equals("a") ||splitNumbers[count].equals("A") ||splitNumbers[count].equals("abs")) { //This checks to see whether absolute value is mentioned in the array
				fraction = fraction.absValue();
			} else if (splitNumbers[count].equals("n") ||splitNumbers[count].equals("N") ||splitNumbers[count].equals("neg")) { //This checks to see if negate is mentioned in the array
				fraction = fraction.negate();
			} else if (splitNumbers[count].equals("c") ||splitNumbers[count].equals("C") ||splitNumbers[count].equals("clear")) { //This checks to see if clear is mentioned in the array
				fraction.setNumerator(0);
				fraction.setDenominator(1);
			} else if (splitNumbers[count].contains("/")) { //This is the check for fractions
				if (this.rememberedOp == "") {
					fraction = tempFraction(splitNumbers, count, fraction);
				} else {
					fraction = this.operator(fraction, tempFraction (splitNumbers, count, fraction));
				}
			} else if (splitNumbers[count].matches("[0-9]+")){
				if (this.rememberedOp == "") {
					fraction = tempFraction(splitNumbers, count, fraction);
				} else {
					fraction = this.operator(fraction, tempFraction (splitNumbers, count, fraction));
				}
			} else {
				System.out.println("Error in evaluate");
				fraction.setNumerator(0);
				fraction.setDenominator(1);
				break;
			}
		} System.out.println(fraction);
		return fraction;
	}
	public Fraction tempFraction(String[] splitNumbers, int count, Fraction fraction) { //This method sets the numerator and denominator of a string of numbers
		if (splitNumbers[count].contains("/")) {
			for (int i = 0; i < splitNumbers[count].length(); i++) {
				String singleArray = splitNumbers[count];
				if (singleArray.charAt(i)== '/') {
					if (singleArray.matches(".*[a-zA-Z]+.*")) {
						System.out.println("Error in tempFraction");
						fraction.setNumerator(0);
						fraction.setDenominator(1);
						break;
					}else {
						int num = Integer.parseInt(singleArray.substring(0, i));
						int denom = Integer.parseInt(singleArray.substring(i+1));
						if (denom == 0) {
							System.out.println("Error. Invalid Denominator");
							fraction.setNumerator(0);
							fraction.setDenominator(1);
							break;
						}else {
							return new Fraction(num, denom);
						}
					}
				}
			}
		} else {
			int num = Integer.parseInt(splitNumbers[count]);
			int denom = 1;
			return new Fraction(num, denom);
		}
		return fraction;
	}

	public Fraction operator(Fraction fraction, Fraction tempFraction) {
		if (this.rememberedOp.equals("+")) {
			this.rememberedOp = "";
			return fraction = fraction.add(tempFraction);
		}else if (this.rememberedOp.equals("-")) {
			this.rememberedOp = "";
			return fraction = fraction.subtract(tempFraction);
		}else if (this.rememberedOp.equals("*")) {
			this.rememberedOp = "";
			return fraction = fraction.multiply(tempFraction);
		}else {
			this.rememberedOp = "";
			return fraction = fraction.divide(tempFraction);
		}
	}
}