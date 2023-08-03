package com.ajay.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class SumService {
    public List<Integer> twoSum(List<Integer> integerList,Integer target) {
    Map<Integer,Integer> integerMap = new HashMap();
    int i =0;
        for (Integer num : integerList){
            if(integerMap.containsKey(target-num)){
                return new ArrayList<>(List.of(integerMap.get(target-num),i));
            }
            integerMap.put(num,i);
            i++;
        }
        return null;
    }

    public int[] sortedTwoSum(int[] integerList, int target) {
        int start =0;
        int end = integerList.length-1;
        while(end>start){
            if(integerList[start]+integerList[end]==target){
                return new ArrayList<>(List.of(start+1,end+1)).stream().mapToInt(Integer::intValue).toArray();
            }
            else if(integerList[start]+integerList[end]>target){
                end--;

            }else{
                start++;
            }
        }
        return null;
    }

    public List<List<Integer>> threeSum(int[] integerList) {
        List<List<Integer>> result= new ArrayList<>();
        for(int i =0;i<integerList.length;i++){
          List<Integer> subResult = twoSum(Arrays.asList(Arrays.stream(integerList, i + 1, integerList.length).boxed().toArray(Integer[]::new)), -1 * integerList[i]);
          int x =i;

          if(!CollectionUtils.isEmpty(subResult)){
              subResult.forEach(number -> number = integerList[number+x+1]);
              subResult.add(integerList[i]);
              result.add(subResult);
          }
        }
        return result;
    }
}
