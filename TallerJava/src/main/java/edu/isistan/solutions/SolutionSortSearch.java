package edu.isistan.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import edu.isistan.IProblemSolver;

public class SolutionSortSearch implements IProblemSolver{

    public List<Pair> isSumIn(int[] data, int sum) {

        List<Pair> pairs = new ArrayList<>();

        Arrays.sort(data);
        for (int i=0;i<data.length;i++){
            if(Arrays.binarySearch(data,sum-data[i])>0){
                pairs.add(new Pair(data[i],sum-data[i]));
            }
        }

        return pairs;
    }
}
