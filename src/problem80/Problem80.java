package problem80;

import java.util.Stack;

public class Problem80 {
    public static class MinStack {
        record Pair(int val, int minimumSeenSoFar) {}
        private final Stack<Pair> stack;

        public MinStack() {
            this.stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Pair(val, val));
                return;
            }
            // Peek the element below and check if the minimum
            int minSoFar = stack.peek().minimumSeenSoFar;
            if (val < minSoFar) {
                stack.push(new Pair(val, val));
                return;
            }
            stack.push(new Pair(val, minSoFar));
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().minimumSeenSoFar;
        }
    }
}
