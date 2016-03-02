
/**
 *
 * @author Alexander Swagsson, Povel Larsson
 *
 *         En illustration av komplexa tal.
 *
 */
public class Complex {

	private double re, im;

	/**
	 *
	 * @param re
	 *            - Reella mängden
	 * @param im
	 *            - imaginära mängden
	 */
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
		// for the glory of whitespace

	}

	/**
	 *
	 * @return reella mängden
	 */
	public double getRe() {
		return re;
	}

	/**
	 *
	 * @return imaginära mängden
	 */
	public double getIm() {
		return im;
	}

	/**
	 *
	 * @return absolutbeloppet i kvadrat
	 */
	public double getAbs2() {
		return (re * re) + (im * im);
	}

	/**
	 * Adderar två komplexa tal.
	 * 
	 * @param c
	 *            - det komplexa talet vi ska addera med.
	 */
	public void add(Complex c) {
		re += c.re;
		im += c.im;
	}

	/**
	 * Multiplicerar två komplexa tal.
	 * 
	 * @param c
	 *            - det komplexa talet vi ska multiplicera med.
	 */
	public void mult(Complex c) {
		double tempre = (re * c.re) - (im * c.im);
		double tempim = (re * c.im) + (c.re * im);
		re = tempre;
		im = tempim;
	}

}