package edu.isistan.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import edu.isistan.IProblemSolver;

public class SolutionSortSearchFixed implements IProblemSolver{

    public List<Pair> isSumIn(int[] data, int sum) {
        List<Pair> pairs = new ArrayList<>();
        Arrays.sort(data);
        for (int i=0;i<data.length;i++){
            int index=Arrays.binarySearch(data,sum-data[i]);
            if(index>=0 && index>i){
                Pair par=new Pair(data[i],sum-data[i]);
                pairs.add(par);
                int cursor= index-1;
                if(cursor>i) {
                    while (data[cursor] == sum - data[i]) {
                        pairs.add(par);
                        if (cursor - 1 > i)
                            cursor--;
                        else
                            break;
                    }
                }
                cursor=index+1;
                if(cursor<data.length) {
                    while (data[cursor] == sum - data[i]) {
                        pairs.add(par);
                        if (cursor + 1 < data.length)
                            cursor++;
                        else
                            break;
                    }
                }
            }
            else{
                if(index>=0) {
                    int cursor = index + 1;
                    Pair par = new Pair(data[i], sum - data[i]);
                    while (data[cursor] == sum - data[i]) {
                        if (cursor > i) {
                            pairs.add(par);
                        }
                        if (cursor + 1 < data.length)
                            cursor++;
                        else
                            break;
                    }
                }
            }
        }
        return pairs;
    }
}
