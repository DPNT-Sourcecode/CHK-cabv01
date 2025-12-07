package io.accelerate.solutions.CHK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        if (skus == null) {
            return -1;
        }

        int[] counts = new int[26];

        for (char c : skus.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return -1;
            }
            counts[c - 'A']++;
        }

        int freeBs = counts['E' - 'A'] / 2;
        counts['B' - 'A'] = Math.max(0, counts['B' - 'A'] - freeBs);

        int freeMs = counts['N' - 'A'] / 3;
        counts['M' - 'A'] = Math.max(0, counts['M' - 'A'] - freeMs);

        int freeQs = counts['R' - 'A'] / 3;
        counts['Q' - 'A'] = Math.max(0, counts['Q' - 'A'] - freeQs);

        int total = 0;

        
        int countS = counts['S' - 'A'];
        int countT = counts['T' - 'A'];
        int countX = counts['X' - 'A'];
        int countY = counts['Y' - 'A'];
        int countZ = counts['Z' - 'A'];

        int totalGroupItems = countS + countT + countX + countY + countZ;
        int numberOfGroups = totalGroupItems / 3;
        
        total += numberOfGroups * 45;

        int itemsToRemove = numberOfGroups * 3;

        char[] priority = {'Z', 'S', 'T', 'Y', 'X'};
        
        for (char item : priority) {
            while (itemsToRemove > 0 && counts[item - 'A'] > 0) {
                counts[item - 'A']--;
                itemsToRemove--;
            }
        }

        for (int i = 0; i < 26; i++) {
            char item = (char) ('A' + i);
            int count = counts[i];

            if (count > 0) {
                switch (item) {
                    case 'A': 
                        total += (count / 5) * 200;
                        count %= 5;
                        total += (count / 3) * 130;
                        count %= 3;
                        total += count * 50;
                        break;

                    case 'B':
                        total += (count / 2) * 45 + (count % 2) * 30;
                        break;

                    case 'C': total += count * 20; break;
                    case 'D': total += count * 15; break;
                    case 'E': total += count * 40; break;

                    case 'F':
                        total += (count / 3) * 20 + (count % 3) * 10;
                        break;

                    case 'G': total += count * 20; break;

                    case 'H': 
                        total += (count / 10) * 80;
                        count %= 10;
                        total += (count / 5) * 45;
                        count %= 5;
                        total += count * 10;
                        break;

                    case 'I': total += count * 35; break;
                    case 'J': total += count * 60; break;

                    case 'K': 
                        total += (count / 2) * 120 + (count % 2) * 70;
                        break;

                    case 'L': total += count * 90; break;
                    case 'M': total += count * 15; break;
                    case 'N': total += count * 40; break;
                    case 'O': total += count * 10; break;

                    case 'P':
                        total += (count / 5) * 200 + (count % 5) * 50;
                        break;

                    case 'Q': 
                        total += (count / 3) * 80 + (count % 3) * 30;
                        break;

                    case 'R': total += count * 50; break;
                    
                    case 'S': total += count * 20; break; 
                    case 'T': total += count * 20; break; 
                    
                    case 'U': 
                        total += (count / 4) * 120 + (count % 4) * 40;
                        break;

                    case 'V': 
                        total += (count / 3) * 130;
                        count %= 3;
                        total += (count / 2) * 90;
                        count %= 2;
                        total += count * 50;
                        break;

                    case 'W': total += count * 20; break;
                    case 'X': total += count * 17; break; 
                    case 'Y': total += count * 20; break; 
                    case 'Z': total += count * 21; break;
                }
            }
        }

        return total;
    }
}