class Solution {
    List<String> para = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generatePara(0,0,n,"");
        return para;
    }
    public void generatePara(int open,int close,int max,String par) {
        if(par.length() ==  max * 2) {
            para.add(par);
            return;
        }
        if(open<max) {
            generatePara(open+1,close,max,par+"(");
        }
        if(close < open) {
            //generating closed paranthesis lesser than open brackets
            generatePara(open,close+1,max,par+")");
        }
    }
}