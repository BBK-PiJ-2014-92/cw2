public class FractionCalculator {
	Fraction  calcValue;
	String operation;
	
	public FractionCalculator {
		this.numerator = 0;
		this.denominator = 1;
		this.operation = null;
	}
	
	public Fraction evaluate(Fraction fraction, String inputString) {
		String[] splitNumbers = inputString.split(" ");
		for (int count = 0; count < splitNumbers.length; count++) {
			if (splitNumbers[count].equals("/")) {
				operation = splitNumbers[count];
			} else if (splitNumbers[count].contains("/")) {
				for (int i = 0; i < splitNumbers[count].length; i++) {
					
				
				
		
				
				