class Solution {
    int[] par = new int[26];
    int[] size = new int[26];
    
    public int findPar(int u) {
        if(par[u] == u)
            return u;
        
        int p = findPar(par[u]);
        
        par[u] = p;
        
        return p;
    }
    
    public void merge(int p1,int p2) {
        if(size[p1] >= size[p2]) {
            par[p2] = p1;
            size[p1] += size[p2];
        } else {
            par[p1] = p2;
            size[p2] += size[p1];
        }
    }
    
    public boolean equationsPossible(String[] equations) {
        
        for(int i=0;i<26;i++) {
            par[i] = i;
            size[i] = 1;
        }
        
        for(String eq : equations) {
            if(eq.charAt(1) == '=') {
                int u = eq.charAt(0) -'a';
                int v = eq.charAt(3) -'a';
                
                int p1 = findPar(u);
                int p2 = findPar(v);
                
                if(p1 != p2) {
                    merge(p1,p2);
                }
            }
        }
        
        for(String eq : equations) {
            if(eq.charAt(1) == '!') {
                int u = eq.charAt(0) -'a';
                int v = eq.charAt(3) - 'a';
                
                int p1 = findPar(u);
                int p2 = findPar(v);
                
                if(p1 == p2) 
                    return false;
                
            }
        }
        
        return true;
    }
   
}