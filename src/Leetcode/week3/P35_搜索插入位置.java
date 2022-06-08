package Leetcode.week3;

/**
 * @author: CaiSongZhi
 * @date: 2022/6/8 9:33
 * @project: Leetcode.week3
 * @content: https://leetcode.cn/problems/search-insert-position/
 * 二分
 */
public class P35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(n == 0 || target <= nums[0]) return 0;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(nums[mid] < target) l = mid;
            else r = mid - 1;
        }
        return l + 1;
    }
}
