import java.util.ArrayList;

/**
 * Implementation of another prime search, 
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * 
 * The implementation is about as naive as it gets, the accompanying "BigPrime"
 * test takes a whopping 42 seconds on my pc while still being under half of the
 * integer maximum value.
 * 
 * Additional concerns:
 *  - Naive includes a complete lack of memory management. A quick estimate puts 
 *    the boolean array at up to ~268MB at int max. 
 *  - The design of this class treats the sieve as an object in itself, but use
 *    cases would likely dictate a different design. Eg. FindPrimes as a function
 *  - Undocumented despite Javadocs actually being nice. 
 *  - Test cases are simplistic and would benefit from some supplementary text.
 *  - If performance requirements are provided a test timeout in a fixed
 *    environment would be really nice. 
 */
public class Sieve {
	private int maximum;
	private ArrayList<Integer> primeNumbers;
	private boolean[] boolset;
	
	public Sieve() { 
		primeNumbers = new ArrayList<Integer>();
		boolset = new boolean[0];
	}
	
	public Sieve(int maximum)
	{	
		if (maximum < 0) maximum = 0; //Avoid the negative input edge case
		this.maximum = maximum;
		primeNumbers = new ArrayList<Integer>();
		boolset = new boolean[maximum];
	}
	
	public void CalculatePrimeNumbers() {
		//for each number in the set
		for (int i = 2; i < boolset.length; i++) {
			
			//if unmarked, it's a prime
			if (boolset[i] == false) {
				int prime = i;
				primeNumbers.add(prime);
				
				//search the set for multiples of the current prime
				for (int j = prime; j < maximum; j += prime) 
					boolset[j] = true; //flag as non prime
			}
		}
	}
	
	public ArrayList<Integer> GetPrimeNumbers() {
		//Edge cases
		if (maximum < 2) return primeNumbers;
		if (maximum == 2) {
			primeNumbers.add(2);
			return primeNumbers;
		}
		//Normal runtime
		else {
			CalculatePrimeNumbers();
			return primeNumbers;
		}	
	}
}
