package arrays;

import java.util.ArrayList;
import java.util.List;

public class buyAndSellStock {

  public int maxProfit(List<Integer> stockValues){

    // finding max and min won't help b/c max could appear before min
    // we wanna maximize the change in values at positions i,j where i < j
    // at current value we can say maxProfit = max(maxProfit - curr,
    // minSoFar = min(minSoFar,curr)
    // maxprofitSoFar = max(maxProfitSoFar, curr - minSoFar)

    int maxProfitSoFar = 0;
    int minPriceSoFar = Integer.MAX_VALUE;
    for(int i = 0; i < stockValues.size(); i++){
      minPriceSoFar = Math.min(minPriceSoFar, stockValues.get(i));
      maxProfitSoFar = Math.max(maxProfitSoFar, stockValues.get(i) - minPriceSoFar);
    }

    return maxProfitSoFar;

  }

  public int TwoSales(List<Integer> stockValues){

    // second buy must be made after first sale
    // hint: what do u need to know about first i elements before (i+1)th element
    // we must maximize change in values of two portions of the array

    //O(n2) if we ran above algorithm for each input
    // bottleneck : recalculating the profits

    // soln to bottleneck: let's calculate all profits if we sell on current day
    // so if we have profits for each day
    // we need to find a way to get max profits for 2 buy/sells
    // we have an array that represents max if we sell on day i
    // let's have array that represents max if we buy on day i
    // combine both to get max profits for two transactions
    // let's say at i, we want max profits if we buy on day i + 1; so we can combine max profit from selling on day i and buying on day i + 1

    //soln:
    // calculate array for max profit if sold on day i  O(n)
    // have a reverse iteration to find the max profit if we bought on this day O(N)
      // keep track of max and subtract max from current day

    int maxProfitSoFar = 0;
    int minPriceSoFar = Integer.MAX_VALUE;
    List<Integer> maxProfitSold = new ArrayList<>();
    for(int i = 0; i < stockValues.size(); i++){
      minPriceSoFar = Math.min(minPriceSoFar, stockValues.get(i));
      maxProfitSoFar = Math.max(maxProfitSoFar, stockValues.get(i) - minPriceSoFar);
      maxProfitSold.add(maxProfitSoFar);
    }

    // reverse iteration for max profit if bought today
    List<Integer> maxProfitBought = new ArrayList<>(List.of(0,0,0,0,0,0,0,0,0));
    int maxPriceSoFar = Integer.MIN_VALUE;
    for(int i = stockValues.size()-1; i >= 0; i--){
      maxPriceSoFar = Math.max(maxPriceSoFar, stockValues.get(i));
      maxProfitBought.set(i, maxPriceSoFar - stockValues.get(i));
    }

    // max two transactions would be maxProfitSold.at(i) + maxProfitBought.at(i+1)
    int maxValue = Integer.MIN_VALUE;
    for(int i = 0; i < stockValues.size()-2; i++){
      maxValue = Math.max(maxValue, maxProfitSold.get(i) + maxProfitBought.get(i+1));
    }
    return maxValue;

  }
}
