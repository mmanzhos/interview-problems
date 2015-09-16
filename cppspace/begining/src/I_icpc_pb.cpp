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
	for (int i = 0; i < 1e5; ++i) {
		double cur = i * log10(2.) - (long long) (i * log10(2.));
		int an = -1;
		for (double j = 2; j <= 10; j++) {
			if (log10(j) > cur) {
				an = j - 1;
				break;
			}
		}
		if (an == a && b == ost) {
			cout << i << endl;
			return 0;
		}
		ost = (ost * 2) % 10;
	}
	cout << -1 << endl;
	return 0;
}

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
		std::cout << "x = " << x << std::endl;
		if ((int) (x % 10) == b && (int) (reverseInt(x) % 10) == a) {
			std::cout << i << std::endl;
			return 0;
		}
	}

	std::cout << -1 << std::endl;

	return 0;
}

int main() {
	my();
	pb();
	return 0;
}
