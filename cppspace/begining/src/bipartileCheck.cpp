// http://www.geeksforgeeks.org/bipartite-graph/

#include <queue>
#include <iostream>

#define V 4

using namespace std;


bool isBipartile(int graph[V][V], int src) {

	int color[V];
	std::fill_n(color, V, -1);

	queue<int> q;
	q.push(src);

	color[src] = 1;


	while (!q.empty()) {
		int top = q.front();
		q.pop();

		for (int i = 0; i < V; i++) {
			if (graph[top][i] && color[i] == -1) {
				color[i] = 1 - color[top];
				q.push(i);
			} else if (graph[top][i] && color[i] == color[top]) {
				return false;
			}
		}


	}


	return true;
}


int main() {

	int graph[V][V] = {
			{0, 1, 1, 1},
			{1, 0, 1, 0},
			{1, 1, 0, 1},
			{1, 0, 1, 0}
	};

	/**
	 *
	 * Not bipartite
	 *
	 * {0, 1, 1, 1},
	 * {1, 0, 1, 0},
	 * {1, 1, 0, 1},
	 * {1, 0, 1, 0}
	 *
	 * A - B
	 * |\ /
	 * |/ \
	 * C - D
	 *
	 *
	 * Bipartite
	 *
	 * {0, 1, 0, 1},
	 * {1, 0, 1, 0},
	 * {0, 1, 0, 1},
	 * {1, 0, 1, 0}
	 *
	 * A - B
	 *  \ /
	 *  / \
	 * C - D
	 *
	 *
	 *
	 */


	cout << isBipartile(graph, 0) << endl;

}
