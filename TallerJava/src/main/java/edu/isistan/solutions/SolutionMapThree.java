package edu.isistan.solutions;

import edu.isistan.IProblemSolver;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import gnu.trove.map.hash.TIntIntHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;

public class SolutionMapThree implements IProblemSolver{

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<Pair> pairs = new LinkedList<>();
        TIntIntHashMap frecuencyMap= new TIntIntHashMap();
        TObjectIntHashMap pairMap = new TObjectIntHashMap();
        int n=data.length;
        for (int i=0; i<n; i++){
            if(!frecuencyMap.containsKey(data[i]))
                frecuencyMap.put(data[i],0);
            frecuencyMap.put(data[i], frecuencyMap.get(data[i])+1);
        }

        for (int i=0; i<n; i++)
        {
            if(frecuencyMap.get(sum-data[i]) != frecuencyMap.getNoEntryValue()) {
                if((pairMap.get(new Pair(sum - data[i],data[i])) == pairMap.getNoEntryValue())||(data[i]+data[i]==sum)){
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

        for (Object p:pairMap.keySet()) {
            for(int j=0;j<pairMap.get(p);j++){
                pairs.add((Pair)p);
            }
        }

        return pairs;
    }
}
