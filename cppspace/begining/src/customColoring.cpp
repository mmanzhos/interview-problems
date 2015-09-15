#include <iostream>
#include <string.h>

using namespace std;

#define V 5

void greedyColoring(int graph[V][V] ) {
	int processingV = 0;

	int result[V];
	std::fill_n(result, V, -1);
	bool occupied[V];

	result[processingV] = 0;


	/**
	 * Time complexity:
	 * visit each vertex
	 * and visit each vertex
	 */

	for (int vertex = 0; vertex < V; vertex++) {

		for (int j = 0; j < V; j++) {
			if (graph[processingV][j] && result[j] != -1) {
				occupied[result[j]] = true;
			}
		}

		int color;
		for (color = 0; color < V; color++) {
			if (occupied[color] == false)
				break;
		}

		result[processingV] = color;

		for (int j = 0; j < V; j++) {
			if (graph[processingV][j] && result[j] != -1) {
				occupied[result[j]] = false;
			}
		}

		processingV++;
	}

	for (int i = 0; i < V; i++) {
		cout << "Vertex " << i << " --> " << result[i] << endl;
	}


}


int main() {
	/*int graph[V][V] = {
			{0, 1, 1, 0, 0},
			{1, 0, 1, 1, 0},
			{1, 1, 0, 1, 0},
			{0, 1, 1, 0, 1},
			{0, 0, 0, 1, 0}
	};
	greedyColoring(graph);*/


	int graph[V][V] = {
				{0, 1, 1, 0, 0},
				{1, 0, 1, 0, 1},
				{1, 1, 0, 0, 1},
				{0, 0, 0, 0, 1},
				{0, 1, 1, 1, 0}
		};

		greedyColoring(graph);

}
