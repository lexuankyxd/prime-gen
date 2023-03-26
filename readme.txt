First method: Starts with n = 2, and we add n by 1 every time we check. If n is a prime than we add it to a list that keeps track of every prime we checked. To check whether or not n is a prime we find n%k, k is every number in our list. If every mod return a number that is not 0 than we know it's a prime.
30s timer highest number: 435893
Improvement:
Lets consider number n and k will be a number in our list, if we want to check whether or not that number is prime it will have to find n % k. For every k that is greater than n/2 we know that the calculation is not needed since if k > n/2 than n%k = n - k != 0. Same with n/3 if we already checked k = 2. So if i think we can extend this to sqrt(n) since with every k > sqrt(n), k*k' = n than we know that k' < sqrt(n), than k' is checked and there is no need to check for k. 

Second method: Same as method 1 but only check for numbers that is smaller than the sqrt(n), n is the number that we are checking. To find the smallest number that is bigger than the sqrt(n) we calculate that value, then we find the number we are looking for by binary search through the whole list. 1 problem is that n might be a square number, we need to check for that first by checking if sqrt(n) is an integer. And the list of primes now starts with 2 3 5 7 instead of null. Also instead of increamenting n by 1 we add it by 2.
30s timer highest number: 30402677
Improvements: roughly x8 amount of numbers we got.
