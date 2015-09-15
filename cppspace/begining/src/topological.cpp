#include <iostream>
#include <string.h>
#include <hash_set>

using namespace std;


#define V 5

void topologicalSortUtil() {

}

void topologicalSort(int graph[V][V] ) {
	hash_set<int> set;



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
