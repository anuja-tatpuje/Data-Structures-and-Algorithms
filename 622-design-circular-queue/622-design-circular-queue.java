class MyCircularQueue {
    int[] array;
    int size, headIndex, count;
    public MyCircularQueue(int k) {
        // initializing array
        array = new int[k];
        // initializing size to k
        size = k;
        // head index to 0
        headIndex = 0;
        // count to 0
        count = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        
        int targetIndex = (headIndex + count) % size;
        
        array[targetIndex] = value;
        
        count+=1;
        
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        
        headIndex = (headIndex+1) % size;
        count -= 1;
        
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        
        return array[headIndex];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        
        int targetIndex = (headIndex + (count - 1)) % size;
        
        return array[targetIndex];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */