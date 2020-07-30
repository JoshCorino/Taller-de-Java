package edu.isistan;

public class MemoryTest {
    IProblemSolver solution;

    public MemoryTest(IProblemSolver solution){
        this.solution=solution;
    }

    public void countMemory(ProblemGen problem, int random){
        int [] data=problem.getData();
        Runtime runtime = Runtime.getRuntime();
        long actualMemory =(runtime.totalMemory() - runtime.freeMemory())/ (1024*1024) ;
        solution.isSumIn(data, random);
        System.out.println("Memory used "+solution.toString() +" "+ (((runtime.totalMemory() - runtime.freeMemory())/ (1024*1024))- (actualMemory)) + "MB");
    }
}
