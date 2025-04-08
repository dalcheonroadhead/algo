class Solution {
    public int minimumOperations(int[] nums) {
        // 1. make hash map that has number as key, counts that number is appear as value
        // 2. remove 3 elements from array
        // 2-1 when I remove element, I should substract value with 1 in hashmap values
        // 2-2 when all hashmap's key has only 1 value, finish minimumOperations function

        int numsThatsMoreThan1 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int now =  
            map.compute(nums[i], (k,ov) -> {
                if(ov == null) return 1; 
                else return ov+1;
                });

            if(now == 2) numsThatsMoreThan1++;
        }

        if(numsThatsMoreThan1 == 0) return 0;

        int iter = 0;
        int ans = 0;
        while (iter < nums.length) {
            int left = nums.length - iter;
            for(int i = 0; i < Math.min(3, left); i++) {
                int now = nums[iter++];
                Integer flag = map.compute(now, (k,ov) -> {
                    if(ov == 1) return null;
                    else if(ov == 2) return 1;
                    else return ov-1;
                });

                if(flag != null && flag == 1) numsThatsMoreThan1--;
            }
            ans++;
            if(numsThatsMoreThan1 == 0) return ans;
        }
        return ans;
    }
}