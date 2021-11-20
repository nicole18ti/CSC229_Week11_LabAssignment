/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week11_problemssolutions;

/**
 *
 * Solve problem 03:
 * We can easily verify that none of the entries in the first seven rows of Pascal's triangle are divisible by 7:

 	 	 	 	 	 	 1
 	 	 	 	 	 1	 	 1
 	 	 	 	 1	 	 2	 	 1
 	 	 	 1	 	 3	 	 3	 	 1
 	 	 1	 	 4	 	 6	 	 4	 	 1
 	 1	 	 5	 	10	 	10	 	 5	 	 1
1	 	 6	 	15	 	20	 	15	 	 6	 	 1
However, if we check the first one hundred rows, we will find that only 2361 of the 5050 entries are not divisible by 7.

Find the number of entries which are not divisible by 7 in the first one billion (109) rows of Pascal's triangle.
* 
*   // Solution: 2129970655314432
* 
* 
 */

public class Problem03 {
   static final int max = 1000000000; // target of (10^9)row of Pascal's triangle
    
// I found a formula online: f(0) = 1, f(7a + k) = (1+k) * f(a), k<7
// so, for the remaining value which are those could not be grouped, and apply this revursively intil it's finished
   private static long sum(int max2) {
		if (max2<=7) return max2*(max2+1)/2;
		int r = max2-max2%7;
		long ans=0;
		for (int i=r;i<max2;i++) ans += not7(i);
		return ans+28*sum(r/7);
		
	}
// This method would give me how many numbers in row x weren't multiples of 7
	private static long not7(int i) { 
		if (i==0) return 1; // base case of 0
		else return (1+i%7)*not7(i/7); 
	}
        
        public static void main(String[] args) {
            System.out.println("The number of entries which are not divisible by 7 in the first one billion: " + sum(max));

	}
}

  // Solution: 2129970655314432