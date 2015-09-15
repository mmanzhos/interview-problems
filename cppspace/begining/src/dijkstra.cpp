//============================================================================
// Name        : begining.cpp
// Author      : manzhos
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include "pch.h"
#include <stdio.h>
#include <limits.h>
#include <queue>
using namespace std;

#define V 7

typedef pair<int,int> ii;
struct pri {
    int operator() (const pair<int,int> &p1, const pair<int,int >&p2)
    {
        return p1.second > p2.second;
    }
}p;


int prevMinDistanceIndex(int dist[], bool stpSet[]) {
	int min = INT_MAX;
	int index;
	for (int i = 0; i < V; i++)
		if (!stpSet[i] && dist[i] < min)
			min = dist[i], index = i;
	return index;
}

bool isNeighbor(int graph[V][V], int v1, int v2) {
	return graph[v1][v2] > 0;
}

void dijkstra2(int graph[V][V], int source) {

	int dist[V];
	bool stpSet[V];

	for (int i = 0; i < V; i++) {
		dist[i] = INT_MAX;
		stpSet[i] = false;
	}

	/*dist[0] = 0;
	for (int verticesExceptOne = 0; verticesExceptOne < V - 1; verticesExceptOne++) {
		int currentVertex = prevMinDistanceIndex(dist, stpSet);
		stpSet[currentVertex] = true;
		for (int neighbor = 0; neighbor < V; neighbor++) {
			if (!stpSet[neighbor] && isNeighbor(graph, currentVertex, neighbor) &&
				dist[currentVertex] + graph[currentVertex][neighbor] < dist[neighbor]) {
				dist[neighbor] = dist[currentVertex] + graph[currentVertex][neighbor];
			}
		}
	}*/


	priority_queue<ii, vector<ii>, pri> Q;
	Q.push(ii(source,0));
	dist[source] = 0;

	while(!Q.empty()) {

		// fetch the nearest element
		ii top = Q.top();
		Q.pop();

		int currentDistance = top.second;
		int currentVertex = top.first;
		stpSet[currentVertex] = true;


		for (int possibleNeighbor = 0; possibleNeighbor < V; possibleNeighbor++) {
			if (stpSet[possibleNeighbor] == false && graph[currentVertex][possibleNeighbor] > 0 &&
					currentDistance + graph[currentVertex][possibleNeighbor] < dist[possibleNeighbor]) {
				dist[possibleNeighbor] = currentDistance + graph[currentVertex][possibleNeighbor];
				Q.push(ii(possibleNeighbor, dist[possibleNeighbor]));
			}
		}
	}


	// output solution
	for (int i = 0; i < V; i++) {
		cout << (char)('A'+i) << "\t" << dist[i] << endl;
	}

}



// driver program to test above function
int main() {
	/* Let us create the example graph discussed above */

	int graph[V][V] = {
						{ 0, 4, 3, 0, 7, 0, 0 },
						{ 4, 0, 6, 5, 0, 0, 0 },
						{ 3, 6, 0, 11, 8, 0, 0 },
						{ 0, 5, 11, 0, 2, 2, 10 },
						{ 7, 0, 8, 2, 0, 0, 5 },
						{ 0, 0, 0, 2, 0, 0, 3 },
						{ 0, 0, 0, 10, 5, 3, 0 }
					};

	dijkstra2(graph, 0);

	return 0;
}
