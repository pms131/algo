package sort;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Sort {
	abstract protected ArrayList<Integer> doSort(ArrayList<Integer> array);
	
	protected void swap(ArrayList<Integer> array, int src, int dest) {
		Collections.swap(array, src, dest);
	}
}
