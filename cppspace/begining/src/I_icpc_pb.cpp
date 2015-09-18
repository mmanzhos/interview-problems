// A problem from ACM ICPC round
// http://vntu.edu.ua/images/2015/auspc/problem.pdf

#include <iostream>
#include <cstdio>
#include <stdio.h>
#include <string.h>
#include <vector>
#include <algorithm>
#include <memory.h>
#include <set>
#include <queue>
#include <map>
#include <cmath>

#include <stdint.h>

using namespace std;
typedef long long ll;
const int N = 100005;
int a, b;
int ost = 1;

int pb() {
	cin >> a >> b;

	// iterate from 1 to 10^5 == 100_000
	for (int i = 0; i < 1e5; ++i) {

		// find floating part: (i=1) 0.30103 - 0 = 0.30103, (i=5) 1.50515 - 1 = 0.50515
		double cur = i * log10(2.) - (long long) (i * log10(2.));

		int an = -1;

		/* There is an interesting property:
		 * For every result of power of 2 which starts with 1:
		 *  *cur* = 4 * 0.301 - floor( 4 * 0.301 ) = 0.204; 	2^4 = 16
		 * 	*cur* = 7 * 0.301 - floor( 7 * 0.301 ) = 0.107; 	2^7 = 128
		 *
		 * In general:
		 * log10(a-1) <= cur < log10(a+1)
		 * So if we have found any possible a, that log10(a+1) > cur
		 * That is the case.
		 *
		 * I guess it couldn't be achieved in logical way, only deep knowledge
		 * of hidden math and properties may lead to this solution.
		 * However, for those who wasn't prepared that deep, the task is close to be impossible.
		 */
		for (double j = 1; j <= 9; j++) {
			cout << log10(j + 1) << " vs " << cur  << endl;
			if (log10(j + 1) > cur) {
				an = j;
				break;
			}
		}

		// well, simple check
		if (an == a && b == ost) {
			cout << i << endl;
			return 0;
		}

		// iteration of possible b, which doesn't vary
		// 1, 2, 4, 8, 1, 2, 4, 8, and so on
		ost = (ost * 2) % 10;
	}
	cout << -1 << endl;
	return 0;
}





// my solution

uint64_t reverseInt(uint64_t n) {
	uint64_t reversed = 0ull;
	while (n > 0) {
		reversed = reversed * 10 + (n % 10);
		n = n / 10;
	}
	return reversed;
}

int my() {

	int a;
	int b;

	std::cin >> a;
	std::cin >> b;

	if ((b % 2 != 0 || b == 0) && b != 1) {
		std::cout << -1 << std::endl;
		return 0;
	}

	//std::cout << sizeof(uint64_t)*8 << std::endl;

	for (int i = 0; i < 64; i++) {
		uint64_t x = 1ull << i;

		//std::cout << "i = " << i << std::endl;
		//std::cout << "x = " << x << std::endl;
		if ((int) (x % 10) == b && (int) (reverseInt(x) % 10) == a) {
			std::cout << i << std::endl;
			return 0;
		}
	}

	std::cout << -1 << std::endl;

	return 0;
}

int main() {
	//my();
	pb();
	return 0;
}
