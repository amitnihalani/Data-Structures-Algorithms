package maths_and_logic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = sc.nextInt();
		System.out.println("Prime numbers by normal approach: " + primeGenerator(n));
		System.out.println(slevesPrimes(n));
	}

	private static List<Integer> primeGenerator(int n) {
		List<Integer> primes = new ArrayList<>();
		boolean flag = false;
		for (int i = 2; i <= n; i++) {
//			brute force checker
//			if(isPrimeOptimized(i)) {
//				primes.add(i);
//			}
			
			// optimized checker
			if(isPrimeOptimized(i)) {
				primes.add(i);
			}
		}
		return primes;
	}
	
	// optmized checker
	private static boolean isPrimeOptimized(int n) {
		boolean flag = false;
		
			for (int j = 2; j <= Math.sqrt(n); j++) {
				if(n%j == 0){
					flag = true; 
				}
			}
			if(flag == false) {
				return true;
			}
			return false;
	}
	
	// brute force
	private static boolean isPrime(int n) {
		boolean flag = false;
		
			for (int j = 2; j < Math.sqrt(n); j++) {
				if(n%j == 0){
					flag = true; 
				}
			}
			if(flag == false) {
				return true;
			}
			return false;
	}
	
	private static List<Integer> slevesPrimes(int n) {
		List<Integer> primes = new ArrayList<>();
//		List<Integer> primes = new ArrayList<>();
		boolean[] isPrimeArray = new boolean[n+1];
		for(int i=2; i<n; i++) {
			isPrimeArray[i]  = true;
		}
		isPrimeArray[0] = isPrimeArray[1] = false;
		
		for(int i=2; i<n; i++) {
			if(isPrimeOptimized(i)) {
				for(int j = 2; j*i<n; j++) {
					isPrimeArray[i*j] = false;
				}
				primes.add(i);
			}
		}
		
		return primes;
	}
	
	
}
