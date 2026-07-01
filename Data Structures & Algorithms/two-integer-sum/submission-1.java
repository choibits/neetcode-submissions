class Solution {
    public int[] twoSum(int[] nums, int target) {
        // edge cases - return empty list?

        // loop within a loop to check each
        // this would be the least efficient O(n^2)

        // complement? 
        // target - num = complement
        // int complement = target - nums[0];

        int[] indices = new int[2];
        indices[0] = 0;
        // use a hash map for quick lookup
        // number, complement
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                indices[0] = map.get(complement);
                indices[1] = i;
            }
            map.put(nums[i], i);
        }
        return indices;

        // returns an array of two integers
    }
}
