package _6_Graph;

/*
    https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph
 */

import java.util.*;

public class _7_Detecting_Cycle_In_Graph {
    /*
        while doing BFS, if u encountered a node as already visited(other than the node which it came from i.e, it's parent) ,
        then cycle is present
        While doing BFS, there's no way you will had visited the further node,
        unless it was visited by other node(i.e, presence of cycle)
     */
    public boolean isCycleUsingBFS(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++){  //loop because there can be connected components
            if(!visited[i]){
                if(bfs(i, adj, visited) == true)
                    return true;
            }
        }

        return false;
    }

    boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited){

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{src, -1});
        visited[src] = true;

        while(!q.isEmpty()){
            int[] pair = q.remove();
            int node = pair[0];
            int parent = pair[1];

            for(Integer neighbour: adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(new int[]{neighbour, node});
                }else{
                    if(neighbour != parent)
                        return true;
                }
            }
        }

        return false;
    }




    /*
        while doing DFS, if u encountered a node as already visited(other than the node which it came from i.e, it's parent) ,
        then cycle is present
        While doing DFS, there's no way you will had visited the further node,
        unless it was visited by other node(i.e, presence of cycle)
     */

    public boolean isCycleUsingDFS(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++){  //loop because there can be connected components
            if(!visited[i]){
                if(dfs(i, -1, adj, visited) == true)
                    return true;
            }
        }

        return false;
    }

    boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited){

        visited[node] = true;

        for(Integer neighbour: adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour, node, adj, visited) == true)
                    return true;
            }else{
                if(neighbour != parent)
                    return true;
            }
        }

        return false;
    }
}
