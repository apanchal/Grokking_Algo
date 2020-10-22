package edu.chap04.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

	public static void main(String args[]) {
		QuickSort sorting = new QuickSort();
		List<Integer> input = Arrays.asList(1001, -4, 9, 0, -4, 32000, 5, 2, 3);
		List<Integer> output = sorting.quickSort(input);
		
		
		System.out.print("Input:" + input);
		System.out.print("\nAfter" + output);

	}

	public int[] quickSort(int[] input) {
		
		List<Integer> list = Arrays.stream(input).boxed().collect(Collectors.toList());
		
		if (list.size() < 2) {
			return input;
		} else {
			Integer pivot = list.get(0);

			// lesser
			List<Integer> lesser = list.stream().skip(1).filter(elem -> elem <= pivot).collect(Collectors.toList());

			// greater
			List<Integer> greater = list.stream().skip(1).filter(elem -> elem > pivot).collect(Collectors.toList());

			return Stream.of(quickSort(lesser).stream(), Stream.of(pivot), quickSort(greater).stream())
					.flatMap(Function.identity()).collect(Collectors.toList());

		}

	}
}
