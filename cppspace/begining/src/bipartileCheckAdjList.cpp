// OOD from http://www.geeksforgeeks.org/graph-coloring-set-2-greedy-algorithm/
// Algorithm from http://www.geeksforgeeks.org/bipartite-graph/
#include <iostream>
#include <list>
#include <queue>
using namespace std;

// A class that represents an undirected graph
class Graph
{
    int V;    // No. of vertices
    list<int> *adj;    // A dynamic array of adjacency lists
public:
    // Constructor and destructor
    Graph(int V)   { this->V = V; adj = new list<int>[V]; }
    ~Graph()       { delete [] adj; }

    // function to add an edge to graph
    void addEdge(int v, int w);

    bool isBipartite(int src);
};

void Graph::addEdge(int v, int w)
{
    adj[v].push_back(w);
    adj[w].push_back(v);  // Note: the graph is undirected
}


bool Graph::isBipartite(int src)
{
	queue<int> q;
	int color[V];
	fill_n(color, V, -1);

	color[src] = 0;

	q.push(src);

	while (!q.empty()) {
		int top = q.front();
		q.pop();

		list<int>::iterator i;
		for (i = adj[top].begin(); i != adj[top].end(); i++) {
			if (color[*i] == -1) {
				color[*i] = 1 - color[top];
				q.push(*i);
			} else if (color[*i] == color[top]) {
				return false;
			}
		}

	}


	return true;
}


int main() {

	Graph g1(4);
	g1.addEdge(0, 1);
	g1.addEdge(0, 2);
	g1.addEdge(0, 3);
	g1.addEdge(1, 2);
	g1.addEdge(2, 3);

	cout << g1.isBipartite(0) << endl; // false


	Graph g2(4);
	g2.addEdge(0, 1);
	g2.addEdge(0, 3);
	g2.addEdge(1, 2);
	g2.addEdge(2, 3);

	cout << g2.isBipartite(0) << endl; // true




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


}
