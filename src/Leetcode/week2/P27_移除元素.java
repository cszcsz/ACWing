package Leetcode.week2;

/**
 * @author: CaiSongZhi
 * @date: 2022/3/7 10:19
 * @project: Leetcode.week2
 * @content: https://leetcode-cn.com/problems/remove-element/ 简单
 */
public class P27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i < nums.length; i ++ ){
            if(nums[i] != val)
                nums[k ++ ] = nums[i];
        }
        return k;
    }
}
