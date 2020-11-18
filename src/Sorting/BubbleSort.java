package Sorting;

public class BubbleSort {
    public void bubbleSort(int[] nums){
        if(nums.length<1) return;
        for(int i=0;i<nums.length;i++){
            boolean numsSwitched = false;
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                    numsSwitched=true;
                }
            }
            if(!numsSwitched) break;
        }
    }
}
