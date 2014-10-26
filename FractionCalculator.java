public class FractionCalculator {
	private String rememberedOp;

	public FractionCalculator() {
		this.rememberedOp = "";
	}

	public Fraction evaluate(Fraction fraction, String inputString) {
		String[] splitNumbers = inputString.split(" "); //Split the string into an String Array containing the numbers and operators
		for (int count = 0; count < splitNumbers.length; count++) {
			if (splitNumbers[count].equals("/") ||splitNumbers[count].equals("+") ||splitNumbers[count].equals("-") ||splitNumbers[count].equals("*")) { //This sets the operator
				if(this.rememberedOp == "") {
					this.rememberedOp = splitNumbers[count];
				}else{
					System.out.println("Error!");
					fraction.setNumerator(0);
					fraction.setDenominator(1);
					break;
				}
			} else if (splitNumbers[count].equals("a") ||splitNumbers[count].equals("A") ||splitNumbers[count].equals("abs")) { //This checks to see whether absolute value is mentioned in the array
				fraction = fraction.absValue();
			} else if (splitNumbers[count].equals("n") ||splitNumbers[count].equals("N") ||splitNumbers[count].equals("neg")) { //This checks to see if negate is mentioned in the array
				fraction = fraction.negate();
			} else if (splitNumbers[count].equals("c") ||splitNumbers[count].equals("C") ||splitNumbers[count].equals("clear")) { //This checks to see if clear is mentioned in the array
				fraction.setNumerator(0);
				fraction.setDenominator(1);
			} else if (splitNumbers[count].contains("/")) { //This is the check for fractions
				if (this.rememberedOp == "") {
					fraction = tempFraction(splitNumbers, count, fraction); //If there is no remembered operation, then fraction becomes the stored value on the calculator
				} else {
					fraction = this.operator(fraction, tempFraction (splitNumbers, count, fraction)); //If there is a remembered operation, then this fraction becomes the second operand
				}
			} else if (splitNumbers[count].matches("-[0-9]+$") || splitNumbers[count].matches("[0-9]+$")){ //Only includes whole numbers and -
				if (this.rememberedOp == "") {
					fraction = tempFraction(splitNumbers, count, fraction); //If there is no remembered operation, then this whole number becomes the stores value on the calculator
				} else {
					fraction = this.operator(fraction, tempFraction (splitNumbers, count, fraction)); //If there is a remembered operation, then this whole number becomes the second operand
				}
			} else {
				System.out.println("Error!");
				fraction.setNumerator(0);
				fraction.setDenominator(1);
				break;
			}
		} System.out.println(fraction);
		return fraction;
	}
	public Fraction tempFraction(String[] splitNumbers, int count, Fraction fraction) { //This method sets the numerator and denominator of the String array.
		if (splitNumbers[count].contains("/")) {
			String singleArray[] = splitNumbers[count].split("/");
			for (int i = 0; i < singleArray.length; i++) {
				if (singleArray[i].matches("-[0-9]+$") || singleArray[i].matches("[0-9]+$")) {
					int num = Integer.parseInt(singleArray[0]);
					int denom = Integer.parseInt(singleArray[1]);
					if (denom == 0) {
						System.out.println("Error! Invalid Denominator");
						fraction.setNumerator(0);
						fraction.setDenominator(1);
						break;
					}else {
						return new Fraction(num, denom);
					}
				}else {
					System.out.println("Error!");
					fraction.setNumerator(0);
					fraction.setDenominator(1);
					break;
				}
			}
		}else {
			int num = Integer.parseInt(splitNumbers[count]);
			int denom = 1;
			return new Fraction(num, denom);
		}
		return fraction;
	}

	public Fraction operator(Fraction fraction, Fraction tempFraction) { //This method determines what operator is currently being held and outputs the result of that operator on the operands
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