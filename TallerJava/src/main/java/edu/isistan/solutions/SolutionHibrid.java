package edu.isistan.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import edu.isistan.IProblemSolver;

public class SolutionHibrid implements IProblemSolver{

public List<Pair> isSumIn(int[] data, int sum) {

	List<Pair> pairs = new ArrayList<>();

	HashMap<Integer, Integer> frecuencyMap = new HashMap<>();
	int n=data.length;
	Arrays.sort(data);

	for (int i=0; i<n; i++){
		if(!frecuencyMap.containsKey(data[i]))
			frecuencyMap.put(data[i],0);
		frecuencyMap.put(data[i], frecuencyMap.get(data[i])+1);
	}

	for (int i=0;i<data.length;i++){
		if(Arrays.binarySearch(data,sum-data[i])>0){
				for (int k = 0; k < frecuencyMap.get(sum - data[i]); k++) {
					pairs.add(new Pair(data[i], sum - data[i]));
				}
		}
	}
	return pairs;
}
}