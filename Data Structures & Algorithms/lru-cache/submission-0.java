// in order to be able to use O(1) for get and put
// we need to use a hashmap
// but the hashmap needs to have node pointers (aka a DLL)
// since you need the node before and after the node to put them in order
class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

class LRUCache {
    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node left; // least recently used
    private Node right; // most recently used

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(); // map key to node
        this.left = new Node(0,0); // left = LRU
        this.right = new Node(0,0); // right = MRU
        // left and right need to be connected bc if we put a new node we want to put it in the middle
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    // REMOVE NODE FROM THE LEFT (LRU)
    private void remove(Node node) { // pass in a NODE because the remove is applying to the linked list
        Node prev = node.prev;
        Node next = node.next;
        // detach the node inbetween by connecting the prev and the next to each other
        prev.next = next;
        next.prev = prev;
    }

    // INSERT NODE TO LIST (MRU)
    private void insert(Node node) {
        Node prev = this.right.prev; // grab the node before right (MRU)
        prev.next = node; // set the next MRU to the new MRU, node
        node.prev = prev; // set the prev of the MRU to the old MRU
        node.next = right; // set the next of the new node to right
        this.right.prev = node; // set the prev of the right to the right node (DLL requires back pointer)
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            // GETTING will make it the MRU
            // We need to remove it
            // Then we need to insert it again
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return cache.get(key).value;
        }

        return -1;
        // if (node == null) return -1;
        // Node next = head;
        // head = node;
        // node.next = head;
        // return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // remove the node
            Node node = cache.get(key);
            remove(node);
        }
        // create node
        Node newNode = new Node(key, value);
        cache.put(key, newNode); // add the node to the hashmap
        // insert node with new values to the list to make sure the pointers
        insert(newNode);

        // if cache is at capacity, remove LRU and add new key / node
        // otherwise just add the key value pair to the cache at the MRU (right)
        if (cache.size() > capacity) {
            Node LRU = this.left.next; // get the node so you can remove it
            // LRU node will be to the left of the dummy node
            remove(LRU); // remove connections in the list
            cache.remove(LRU.key); // remove from the map
        }
    }
}
