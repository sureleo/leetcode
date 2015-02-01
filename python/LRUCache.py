class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
    
    def removeNode(self, node):
        if self.head == self.tail:
            self.head = None
            self.tail = None
            return
        if self.head == node:
            self.head = node.next
            node.next.prev = None
            return
        if self.tail == node:
            self.tail = node.prev
            node.prev.next = None
            return
        node.prev.next = node.next
        node.next.prev = node.prev
        
    def addFirst(self, node):
        if not self.head:
            node.prev = None
            node.next = None
            self.head = node
            self.tail = node
            return
        
        node.head = None
        self.head.prev = node
        node.next = self.head
        self.head = node


class LRUCache:

    # @param capacity, an integer
    def __init__(self, capacity):
        self.D = {}
        self.cache = DoublyLinkedList()
        self.size = 0
        self.capacity = capacity

    # @return an integer
    def get(self, key):
        if key in self.D:
            self.cache.removeNode(self.D[key])
            self.cache.addFirst(self.D[key])
            return self.D[key].value
        else:
            return -1

    # @param key, an integer
    # @param value, an integer
    # @return nothing
    def set(self, key, value):
        if key in self.D:
            self.D[key].value = value
            self.cache.removeNode(self.D[key])
            self.cache.addFirst(self.D[key])
        else:
            if self.size < self.capacity:
                self.size += 1
            else:
                del self.D[self.cache.tail.key]
                self.cache.removeNode(self.cache.tail)
            node = Node(key, value)
            self.D[key] = node
            self.cache.addFirst(node)
