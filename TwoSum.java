import java.util.*;
public class TwoSum {
	 public int[] twoSum(int[] nums, int target) {
        int[] sumIndices = new int[2];
        int remaining;
        Map<Integer,Integer> indcMap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            remaining=target-nums[i];
            if(indcMap.containsKey(remaining)){
                sumIndices[0]=indcMap.get(remaining);
                sumIndices[1]=i;
                break;
            }
            indcMap.put(nums[i],i);
        }
        return sumIndices;
    }
}
