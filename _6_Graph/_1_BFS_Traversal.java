package _6_Graph;

/*
    https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bfs_of_graph

    Time Complexity:
    O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.

    Space Complexity:
    O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list
 */

import java.util.*;

public class _1_BFS_Traversal {
    public ArrayList<Integer> bfsOfGraphUsingAdgList(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        visited[0] = true;
        q.add(0);
        while(!q.isEmpty()){
            Integer node = q.remove();
            ans.add(node);

            for(Integer neighbour: adj.get(node)){  //take the neighbors of node and if they are not visited, just visit
                if(!visited[neighbour]){
                    visited[neighbour] = true;    //whenever you add to the node to q, just mark as visited
                    q.add(neighbour);
                }
            }
        }

        return ans;
    }







    public ArrayList<Integer> bfsOfGraphUsingAdgMat(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        visited[0] = true;
        q.add(0);
        while(!q.isEmpty()){
            Integer node = q.remove();
            ans.add(node);

            for(Integer i = 0; i<adj.get(node).size(); i++){  //take the neighbors of node and if they are not visited, just visit
                if(adj.get(node).get(i) == 1 && !visited[i]){
                    visited[i] = true;    //whenever you add to the node to q, just mark as visited
                    q.add(i);
                }
            }
        }

        return ans;
    }
}
