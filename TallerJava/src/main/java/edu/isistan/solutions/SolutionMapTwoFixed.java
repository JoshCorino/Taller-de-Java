package edu.isistan.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import edu.isistan.IProblemSolver;

public class SolutionMapTwoFixed implements IProblemSolver{

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {
        List<Pair> pairs = new ArrayList<>();
        HashMap<Integer, Integer> frecuencyMap = new HashMap<>();
        HashMap<Pair, Integer> pairMap = new HashMap<>();
        int n=data.length;

        for (int i=0; i<n; i++){
            if(!frecuencyMap.containsKey(data[i]))
                frecuencyMap.put(data[i],0);
            frecuencyMap.put(data[i], frecuencyMap.get(data[i])+1);
        }

        for (int i=0; i<n; i++)
        {
            if(frecuencyMap.get(sum-data[i]) != null) {
                if((pairMap.get(new Pair(sum - data[i],data[i])) == null)|| (data[i]+data[i]==sum)){

                    Pair thisPair=new Pair(data[i],sum - data[i]);
                    pairMap.putIfAbsent(thisPair, 0);
                    pairMap.put(thisPair,pairMap.get(thisPair)+frecuencyMap.get(sum - data[i]));
                    if (sum - data[i] == data[i]){
                        pairMap.put(thisPair,pairMap.get(thisPair)-1);
                        frecuencyMap.put((sum - data[i]),frecuencyMap.get(sum - data[i])-1);
                    }
                }
            }
        }

        for (Pair p:pairMap.keySet()) {
            for(int j=0;j<pairMap.get(p);j++){
                pairs.add(p);
            }
        }
        return pairs;
    }
}
