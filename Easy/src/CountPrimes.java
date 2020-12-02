/**
 * <p>
 *     Count the number of prime numbers less than a non-negative number, n
 * </p>
 */
public class CountPrimes {

    /**
     * SIEVE OF ERATOSTHENES
     * 1. Assume all numbers are prime from 2 to n
     * 2. Generate and eliminate composite numbers upto n
     * 3. Count remaining primes.
     *      We start with 2
     *            Square
     *      2 |     4   ,6, 8, 10, 12, 16,   upto n
     *      Now we will start with next number which is not marked as false.
     *      3 |     9   ,12, 15, 18, 21,     upto n
     *      As 4 was marked, so next number that was not marked is 5.
     *      5 |    25   ,30, 35, 40, 45,     upto n
     *      .....
     *      We keep checking until square of the number is less than or equal to n.
     *      Why? We are eliminating non primes by checking the square of the given number.
     *
     * @param n input number
     * @return number of primes upto n
     */
    public int countPrimes(int n){
        int count=0;
        boolean[] prime=new boolean[n+1];
        //assuming all numbers are prime
        //though we are starting from 0 here, later when we will count we will start from 2
        //because 0 and 1 are neither prime nor composite.
        for(int i=0;i<n;i++)
            prime[i]=true;

        //Keep checking until square of number is less than n
        for(int i=2;i*i<n;i++){
            //if prime[i] is true, that is number is not ms
            if(prime[i]){
                //mark the square of number and its multiples from there as composite
                for(int j=i*i;j<n;j+=i)
                    prime[j]=false;
            }
        }
        for (int i=2;i<=n;i++){
            if(prime[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(new CountPrimes().countPrimes(n));
    }
}
