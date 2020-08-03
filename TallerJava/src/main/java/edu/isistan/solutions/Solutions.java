package edu.isistan.solutions;

import java.util.ArrayList;
import java.util.Arrays;

import edu.isistan.IProblemSolver;
import edu.isistan.MemoryTest;
import edu.isistan.ProblemGen;

public class Solutions {

/*	public static void main(String[] args) {

		ProblemGen problemGen = new ProblemGen();
		ArrayList<MemoryTest> solutors = new ArrayList<MemoryTest>();

		solutors.add(new MemoryTest(new SolutionMap()));
		solutors.add(new MemoryTest(new SolutionMapFixed()));
		solutors.add(new MemoryTest(new SolutionMapTwo()));
		solutors.add(new MemoryTest(new SolutionMapTwoFixed()));
		solutors.add(new MemoryTest(new SolutionMapThree()));
*//*		solutors.add(new MemoryTest(new SolutionNaive()));
		solutors.add(new MemoryTest(new SolutionNaive2()));
		solutors.add(new MemoryTest(new SolutionSortSearch()));*//*
		solutors.add(new MemoryTest(new SolutionSortSearchFixed()));

        problemGen.genRandomProblem(10000000);
        int random=(int)(Math.random() * 2 * Integer.MAX_VALUE + Integer.MIN_VALUE/2);

		for (MemoryTest i: solutors){
			i.countMemory(problemGen, random);
			Runtime.getRuntime().gc();
		}


	}*/
	public static void main(String[] args) {
		int [] data={1,2,3,4,5,2,0, 0,-1,2};
		int sum = 4;

		ArrayList<IProblemSolver> solutors = new ArrayList<IProblemSolver>();
/*		solutors.add(new SolutionNaive());
		solutors.add(new SolutionNaive2());
		solutors.add(new SolutionMap());
		solutors.add(new SolutionMapFixed());
		solutors.add(new SolutionMapTwo());
		solutors.add(new SolutionMapTwoFixed());
		solutors.add(new SolutionMapThree());
		solutors.add(new SolutionSortSearch());*/
		solutors.add(new SolutionSortSearchFixed());

		for (IProblemSolver i: solutors){
			System.out.println("Solution "+i.toString()+" cantidad de pares encontrados "+i.isSumIn(data, 4).size());
		}
	}
}
