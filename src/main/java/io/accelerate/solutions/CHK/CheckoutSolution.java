package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        if (skus == null){
            return -1;
        }
        int total = 0;
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countE = 0;

        for (char c : skus.toCharArray()) {
            switch (c) {
                case 'A':
                    countA++;
                    break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'D':
                    countD++;
                    break;
                case 'E':
                    countE++;
                    break;
                default:
                    return -1;
            }
        }
        int freeBs = countE / 2;
        countB = Math.max(0, countB - freeBs);

        int bundlesOf5A = countA / 5;
        int remainingA = countA % 5;
        int bundlesOf3A = remainingA / 3;
        int singlesA = remainingA % 3;

        total += (bundlesOf5A * 200) + (bundlesOf3A * 130) + (singlesA * 50);
        total += (countB / 2) * 45 + (countB % 2) * 30;
        total += countC * 20;
        total += countD * 15;
        total += countE * 40;

        return total;
    }
}


