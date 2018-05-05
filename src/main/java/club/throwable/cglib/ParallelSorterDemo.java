package club.throwable.cglib;

import net.sf.cglib.util.ParallelSorter;

import java.util.Arrays;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/5/5 9:40
 */
public class ParallelSorterDemo {

	public static void main(String[] args) throws Exception {
		Integer[][] array = new Integer[][]{
				{4, 3, 9, 0},
				{2, 1, 6, 0}
		};
		ParallelSorter.create(array).quickSort(0);
		for (Integer[] row : array) {
			System.out.println(Arrays.toString(row));
		}
	}
}
