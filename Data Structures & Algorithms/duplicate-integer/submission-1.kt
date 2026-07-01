class Solution {
    // return a Boolean
    // cycle through the array with a for loop
    // you must get the count, could be done with a hashmap
    // as soon as you get a duplicate, you could return right away for efficiency
    fun hasDuplicate(nums: IntArray): Boolean {
        // hashmap
        val map = HashMap<Int, Int>()
        // cycle through the array
        for (num in nums) {
            // add the count, first time count should be 1 on default
            // if it's in the map then you want to return true 
            if (num in map) {
                return true
            } else {
                // map.put()
                map[num] = 1
            }
        }
        return false
    }
}

// this would be
// time complexity: O(n) if n is the length of the intarray
// space complexity: O(n) because hashmaps would only store up to n 