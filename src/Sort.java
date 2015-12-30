

/**
 * All sorting algorithm classes should extend this one.
 * 
 * Contains a basic method which indicates whether the sort
 * has completed. There are two different variants of each
 * algorithm - one that acts as intended, and another one
 * which allows for step-by-step visualization of the
 * algorithm in action.
 * 
 * @author Jason
 *
 */

public abstract class Sort {
	
	RandomArray a;
	int[] array;
	Indicator[] indicators;
	boolean done;
	
	public Sort(RandomArray a) {
		this.a = a;
		array = a.getArray();
	}
	
	/**
	 * Conventional version of the sorting algorithm.
	 * Sort is complete after just one external call.
	 * How the algorithm is meant to be.
	 */
	public abstract void normSort();
	
	/**
	 * Sorting algorithm only advances by one step
	 * following each call. Requires significant
	 * rewriting of the original algorithm. For
	 * learning and teaching purposes only.
	 * 
	 * @param i The current step of iteration.
	 */
	public abstract void stepSort(int i);
	
	public Indicator[] getIndicators() {
		return indicators;
	}
	
	public int[] get() {
		return array;
	}
	
	public boolean sortDone() {
		return done;
	}
}
