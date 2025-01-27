package DailyQuestionsLeetCode;

import java.util.*;

public class LexicgraphicallySmallArray_2948 {
    public static void main(String[] args) {
        int[] nums = {1,5,3,9,8};
        int[] res = lSABruteForce(nums,2);
//        int[] res1 = lSABetterApproach1(nums,2);
        for (int i : res){
            System.out.print(i + ", " );
        }
    }

    private static int[] lSABetterApproach1(int[] nums, int limit) {
                int[] sortedNums=nums.clone();
                Arrays.sort(sortedNums);
                Map<Integer,Integer> groupOfEle=new HashMap<>();
                int curGroup=0;
                groupOfEle.put(sortedNums[0],curGroup);
                Map<Integer, LinkedList<Integer>> listOfGroup=new HashMap<>();
                listOfGroup.put(curGroup,new LinkedList<Integer>(Arrays.asList(sortedNums[0])));
                for(int i=1;i<nums.length;i++){
                    if(Math.abs(sortedNums[i]-sortedNums[i-1])>limit){
                        curGroup++;
                    }
                    groupOfEle.put(sortedNums[i],curGroup);
                    if(!listOfGroup.containsKey(curGroup)){
                        listOfGroup.put(curGroup,new LinkedList<Integer>());
                    }
                    listOfGroup.get(curGroup).add(sortedNums[i]);
                }
                for(int i=0;i<nums.length;i++){
                    int num=nums[i];
                    int group=groupOfEle.get(num);
                    nums[i]=listOfGroup.get(group).poll();
                }
                return nums;
    }

    public static int[] lSABruteForce(int[] nums, int limit) {
        for (int i = 0; i < nums.length; i++) {

            while(true) {
                int smallValue = nums[i];
                int idx = -1;
                for (int j = i+1; j < nums.length; j++) {
                    if(Math.abs(nums[i] - nums[j]) <= limit) {
                        if(nums[j] < smallValue) {
                            smallValue = nums[j];
                            idx=j;
                        }
                    }
                }
                if (idx != -1){
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                }else{
                    break;
                }
            }
        }

        return nums;
    }
}
