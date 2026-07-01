class Solution {
    // if you're allowed to Modify the array.
    // Then what you could do is SORT the array
    //  loop through each number in the array
    // and if you encounter a duplicate when looping, then you would immediately return true
    fun hasDuplicate(nums: IntArray): Boolean {
        // don't need to 
        nums.sort()
        // you need the index in this case
        // start at one and compare 0 to 1... etc.
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i-1]) return true
        }
        return false
    }
    // time complexity: O(nlogn) because of the sort method
    // each integer must be went through and it takes logn (divide and conquer / tree depth)
    // collection is repeatedly divided into half
    // space complexity: O(1) sorts the existing array rather than creating a new one
}
