class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.compute(nums[i], (key, ov) -> (ov == null? 1 : ov+1));
        }

        if(map.firstKey() < k) return -1;

        while(map.lastKey() != k) {
            map.compute(map.lastKey(), (key, ov) -> null);
            ans++;
            if(map.size() == 0) break;
        }

        return ans;
    }
}