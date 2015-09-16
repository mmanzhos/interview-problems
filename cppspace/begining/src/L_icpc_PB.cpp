#include <cstdio>
#include <set>
#include <vector>
#include <cstring>
#include <list>
#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;
typedef long long ll;
const int N = 1000000;
int lp[N + 1];
vector<int> pr;
vector<int> luck;

int pbVersion(){

    for(int i = 2; i <= N; ++i){
        if(lp[i] == 0){
            lp[i] = i;
            //cout << "Set lp[i] " << lp[i] << " to a value of " << i << endl;
            pr.push_back(i);
        }
        for(int j = 0; j < (int)pr.size() && pr[j] * i <= N && lp[i] >= pr[j]; ++j){
            lp[i * pr[j]] = pr[j];
            //cout << "Set lp[i*pr[j]] " << i * pr[j] << " to a value of " << pr[j] << endl;
        }
    }

    for(int i = 2; i <= N; ++i){
        int fi = i;
        if(lp[fi] == fi){
            int se = 0;
            while(fi > 0){
                se = se * 10 + fi % 10;
                fi /= 10;
            }
            if(i != se && se <= N && lp[se] == se){
                luck.push_back(i);
            }
        }
    }
    int k;
    cin >> k;
    if(luck.size() >= k){
        cout << luck[k - 1] << endl;
    }
    else{
        cout << -1 << endl;
    }
    return 0;
}



bool isPrime(long int n) {
	if (n <= 12) return false;

	if (n%2==0) return false;


	for (int i = 3; i * i <= n; i += 2) {
		if (n % i == 0)
			return false;
	}

	/*for (int i = 2; i < n; i++) {
		if (n % i == 0 && i != n) {
			return false;
		}
	}*/
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


int myVersion() {

	long int k = 0;
	std::cin >> k;


	//long int * A = new long int[k/2];

	long int counter = 0;

	long int initial = 13;

	while (counter != k) {
		long int reverse = reverseInt(initial);
		if (initial != reverse  && isPrime(initial) && isPrime(reverse)) {
			//A[counter] = initial;
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


int main() {
	myVersion();
	pbVersion();
	return 0;
}
