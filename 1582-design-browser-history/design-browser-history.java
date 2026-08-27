class BrowserHistory {
    class ListNode{
        String url;
        ListNode prev;
        ListNode next;

        ListNode(String url){
            this.url = url;
        }
    }
    ListNode temp;
    public BrowserHistory(String homepage) {
        temp = new ListNode(homepage);
    }
    
    public void visit(String url) {
        ListNode newNode = new ListNode(url);
        temp.next = newNode;
        newNode.prev = temp;

        // Clearing forward history
        temp = newNode;
    }
    
    public String back(int steps) {
        while(steps>0 && temp.prev!=null){
            temp = temp.prev;
            steps--;
        }
        return temp.url;
    }
    
    public String forward(int steps) {
        while(steps>0 && temp.next!=null){
            temp = temp.next;
            steps--;
        }
        return temp.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */