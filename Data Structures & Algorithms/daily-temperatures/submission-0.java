class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // if the next number is Bigger, update as 1 and go next.
        // if the next number isnt Bigger, initiate 2 pointers
        // - move 2nd Pointer until u see a higher number, update left pointer to that index of bigger number, 
        // store all inter numbers in a stack
        // traverse the pointer from right n update the resultValues based on stack Output.
        // start from left Pointer n iterate again
        // if 2nd pointers reaches end of arraya, mark everything in array as 0
/**
The two flavors:

Monotonic decreasing stack → pop smaller elements before pushing → used for "next greater element" problems. 
(739 — you're looking for a warmer/greater day.)
Monotonic increasing stack → pop larger elements before pushing → used for "next smaller element" problems.
Bottom-to-top ordering is the naming convention. A decreasing stack finds next-greater; an increasing stack 
finds next-smaller. Slightly counterintuitive — the decreasing stack finds the greater element — but it makes 
sense once you see why: a decreasing stack is a pile of items all still waiting for something bigger, and the 
thing that finally pops them is that bigger element.
The recognition cue for your notes: "next greater / next smaller / how many until a bigger-or-smaller value" → 
monotonic stack. 
Which direction? If you want next-greater, keep it decreasing (pop the smalls). 
If next-smaller, 
keep it increasing (pop the bigs).
**/
        Stack<Integer> monoTonicDecreasingStack = new Stack<Integer>();  
        // M.Decreasing Stack always has decreasing numbers searching for nextBiggest Number 
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            // keep popping from stack until you see a larger number than currentNumber or empty stack
            while(!monoTonicDecreasingStack.isEmpty() && temperatures[i] > temperatures[monoTonicDecreasingStack.peek()] ) {
                int last = monoTonicDecreasingStack.pop();
                result[last] = i-last;
            }

            monoTonicDecreasingStack.push(i);
        }

        return result;
    }
}
