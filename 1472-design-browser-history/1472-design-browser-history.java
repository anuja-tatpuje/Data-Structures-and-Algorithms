class BrowserHistory {
    ArrayList<String> history = new ArrayList<>();
    int index = 0;
    public BrowserHistory(String homepage) {
        history.add(homepage);
    }
    
    public void visit(String url) {
        history.subList(index+1,history.size()).clear();
        history.add(url);
        index++;
    }
    
    public String back(int steps) {
        index = Math.max(index-steps,0);
        return history.get(index);
    }
    
    public String forward(int steps) {
        index = Math.min(index + steps, history.size() - 1);
        return history.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */