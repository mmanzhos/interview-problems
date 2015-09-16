// refers to http://www.geeksforgeeks.org/detect-cycle-in-a-graph/

// A C++ Program to detect cycle in a graph
#include<iostream>
#include <list>
#include <string.h>

using namespace std;

class Graph
{
    int V;    // No. of vertices
    list<int> *adj;    // Pointer to an array containing adjacency lists
    bool isCyclicUtil(int v, bool visited[], bool *rs);  // used by isCyclic()
public:
    int countCycles;
    Graph(int V);   // Constructor
    void addEdge(int v, int w);   // to add an edge to graph
    bool isCyclic();    // returns true if there is a cycle in this graph
};

Graph::Graph(int V)
{
    this->V = V;
    countCycles = 0;
    adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
    adj[v].push_back(w); // Add w to v’s list.
}

// This function is a variation of DFSUytil() in http://www.geeksforgeeks.org/archives/18212
bool Graph::isCyclicUtil(int v, bool visited[], bool *recStack)
{
	if (visited[v] == false) {
		visited[v] = true;
		recStack[v] = true;

		list<int>::iterator i;
		for (i = adj[v].begin(); i != adj[v].end(); ++i) {
			if (visited[*i] == false && isCyclicUtil(*i, visited, recStack)) {
				//countCycles++;
				return true;
			} else if (recStack[*i]) {
				//countCycles++;
				return true;
			}
		}
	}
	recStack[v] = false;
	return false;
}

// Returns true if the graph contains a cycle, else false.
// This function is a variation of DFS() in http://www.geeksforgeeks.org/archives/18212
bool Graph::isCyclic()
{
	bool visited[V];
	bool recStack[V];
	memset(visited, 0, sizeof(bool));
	memset(recStack, 0, sizeof(bool));

	for (int i = 0; i < V; i++) {
		if(isCyclicUtil(i, visited, recStack)) {
			//countCycles++;
			return true;
		}
	}

	return false;
}

int main()
{
    // Create a graph given in the above diagram
    Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    //g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    if(g.isCyclic())
        cout << "Graph contains " << g.countCycles << " cycles";
    else
        cout << "Graph doesn't contain cycle";
    return 0;
}
