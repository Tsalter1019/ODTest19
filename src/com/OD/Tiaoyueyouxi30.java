package com.OD;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Tiaoyueyouxi30 {
        Queue<Integer> q;
        HashSet<Integer> set;
        int[] arr;
        int n;
        public boolean canReach(int[] _arr, int start) {
            arr = _arr;
            n = arr.length;
            // 当前位置即是下标为0的位置
            if(arr[start] == 0) return true;
            q = new LinkedList<>();
            set = new HashSet<>();
            q.add(start);
            set.add(start);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    int curIdx = q.poll();
                    if(bfs(curIdx, 0)) return true;
                }
            }
            return false;
        }
        public boolean bfs(int idx, int target){
            // 可以跳到的前一个位置
            int before = idx - arr[idx];
            // 可以跳到的后一个位置
            int after = idx + arr[idx];
            // 不超出边界的情况下
            if(before >= 0){
                // 且未访问过
                if(!set.contains(before)){
                    // 已经找到了目标位置
                    if(arr[before] == target) return true;
                    // 加入队列的同时需要标记为已访问
                    q.add(before);
                    set.add(before);
                }
            }
            // 后一个位置与前一个位置同理可得
            if(after < n){
                if(!set.contains(after)){
                    if(arr[after] == target) return true;
                    q.add(after);
                    set.add(after);
                }
            }
            return false;
        }
    }

