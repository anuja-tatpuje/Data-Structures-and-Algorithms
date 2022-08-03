class MyCalendar {
    class node {
        int start,end;
        node left,right;
        
        public node(int start,int end) {
            this.start = start;
            this.end = end;
        }
    }
    node root;
    public MyCalendar() {
        root = null;
    }
    public boolean insert(node parent,int start,int end) {
        if(parent.start >= end) {
            if(parent.left == null) {
                node leftNode = new node(start,end);
                parent.left = leftNode;
                return true;
            } else {
                return insert(parent.left,start,end);
            }
        } else if(parent.end <= start) {
            if(parent.right == null) {
                node rightNode = new node(start,end);
                parent.right = rightNode;
                return true;
            } else {
                return insert(parent.right,start,end);
            }
        }
        
        return false;
    }
    public boolean book(int start, int end) {
        if(root == null) {
            root = new node(start,end);
            return true;
        } else {
            return insert(root,start,end);
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */