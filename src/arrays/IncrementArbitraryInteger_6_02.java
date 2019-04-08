package arrays;

import java.util.List;

public class IncrementArbitraryInteger_6_02 {

    public void incrementArr(List<Integer> arr){

        boolean done = false;
        int lastIncrementedIndex = arr.size() - 1;
        int carry = 0;

        while(!done){
            if(arr.get(lastIncrementedIndex) == 9){
                if(lastIncrementedIndex == 0){
                    arr.set(0,1);
                    arr.add(0);
                    done = true;
                }else{
                    arr.set(lastIncrementedIndex, 0);
                    lastIncrementedIndex--;
                }
            }else{
                arr.set(lastIncrementedIndex,arr.get(lastIncrementedIndex) + 1);
                done = true;
            }

        }

        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();

    }

    // two string as bits
    // return new string of bits
    // 1 1 1 = 7
    // 1 0 1 = 5
    //10  1  0 = 12
    public String bPlusBtwo(String bits_one, String bits_two){
        // return larger string
        StringBuilder largerNumber;
        StringBuilder smallerNumber;
        int carry = 0;
        int sum;

        if(bits_one.length() >= bits_two.length()){
            largerNumber = new StringBuilder(bits_one);
            smallerNumber = new StringBuilder(bits_two);
        }else{
            largerNumber = new StringBuilder(bits_two);
            smallerNumber = new StringBuilder(bits_one);
        }


        // add place by place
        // keep ngoing until length of shorter string
        // have a carry
        int largerNumberIndex = largerNumber.length() - 1;
        for(int i = smallerNumber.length() - 1; i >= 0; i--){
            sum = largerNumber.charAt(largerNumberIndex) - '0' + smallerNumber.charAt(i) - '0' + carry;

            if (sum >= 2) {
                carry = 1;
                if(sum == 3){
                    largerNumber.setCharAt(largerNumberIndex, '1');
                }else{
                    largerNumber.setCharAt(largerNumberIndex, '0');
                }
            }else{
                carry = 0;
                largerNumber.setCharAt(largerNumberIndex, (char) sum);
            }

            largerNumberIndex--;

        }

        if(bits_one.length() == bits_two.length()){
            largerNumber.insert(0, '1');
        }
        else{
            while(carry == 1 && largerNumberIndex >= 0){

                    sum = largerNumber.charAt(largerNumberIndex) - '0' + 1;
                    if(sum == 2){
                        carry = 1;
                        largerNumber.setCharAt(largerNumberIndex--,'0');
                    }else{
                        largerNumber.setCharAt(largerNumberIndex--, '1');
                        carry = 0;
                    }
                }
        }

        return largerNumber.toString();

    }



}
