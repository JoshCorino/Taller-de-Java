package edu.isistan.solutions;

import java.util.ArrayList;
import java.util.Arrays;

import edu.isistan.IProblemSolver;
import edu.isistan.ProblemGen;

public class Solutions {

	public static void main(String[] args) {
		
		ProblemGen problemGen = new ProblemGen();
		ArrayList<IProblemSolver> solutors = new ArrayList<IProblemSolver>();
		solutors.add(new SolutionNaive());
		solutors.add(new SolutionNaive2());
		solutors.add(new SolutionMap());
		solutors.add(new SolutionMapFixed());
		solutors.add(new SolutionMapTwo());
		solutors.add(new SolutionMapTwoFixed());
		solutors.add(new SolutionMapThree());
		solutors.add(new SolutionSortSearch());

		problemGen.genRandomProblem(5000000);
		int random=(int)(Math.random() * 2 * Integer.MAX_VALUE + Integer.MIN_VALUE/2);

		for (IProblemSolver i: solutors){
			i.isSumIn(problemGen.getData(), random);
			Runtime.getRuntime().gc();
		}


	}
}
