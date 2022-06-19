class Solution {
    List<List<String>> res = new ArrayList();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        for(int i=0;i<searchWord.length();i++) {
            String prefix = searchWord.substring(0,i+1);
            List<String> ans = new ArrayList<>();
            int index = binarySearch(prefix,products);
            for(int j=index;j<products.length && ans.size()<3 ;j+=1) {
                if(isPrefix(products[j],prefix)) {
                    ans.add(products[j]);
                    continue;
                }
                break;
            }
            
            res.add(ans);
        }
        
        return res;
       
    }
    public int binarySearch(String prefix,String[] products) {
        int left = 0, right = products.length-1,mid = 0;
        while(left<=right) {
            mid = left + (right-left)/2;
            
            if(products[mid].compareTo(prefix) >=0) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
          return right+1; 
    
    }
     private boolean isPrefix(String s, String prefix) {
        return s.startsWith(prefix);
    }
}