/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	Fraction i = new Fraction(-1,2);
	Fraction j = new Fraction(1,-2);
	Fraction k = new Fraction(-1, 1);
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

        // extend with extra tests
    System.out.println(f.add(g)); //Result should be 4/5
    System.out.println(g.divide(g)); //Result should be 1
    System.out.println(h.subtract(f)); //Result should be 3/10
    System.out.println(i.absValue()); //Result should be 1/2
    System.out.println(j.absValue()); //Result should be 1/2
    System.out.println(k.absValue()); //Result should be 1
    System.out.println(f.negate()); //Result should be -3/10
    System.out.println(j.negate()); //Result should be 1/2
    System.out.println(i.negate()); //Result should be 1/2

    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
