class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        // map would store the complement as a key and the index as the value

        // loop through array
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                // return the answer with the smaller index first
                return intArrayOf(map[complement]!!, i)
            }
            // don't add the complement, add the int and its index
            map[nums[i]] = i

        }
        // return empty array
        return intArrayOf()

        // Time complexity is O(n) because you have to touch each integer in the array
        // space complexity is O(n) becuase the hashmap could store every number
    }
}

// Time complexity would be O(n) because it has to touch each number in the array at the most,
// and then the space complexity would technically be O(1) because it will always be two integers. 

// wrong solution:
        // return indices i and j such that nums[j] + nums[i] == target and i!=j
        // assume one pair satisfies the condition
        // if the length of the array is 1 or less, return immediately an empty array

        // Loop through the integers in the array
        // as you iterate through array use hashmap to store the complement number

        // for (i in 1 until nums.size) {
        //     val j = i-1
        //     // you want to compare diff indices not diff values...
        //     if (nums[i] != nums[j]) {
        //         if (nums[i] + nums[j] == target) {
        //             return IntArray(i, j)
        //         }
        //     }
        // }
        // Make sure that each integer i or j is not equal to each other
        // and check whether it equals the sum. If it does equal the target sum

        // then return an array that includes both of those. If not, return an empty array. 
        // return IntArray()