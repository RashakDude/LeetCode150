import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) return -1;
        int start = 0, remaining = 0;
        for (int i = 0; i < gas.length; i++) {
            remaining += (gas[i] - cost[i]);
            if (remaining < 0) {
                start = i+1;
                remaining = 0;
            }
        }
        return start;
    }
}