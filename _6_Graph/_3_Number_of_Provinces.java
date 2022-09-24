package _6_Graph;

/*
    https://practice.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number_of_provinces


 */

import java.util.*;

public class _3_Number_of_Provinces {
    static int numProvincesUsingAdhList(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here

        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<V;i++) {
            adjLs.add(new ArrayList<Integer>());
        }

        // to change adjacency matrix to list
        for(int i = 0;i<V;i++) {
            for(int j = 0;j<V;j++) {
                // self nodes are not considered
                if(adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[V];

        int c = 0;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                c++;
                dfs(i,adjLs,visited);
            }
        }

        return c;
    }


    static void dfs(Integer node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){

        //mark the current node
        visited[node] = true;

        //depth first traversal of neighbors of cur node
        for(Integer neighbour: adj.get(node)){
            if(!visited[neighbour])
                dfs(neighbour,adj,visited);
        }
    }






    //using adjacency matrix
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];

        int c = 0;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                c++;
                dfs(i,adj,visited);
            }
        }

        return c;
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        // Set current node as visited
        visited[node] = true;

        // For every node of the graph
        for (int i = 0; i < adj.get(node).size(); i++) {
            if (adj.get(node).get(i) == 1 && (!visited[i])) {
                dfs(i, adj, visited);
            }
        }
    }
}
