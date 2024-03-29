// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
            int[] indegree = new int[V];
            
            for(int u=0;u<V;u++) {
                for(int v : adj.get(u)) {
                    indegree[v]++;
                }
            }
        
        LinkedList<Integer> que = new LinkedList<>();    
        ArrayList<Integer> ans = new ArrayList<>();
        
        
        for(int i=0;i<V;i++) {
            if(indegree[i] == 0) {
                que.addLast(i);
                ans.add(i);
            }
        }    
        
        while(que.size()> 0) {
            int size = que.size();
            
            while(size-->0) {
                int top = que.removeFirst();
                
                for(int nbr : adj.get(top)) {
                    indegree[nbr]--;
                    
                    if(indegree[nbr] == 0) {
                        que.addLast(nbr);
                        ans.add(nbr);
                    }
                }
            }
        }
        
        int[] an = new int[V];
        
        for(int i=0;i<ans.size();i++) {
            an[i] = ans.get(i);
        }
            
        return an;    
    }
    static int[] topoSort2(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] vis = new int[V];
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                boolean cycle = dfs(i,adj,vis,al);
                
                if(cycle) {
                    System.out.println("No Solution!!!! ");
                    return new int[]{};
                }
            }
        }
        
        int j=0;
        int[] topo = new int[V];
        
        for(int i= al.size()-1;i>=0;i--) {
            topo[j] = al.get(i);
            j++;
        }
        
        return topo;
    }
    
    static boolean dfs(int src,ArrayList<ArrayList<Integer>> adj,int[] vis,ArrayList<Integer> al) {
        vis[src] = 1;
        
        for(int nbr : adj.get(src)) {
            if(vis[nbr] == 0) {
                boolean ans = dfs(nbr,adj,vis,al);
                if(ans) return true;
            } else if(vis[nbr] == 1) {
                return true;
            }
        }
        
        vis[src] = 2;
        al.add(src);
        
        return false;
    }
}
