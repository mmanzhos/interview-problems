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
int gcd(int a, int b){
    return b ? gcd(b, a % b) : a;
}
int n, m;
int main(){
    cin >> n >> m;
    cout << gcd(n, m) << endl;
    return 0;
}
