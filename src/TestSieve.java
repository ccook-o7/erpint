import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSieve {
	Sieve a;
	
	@Test
	public void DefaultConstructor() {
		a = new Sieve();
		assertTrue(a.GetPrimeNumbers().equals(new ArrayList<Integer>()));
	}
	
	@Test
	public void MaxNegative() {
		a = new Sieve(-1);
		assertTrue(a.GetPrimeNumbers().equals(new ArrayList<Integer>()));
	}
	
	@Test
	public void MaxZero() {
		a = new Sieve(0);
		assertTrue(a.GetPrimeNumbers().equals(new ArrayList<Integer>()));
	}
	
	@Test
	public void MaxTwo() {
		a = new Sieve(2);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(2);
		assertTrue(a.GetPrimeNumbers().equals(b));
	}
	
	@Test
	public void MaxTen() {
		a = new Sieve(10);
		ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7));
		assertTrue(a.GetPrimeNumbers().equals(b));
	}
	
	@Test
	public void FirstTwentyPrimeNumbers() {
		a = new Sieve(100);
		ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
		assertTrue(a.GetPrimeNumbers().equals(b));
	}
	
	@Test
	public void BigPrime() {
		a = new Sieve(1000000000);
		ArrayList<Integer> primes = a.GetPrimeNumbers();
		assertTrue(primes.get(primes.size() - 1) == 999999937); //from google
	}
}
