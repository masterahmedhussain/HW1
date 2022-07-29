package com.HW1;

import java.util.Scanner;

public class FindNearMiss {

	public static void main(String[] args) {
		int n = 0, k = 0;
		Scanner sc = new Scanner(System.in);
		while ((n <= 2) || (n >= 12)) {
			System.out.println("Enter the number between 2 < n < 12: ");
			n = sc.nextInt();

		}
		while (k <= 10) {
			System.out.println("Enter the power limit k for x and y (k > 10):");
			k = sc.nextInt();
		}
		int miss = Integer.MAX_VALUE;
		double nearMiss = Integer.MAX_VALUE;
		for (int x = 10; x <= k; x++) {
			for (int y = 10; y <= k; y++) {
				long LHS = (int) (Math.pow(x , n) + Math.pow(y, n));
				if (LHS < 0) {
					System.out.println("Choose lower values of n and k");
				}
				int z = (int) Math.pow(LHS, 1.0 / n);
				int diff = (int) (LHS - Math.pow(z, n));
				if ((Math.pow(z + 1, n) - LHS) < diff) {
					diff = (int) (Math.pow(z + 1, n) - LHS);
					z++;
				}
				double relDiff = 100. * diff / LHS;
				if (relDiff < nearMiss) {
					miss = diff;
					nearMiss = relDiff;
					System.out.printf("x = %d, y = %d, z = %d, miss = %d, relative miss = %.6f%%\n", x, y, z, diff, relDiff);
				}
			}
		}
	}
}
