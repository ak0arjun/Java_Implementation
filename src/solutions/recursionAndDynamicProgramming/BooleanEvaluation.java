package solutions.recursionAndDynamicProgramming;

import solutions.TestCaseAbstract;

/**
 * Determine all possible way to add brackets to given boolean string for
 * obtaining the specified result.
 */
public class BooleanEvaluation extends TestCaseAbstract {

    @Override
    public void run() {
        System.out.println("Boolean Eval for 1^0|0|1 for false=" + findCombinationsForResult("1^0|0|1", false));
    }

    protected Integer findCombinationsForResult(String expr, boolean result) {
        Integer res = 0;
       
        System.out.println("Res=" + res);
        return res;
    }



}
