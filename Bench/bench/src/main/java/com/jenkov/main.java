package com.jenkov;


public static void main(String[] args) throws Exception {
Options opt = new OptionsBuilder()
	  .addProfiler("gc")
	  .include(".*" + StringOpBenchmarks.class.getSimpleName() + ".*test.*")
	  .build();

  new Runner(opt).run();
}