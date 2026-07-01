class Solution {
    public boolean hasDuplicate(int[] nums) {
        // hashmaps are great for counting duplicates
        // this is also an arrays problem, 
        // so another way to do it would be to use some kind of contains check for arrays

        // hashmaps have containsKey
        // arrays have... contains? but contains would give you a boolean...

        // ideally you don't want to loop within a loop
        // i.e. time complexity of O(n^2)

        // edge case 
        // if the array is empty, then return false or true?

        HashMap map = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], 1);
        }

        return false;
    }
}