class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        // a set contains only unique values
        // so you could compare the length of nums
        // with the length of the set as a boolean
        // sets use .size as does int arrays

        return nums.toSet().size != nums.size
        // time complexity of .toSet is O(n) on average,
        // under the hood iterates exactly once to add to newly instatiated LinkedHashSet
    }
}
