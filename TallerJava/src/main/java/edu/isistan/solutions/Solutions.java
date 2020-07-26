package edu.isistan.solutions;

import java.util.Arrays;

import edu.isistan.IProblemSolver;
import edu.isistan.ProblemGen;

public class Solutions {

	public static void main(String[] args) {
		
		ProblemGen problemGen = new ProblemGen();
		
		IProblemSolver naive = new SolutionNaive();
		IProblemSolver naive2 = new SolutionNaive2();
		IProblemSolver map = new SolutionMap();
		IProblemSolver map2 = new SolutionMapTwo();
		IProblemSolver map3 = new SolutionMapThree();
		IProblemSolver mapfixed = new SolutionMapFixed();

		
		for(int i=0;i<20;i++) {
			problemGen.genRandomProblem(2500000);
//			System.out.println(Arrays.toString(problemGen.getData()));
			long start = System.currentTimeMillis(); //acá no está haciendo el warm up para empezar con el benchmarking!!
			int random=(int)(Math.random() * 2 * Integer.MAX_VALUE + Integer.MIN_VALUE/2);
			/*System.out.println(" --Naive Pairs: "+naive.isSumIn(problemGen.getData(), random).size());
			start = System.currentTimeMillis() - start;
			System.out.println(start);*/

			long start2 = System.currentTimeMillis(); //acá no está haciendo el warm up para empezar con el benchmarking!!
			System.out.println(" --map Pairs: "+map.isSumIn(problemGen.getData(), random).size());


			long start3 = System.currentTimeMillis(); //acá no está haciendo el warm up para empezar con el benchmarking!!
			System.out.println(" --map2 Pairs: "+map2.isSumIn(problemGen.getData(), random).size());
			System.out.println("--------------------------");


			long start4 = System.currentTimeMillis(); //acá no está haciendo el warm up para empezar con el benchmarking!!
			System.out.println(" --mapfixed Pairs: "+mapfixed.isSumIn(problemGen.getData(), random).size());
			System.out.println("--------------------------");

		}
	}
}
