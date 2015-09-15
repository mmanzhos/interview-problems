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
using namespace std;

// A C / C++ program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph

// Number of vertices in the graph
#define V 7

// A utility function to find the vertex with minimum distance value, from
// the set of vertices not yet included in shortest path tree
int minDistance(int dist[], bool sptSet[]) {
	// Initialize min value
	int min = INT_MAX, min_index;

	for (int v = 0; v < V; v++)
		if (sptSet[v] == false && dist[v] <= min)
			min = dist[v], min_index = v;

	return min_index;
}

// A utility function to print the constructed distance array
void printSolution(int dist[], int n) {
	printf("Vertex Distance from Source\n");
	for (int i = 0; i < V; i++)
		printf("%d \t %c \t %d\n", i, 'A'+i, dist[i]);
}

// Funtion that implements Dijkstra's single source shortest path algorithm
// for a graph represented using adjacency matrix representation
void dijkstra(int graph[V][V], int src) {
	int dist[V];	 // The output array. dist[i] will hold the shortest
					 // distance from src to i

	bool sptSet[V]; // sptSet[i] will true if vertex i is included in shortest
					// path tree or shortest distance from src to i is finalized

	// Initialize all distances as INFINITE and stpSet[] as false
	for (int i = 0; i < V; i++)
		dist[i] = INT_MAX, sptSet[i] = false;

	// Distance of source vertex from itself is always 0
	dist[src] = 0;

	// Find shortest path for all vertices
	for (int count = 0; count < V - 1; count++) {
		// Pick the minimum distance vertex from the set of vertices not
		// yet processed. u is always equal to src in first iteration.
		int u = minDistance(dist, sptSet);

		// Mark the picked vertex as processed
		sptSet[u] = true;

		// Update dist value of the adjacent vertices of the picked vertex.
		for (int v = 0; v < V; v++)

			// Update dist[v] only if is not in sptSet, there is an edge from
			// u to v, and total weight of path from src to v through u is
			// smaller than current value of dist[v]
			if (!sptSet[v] && // is not processed
				graph[u][v] > 0 && // edge is set
				dist[u] + graph[u][v] < dist[v]) // previous path + next edge < possible path
					dist[v] = dist[u] + graph[u][v];
	}

	// print the constructed distance array
	printSolution(dist, V);
}

// driver program to test above function
int main2() {
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

	dijkstra(graph, 0);

	return 0;
}
