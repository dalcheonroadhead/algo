class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        boolean [] isAppear = new boolean[101];

        for(int i = 0; i < nums.length; i ++) {
            isAppear[nums[i]] = true;
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        for(int i = 1; i < 101; i ++) {
            if(!isAppear[i]) continue;

            if(isAppear[i] && i > k) ans++;
            else if(isAppear[i] && i < k) return -1;
        }

        return ans;
    }
}