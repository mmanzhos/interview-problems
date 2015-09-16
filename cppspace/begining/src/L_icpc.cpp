#include <iostream>

bool isPrime(long int n) {
	if (n <= 12) return false;
	//std::cout << n << " counting prime" << std::endl;
	for (int i = 2; i < n; i++) {
		if (n % i == 0 && i != n) {
			return false;
		}
	}
	//std::cout << n << " prime!" << std::endl;
	return true;
}

long int reverseInt(long int n) {
	long int reversed = 0;
	while (n > 0) {
		reversed = reversed * 10 + (n % 10);
		//std::cout << "reversed = " << reversed << std::endl;
		n = n / 10;
		//std::cout << "n = " << n << std::endl;
	}
	return reversed;
}


int main() {

	long int k = 0;
	std::cin >> k;


	long int * A = new long int[k/2];

	long int counter = 0;

	long int initial = 13;

	while (counter != k) {
		if (isPrime(initial) && isPrime(reverseInt(initial))) {
			A[counter] = initial;
			counter++;
		}
		initial++;
		if (initial >= 1000000) {
			std::cout << -1 << std::endl;
			return 0;
		}
	}

	std::cout << (initial-1) << std::endl;


	return 0;
}
