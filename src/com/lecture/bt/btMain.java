package com.lecture.bt;

import java.util.ArrayList;
import java.util.List;

public class btMain {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        //perBtFunction(result,temp,nums);
        System.out.println(result);


    }

    public static void comBtFunction(){

    }
    /**
     * Permutation(순열)
     * @param result
     * @param temp
     * @param nums
     */
    public static void perBtFunction(List<List<Integer>> result, List<Integer> temp, int[] nums){
        if(temp.size()>=nums.length){
            result.add(new ArrayList<>(temp));
        }else{
            for(int i=0;i<nums.length;i++){
                if(temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                perBtFunction(result,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}
