package _6_Graph;

/*
    https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=dfs_of_graph

    Time Complexity:
    For an undirected graph, O(N) + O(2E), For a directed graph, O(N) + O(E),
    Because for every node we are calling the recursive function once,
    the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.

    Space Complexity:
    O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.
 */

import java.util.*;

public class _2_DFS_Traversal {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfs(0,adj, visited, ans);

        return ans;
    }

    //if given adjacency list
    void dfs(Integer node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans){

        //mark the current node
        visited[node] = true;
        ans.add(node);

        //depth first traversal of neighbors of cur node
        for(Integer neighbour: adj.get(node)){
            if(!visited[neighbour])
                dfs(neighbour,adj,visited,ans);
        }
    }



    //if given adjacency matrix
    void dfs(int node, int[][] adj, boolean[] visited, ArrayList<Integer> ans)
    {
        // Set current node as visited
        visited[node] = true;
        ans.add(node);

        // For every node of the graph
        for (int i = 0; i < adj[node].length; i++) {

            // If some node is adjacent to the current node
            // and it has not already been visited
            if (adj[node][i] == 1 && (!visited[i])) {
                dfs(i, adj, visited, ans);
            }
        }
    }
}
