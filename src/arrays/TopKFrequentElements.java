package arrays;

import org.junit.Test;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* 347. Top K Frequent Elements
*
*
* Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
* */
public class TopKFrequentElements {

    /**
     * @param k top elements
     * @param nums  integer array
     * @return array of k frequent elements
     * */
    private int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> integerHashMap = new HashMap<>();

        for (int number : nums){
            if(integerHashMap.containsKey(number)){
                integerHashMap.put(number,integerHashMap.getOrDefault(number,1)+1);
            } else {
                integerHashMap.put(number,1);
            }
        }

        Queue<Integer> integerQueue = new PriorityQueue<>((n1,n2)-> integerHashMap.get(n1)- integerHashMap.get(n2));

        int count = 0;
        for (Integer integer : integerHashMap.keySet()) {
            integerQueue.add(integer);
            count++;
            if(count>k){
                integerQueue.poll();
            }

        }

        int[] result = new int[k];
        for(int i = 0;i < k;i++){
            result[i] = integerQueue.poll();
        }
        return result;
    }

    @Test
    public void test(){
        topKFrequent(new int[]{99,13,12,11,14,14,14,14,11,11,12,99,99},2);
    }
}
