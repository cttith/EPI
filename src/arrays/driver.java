package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class driver {


    public static void main(String[] args){

        // 6_01 DutchFlag
        List<Integer> dFlag = new ArrayList<Integer>(Arrays.asList(1,5,8,9,3,2,4,1));
        List<Integer> variant_one = new ArrayList<Integer>(Arrays.asList(3,3,3,2,1,2,1,2,1,1,3));

        DutchFlag_6_01 ex_6_01 = new DutchFlag_6_01();
        ex_6_01.dutchFlagQS(dFlag,1); // val = 5
        ex_6_01.dutchFlagQS(variant_one, 3);

        // 6_02 IncrementInteger
        List<Integer> incInt = new ArrayList<Integer>(Arrays.asList(9,9,9,1));

        IncrementArbitraryInteger_6_02 ex_6_02 = new IncrementArbitraryInteger_6_02();
        ex_6_02.incrementArr(incInt);


        // 1 1 1 = 7
        // 1 0 1 = 5
        //10  1  0 = 12
        String seven = "111";
        String five = "101";
        String two = "10";
        String res = ex_6_02.bPlusBtwo(seven,two);
        System.out.println("\nbPlusBtwo = " + res);

        // [3,2,0,0,0,1] = false, furthest index we can reach is 3 -> 3,3,3,3, i > max
        // [3,0,0,1,0] = true, furthest index we can reach is 4 maxReach -> 3,3,3,4,4
        Advance_through_array_6_04 ex_6_04 = new Advance_through_array_6_04();
        boolean case1 = ex_6_04.canFinish(List.of(3,0,0,2,1,0));
        boolean case2 = ex_6_04.canFinish(List.of(4,0,0,0,0,1,1));
        System.out.println("\ncase1 = " + case1);
        System.out.println("case2 = " + case2);

        // min steps
        int min1 = ex_6_04.minSteps(List.of(3,0,0,2,1,0));
        int min2 = ex_6_04.minSteps((List.of(1,1,1,1,0)));
        System.out.println("\nminSteps case1 = " + min1);
        System.out.println("minSteps case2 = " + min2);


        // removeDuplicateFromSortedArr
        removeDuplicateFromSorted_6_05 ex_6_05 = new removeDuplicateFromSorted_6_05();
        ex_6_05.removedDuplicates(List.of(1,1,2,2,3,3,4,4,5,5,6,6));

        // buyStockOnce
        buyAndSellStock ex_6_06 = new buyAndSellStock();
        System.out.println("\nmax profit = " + ex_6_06.maxProfit(List.of(5,4,3,3,2,1)));

        // buyAndSellTwice
        System.out.println("max profit = " + ex_6_06.TwoSales(List.of(12,11,13,9,12,8,14,13,15)));

        ApplyPermutation ex_6_07 = new ApplyPermutation();
        ex_6_07.reorder();

        spiralArray ex_6_17 = new spiralArray();
        ex_6_17.spiralPrint(List.of(List.of(1,2,3,4,5), List.of(6,7,8,9,10), List.of(11,12,13,14,15), List.of(16,17,18,19,20), List.of(21,22,23,24,25)));

        rotate2DArray ex_6_18 = new rotate2DArray();
        int[][] arr = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        System.out.println();
        ex_6_18.rotateArr(arr);

        pascalsTriangle ex_6_19 = new pascalsTriangle();
        ex_6_19.returnNRowsOfPascalsTriangle(5);




    }
}
