

public abstract class ComparisonSort extends Sort {

	int index, lastIndex;
	
	public ComparisonSort(RandomArray a) {
		super(a);
		lastIndex = array.length-1;
	}

	public abstract void normSort();

	public abstract void stepSort(int i);
	
	public void switchIndex(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public int getIndex() {
		return index;
	}
}
