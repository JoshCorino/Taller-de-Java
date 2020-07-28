package edu.isistan.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import edu.isistan.IProblemSolver;

public class SolutionMapFixed implements IProblemSolver{

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memory used "+this.toString() +" "+ (runtime.totalMemory() - runtime.freeMemory())/ (1024*1024) + "MB");
        List<Pair> pairs = new ArrayList<>();
        HashMap<Integer, Integer> frecuencyMap = new HashMap<>();
        int n=data.length;

        // Save elements in map
        for (int i=0; i<n; i++){
            if(!frecuencyMap.containsKey(data[i]))
                frecuencyMap.put(data[i],0);
            frecuencyMap.put(data[i], frecuencyMap.get(data[i])+1);
        }

        // Iterate through each element and add a pair if (sum-data[i]) != null (every pair is counted twice)
        for (int i=0; i<n; i++)
        {
            if(frecuencyMap.get(sum-data[i]) != null) {
                if ((sum - data[i] < data[i]) || ((sum - data[i] == data[i]) && (!pairs.contains(new Pair(sum - data[i],data[i]))))){
                    for (int k = 0; k < frecuencyMap.get(sum - data[i]); k++) {
                        pairs.add(new Pair(data[i], sum - data[i]));
                    }
                    if (sum - data[i] == data[i])
                        pairs.remove(new Pair(data[i], sum - data[i]));
                }

            }
        }
        System.out.println("Memory used "+this.toString() +" "+ (runtime.totalMemory() - runtime.freeMemory())/ (1024*1024) + "MB");
        return pairs;
    }
}
