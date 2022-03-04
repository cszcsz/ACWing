package Leetcode.week2;

/**
 * @author: CaiSongZhi
 * @date: 2022/3/4 9:15
 * @project: Leetcode.week2
 * @content:
 */
public class P26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int k = 1;
        for(int i = 0, j = 0; j < nums.length;){
            while(j < nums.length && nums[j] == nums[i]) j ++ ;
            if(j < nums.length){
                nums[ ++ i] = nums[j];
                k ++ ;
            }
        }
        return k;
    }
}
