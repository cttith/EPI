package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DutchFlag_6_01 {

    // Quicksort
        // makes subarray based on random pivot
        // recursively does same process on two subarrays

    // BACKGROUND:
    // quicksort variant
    // quicksort has large run times and deep function call stacks
    // on arrys with many duplicates b/c subarrays may differ greatly
    // in size.
    // problem stems from quicksort reordering elements less than
    // or equal to pivot to the left

    // PROBLEM:
    // an array where elements less than pivot, followed by elements
    // equal to pivot, followed by elements greater than pivot

    // REASON:
    // this avoids the need to move duplicate elements O(N^2)
    // normal quicksort can lead to O(n^2) when given elements
    // in reverse order or already sorted order

    // WORST CASE PIVOT:
    // min or max is chosen



    // we have four boundaries, will result in three final bounds
    // less : (0, lowerBound)
    // equal : (lowerBound,equal)
    // unclassified : (equal, larger)
    // larger : (larger, arr.size))
    // use equal as current unclassified

    // (0,lower) (lower+1,equal) (equal+1,larger)
    // when u start you don't know any elememts in the list so everything is "unclassified"
    // initialize lower bound to 0, upperbound to size of arr
    // if < piv found swap to lowerbound position, increment lowerbound, increment equal (b/c equal swaps position with a number that is already low < piv as well)
    // if > piv found swap to upperbound position, decrement lowerbound, don't increment equal (b/c the swap could place another # > piv in position)
    // if == piv, increment equal

    // *** divide array into two parts, less than and greater than; this will push the equal parts into the middle
    public void dutchFlagQS(List<Integer> arr, int pivotIndex){

        int piv = arr.get(pivotIndex);
        int lowerBound = 0;
        int equal = 0;
        int upperBound = arr.size();

        while(equal < upperBound){
            System.out.println("upperBound = " + upperBound);
            System.out.println("lowerBound = " + lowerBound);
            System.out.println("equal = " + equal);
            System.out.println("current(equal) value = " + arr.get(equal));
            System.out.println("pivot = " + piv);
            // arr.get(equal) is the unclassified element
            if(arr.get(equal) < piv){           // if current element less than pivot, swap the current element with end of where pivot(equal) bound stands
                swap(arr,lowerBound++,equal++);
            }
            else if (arr.get(equal) == piv){    // if current element is == to pivot, advance the equal bound
                ++equal;
            }
            else {                              // if current element > pivot, swap current element with beginning of where upperbound stands
                swap(arr,--upperBound,equal);
            }
            printArr(arr);
        }

    }

    public static void swap(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }


    public void printArr(List<Integer> arr){
        System.out.println("\nCurrent Array ");
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println("\n====================\n");
    }


}
