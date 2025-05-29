/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.

Example 1:
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
*/

//Approach - 1 TIME LIMIT EXCEEDED
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        for(int i = 0; i < gas.length; i++) {
            if(gas[i] < cost[i]) continue;
            int j = (i + 1) % gas.length; //GOL GOL ghumne k liye

            int currGasAtStation = gas[i];
            int currCostForMovingNextStation = cost[i];
            int gasEarnedNextStation = gas[j];

            //resultantTank      =      gas[i]      -         cost[i]              +      gas[j]
            int currentTankTotal = currGasAtStation - currCostForMovingNextStation + gasEarnedNextStation;
            while(j != i) {
                if(currentTankTotal < cost[j]) break;

                int currCostForMovingNextStationj = cost[j];
                //currentTankTotal = currentTankTotal - cost[j]
                currentTankTotal -= currCostForMovingNextStationj;

                j = (j + 1) % gas.length;
                int gasEarnedNextStationj = gas[j];
                // currentTankTotal = currentTank + gas[j]
                currentTankTotal += gasEarnedNextStationj;
            }
            if(j == i) return i; //Checking if we come again on the same station or not
        }
        return -1;
    }
}

//Approach - 2 Greedy Approach TC - O(n) SC - O(1)
//All thanks to CodeStoryWithMIK for the solution
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        for(int g : gas) {
            gasSum += g;
        }

        int costSum = 0;
        for(int c : cost) {
            costSum += c;
        }

        if(gasSum < costSum) return -1;

        int total = 0;
        int result = 0;
        for(int i = 0; i < gas.length; i++) {
            total = total + gas[i] - cost[i];

            if(total < 0) {
                result = i + 1;
                total = 0;
            }
        }

        return result;
    }
}