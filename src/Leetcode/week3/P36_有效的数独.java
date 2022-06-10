package Leetcode.week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: CaiSongZhi
 * @date: 2022/6/9 9:36
 * @project: Leetcode.week3
 * @content: https://leetcode.cn/problems/valid-sudoku/
 */
class P36_有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Boolean> h = new HashMap<>();
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i ++ ){
            h.clear();
            for(int j = 0; j < m; j ++ ){
                if(board[i][j] == '.') continue;
                if(h.getOrDefault(board[i][j], false)){
                    System.out.println(board[i][j]);
                    return false;
                }
                h.put(board[i][j], true);
            }
        }
        h.clear();
        for(int i = 0; i < m; i ++ ){
            h.clear();
            for(int j = 0; j < n; j ++ ){
                if(board[j][i] == '.') continue;
                if(h.getOrDefault(board[j][i], false)){
                    System.out.println(board[j][i]);
                    return false;
                }
                h.put(board[j][i], true);
            }
        }
        h.clear();
        for(int id = 0; id < 9; id ++ ){
            int sx = (id / 3) * 3, sy = (id % 3) * 3;
            h.clear();
            for(int i = sx; i < 3; i ++ ){
                for(int j = sy; j < 3; j ++ ){
                    if(board[i][j] == '.') continue;
                    System.out.println(board[i][j]);
                    if(h.getOrDefault(board[i][j], false)){
                        return false;
                    }
                    h.put(board[i][j], true);
                }
            }
        }
        return true;
    }
}