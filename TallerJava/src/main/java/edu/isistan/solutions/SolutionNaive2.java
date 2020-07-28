package edu.isistan.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import edu.isistan.IProblemSolver;

public class SolutionNaive2 implements IProblemSolver{

	public List<Pair> isSumIn(int[] data, int sum) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Memory used "+this.toString() +" "+ (runtime.totalMemory() - runtime.freeMemory())/ (1024*1024) + "MB");
		List<Pair> pairs = new ArrayList<>();
		
		IntStream.range(0,  data.length)
	    .forEach(i -> IntStream.range(i+1,  data.length)
	        .filter(j -> i != j && data[i] + data[j] == sum)
	        .forEach(j -> pairs.add(new Pair(data[i], data[j])))
	    		);
		System.out.println("Memory used "+this.toString() +" "+ (runtime.totalMemory() - runtime.freeMemory())/ (1024*1024) + "MB");
		return pairs;
	}

}