package _6_Graph;

/*
    https://practice.geeksforgeeks.org/problems/bipartite-graph/1

    Time Complexity: O(V + 2E), Where V = Vertices, 2E is for total degrees as we traverse all adjacent nodes.
    Space Complexity: O(3V) ~ O(V), Space for queue data structure, colour array and an adjacency list.
 */

import java.util.*;

public class _9_Bipartite_Graph {
    public boolean isBipartiteBFS(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];

        for(int i = 0;i<V;i++)
            color[i] = -1;

        for(int i = 0;i<V;i++) {
            if(color[i] == -1) {
                if(check(i, V, adj, color) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    //checking using BFS
    private boolean check(int index, int V, ArrayList<ArrayList<Integer>>adj, int color[]) {

        Queue<Integer> q = new LinkedList<Integer>();

        q.add(index);
        color[index] = 0;

        while(!q.isEmpty()) {

            int node = q.remove();

            for(int neighbour : adj.get(node)) {
                if(color[neighbour] == -1) {
                    // if the adjacent node is yet not colored, you will give the opposite color of the node
                    color[neighbour] = 1 - color[node];
                    q.add(neighbour);
                }else if(color[neighbour] == color[node]) { // is the adjacent guy having the same color
                    return false;                           // someone did color it on some other path
                }
            }

        }

        return true;
    }

    //checking using dfs
    public boolean isBipartiteDFS(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];

        for(int i = 0;i<V;i++)
            color[i] = -1;

        // for connected components
        for(int i = 0;i<V;i++) {
            if(color[i] == -1) {
                if(dfs(i, 0, color, adj) == false)
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>>adj) {

        color[node] = col;

        for(int neighbour : adj.get(node)) {
            if(color[neighbour] == -1) {
                if(dfs(neighbour, 1 - col, color, adj) == false)
                    return false;
            }else if(color[neighbour] == col) {
                return false;
            }
        }

        return true;
    }
}
