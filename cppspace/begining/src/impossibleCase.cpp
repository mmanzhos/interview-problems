#include <iostream>
#include <vector>
#include <string>
#include <math.h>
#include <sstream>

using namespace std;


string removeRepeated(string s) {
	int N = s.size();
	vector<int> next(N);
	int lastPos[26];
	for (int i = 0; i < 26; i++)
		lastPos[i] = -1;

	for (int i = N - 1; i >= 0; i--) {
		int ind = s[i] - 'a';
		next[i] = lastPos[ind];
		lastPos[ind] = i;
	}

	vector<bool> visited(26, false);
	string ans;
	for (int i = 0; i < N; i++) {
		int cur = s[i] - 'a';

		if (visited[cur])
			continue;
		if (next[i] == -1) {
			ans += s[i];
			visited[cur] = true;
		} else {

			int j = i + 1;
			char smaller = s[i];
			while (j < N) {
				if (visited[s[j] - 'a'] == false) {
					smaller = min(smaller, s[j]);
					if (next[j] == -1)
						break;
				}
				j++;
			}

			if (s[i] <= smaller) {
				ans += s[i];
				visited[cur] = true;
			}
		}
	}

	return ans;
}


int main() {
	string str;
	cout << "Let's go" << endl;
	getline(cin, str);
	removeRepeated(str);
	//cout << strN;
	return 0;
}

