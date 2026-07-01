class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // hashmap because you need to keep track of counts
        // from the examples, it looks like you actually want to return the k top counts
        // so for example: if k is 2
        // you give the top 2 most frequent numbers
        // also returns a primitive array, output can be in any order

        // == STEP 1. CREATE HASHMAP TO KEEP TRACK OF INTEGER: COUNTS
        Map<Integer, Integer> counts = new HashMap<>();

        // == STEP 2. LOOP THROUGH INTEGERS IN nums TO GET FREQUENCY
        // The below is wrong because without an if else, you would add it twice
        // for (int i = 0; i < nums.length; i++) {
        //     // if the key does not exist, add number as a key with default 1
        //     if (!counts.containsKey(nums[i])) {
        //         counts.put(nums[i], 1);
        //     }
        //     // add to the count if the number exists in as a key
        //     counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        // }

        for (int n: nums) {
            counts.put(n, counts.getOrDefault(n, 0) +1);
        }

        // Example
        // Input: nums = [1,2,2,3,3,3], k = 2
        // Loop i=0: 
        // 1: 1
        // Loop i=1:
        // 1: 1, 2: 1
        // Loop i=2: 
        // 1:1, 2:2
        // Loop i=5:
        // 1:1, 2:2, 3:3

        // what i want to return: part of [3, 2, 1] 

        // Option 1. (expensive)
        // would be to loop through the map and create a list 
        // with the int with highest frequencies highest to lowest
        // but sorting can be expensive

        // Option 2. Create a bucket where index = frequency
        // so numbers that show up 1 times are at index 1 (in a list)
        // numbers that show up 2 times have index 2 (in a list)
        // then walk highest down to give back the array

        // the below line won't work because you need to have a list of lists
        // List<Integer> = new ArrayList<>();

        // has to be nums.length +1 because 0 will have nothing
        // and the highest num of frequencies would be nums.length+1

        // == STEP 3. CREATE FREQUENCY INDEX (BUCKET)
        List<Integer>[] bucket = new List[nums.length +1];

        // have to loop through the bucket to create an array list at each
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // 1:1, 2:2, 3:3 would turn into
        // bucket = [0: [], 1: [1], 2: [2], 3: [3]]

        // == STEP 4. FILL BUCKET LIST
        // LEARNING: MAP USES .entrySet() instead of length
        // need to loop through each entry of the map and pull out the key and value
        // to add to the correct bucket index
        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            bucket[freq].add(num); // bucket is a list of lists, so you grab through
            // bracket notation and add.
        }

        // == STEP 4. Collect top k from highest frequency down
        // primitive array
        int[] result = new int[k];
        int idx = 0;

        for (int freq = bucket.length - 1; freq >= 0 && idx < k; freq--) {
            // because bucket[freq] is a list of numbers, you must iterate inside that list
            // in order to add numbers to the array. below would NOT work.
            // result.add(bucket[freq]);
            // idx--;

            for (int num: bucket[freq]) {
                result[idx] = num; // can't use .add because you need to access by index
                idx = idx+1; // need this to make sure that index goes up, but also
                // if k was 1, you'd need it to stop here!
                // since one bucket can have more than one number
                // the inner loop needs its own stop condition
                if (idx == k) break;
            }
        }
        return result;
    }
}
