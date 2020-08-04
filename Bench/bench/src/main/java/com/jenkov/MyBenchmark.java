/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jenkov;

import edu.isistan.IProblemSolver;
import edu.isistan.ProblemGen;
import edu.isistan.solutions.SolutionSortSearchFixed;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class MyBenchmark {



	@State(Scope.Thread)
    public static class MyState {

        ProblemGen problemGen;
        IProblemSolver sol ;
        int random;

        public MyState(){
            this.problemGen = new ProblemGen();

            //Configuraciones de size

            //problemGen.genRandomProblem(100000);
            //problemGen.genRandomProblem(500000);
            //problemGen.genRandomProblem(1000000);
            //problemGen.genRandomProblem(5000000);
            //problemGen.genRandomProblem(10000000);
            problemGen.genRandomProblem(100000000);

            //Algoritmos

            //this.sol = new SolutionNaive();
            //this.sol = new SolutionNaive2();
            //this.sol = new SolutionSortSearch();
            this.sol = new SolutionSortSearchFixed();
            //this.sol = new SolutionMap();
            //this.sol = new SolutionMapFixed();
            //this.sol = new SolutionMapTwo();
            //this.sol = new SolutionMapTwoFixed();
            //this.sol = new SolutionMapThree();

            this.random=(int)(Math.random() * 2 * Integer.MAX_VALUE + Integer.MIN_VALUE/2);

        }

    }

    @Benchmark @BenchmarkMode(Mode.AverageTime)

    public void testMethod(MyState state) {
	    state.sol.isSumIn(state.problemGen.getData(), state.random);
	}

}
