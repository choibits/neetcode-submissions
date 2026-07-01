class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        // with a hashmap...
    
        // initialize hash map, put pairs to check
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

    // EXAMPLE: "[(])"
    // map doesn't contain a closing parens yet (bc we haven't finished adding all the opening parens)
     // stack: [(
    // on third loop for c - ']'
    // map does contain key 
    // the stack is NOT empty... BUT stack.peek() = '(' and map.get(]) is [ not (
        // stack does NOT pop and returns false

        // for loop through the string 
        for (char c: s.toCharArray()) {
            // check for whether this char exists in as a closing bracket key
            if (map.containsKey(c)) {
                // if the stack is not empty
                // and the top of the stack is equal to the opening bracket for the closing
                if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop(); // pop off the stack
                } else {
                    return false; // because it's not matching
                }
            } else {
                 stack.push(c);
            }
        }
        return stack.isEmpty(); // if stack is fully empty, then you know each opening character
        // has a matching closing character
    }
}
