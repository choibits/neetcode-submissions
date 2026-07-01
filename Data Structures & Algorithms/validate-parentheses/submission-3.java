class Solution {
    public boolean isValid(String s) {
        // edge case: if you start with a closing bracket then you should automatically return false

        // BIG IDEA: loop through the string and have some if else statements to check
        // we need a stack structure so that we can check the top of the stack and pop off 
        Stack<Character> stack = new Stack<>();

         // Example Input: s = "[()]"

         // s = "[]"

        // Loop and for each
        for (char c: s.toCharArray()) {
            // add to the stack until you reach closing characters
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c); // stack = [
            } else {
                // closing bracket... stack must NOT be empty
                if (stack.isEmpty()) return false;

                // if the closing character matches the top of the stack, we keep going 
                 // if not return false

                char top = stack.pop();  // pop ONCE
                if (c == '}' && top == '{') continue;
                if (c == ')' && top == '(') continue;
                if (c == ']' && top == '[') continue;
                return false;
            }

        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
