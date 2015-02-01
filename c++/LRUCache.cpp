//
//  LRUCache.cpp
//  c++
//
//  Created by sure on 2/1/15.
//  Copyright (c) 2015 Shuo Li. All rights reserved.
//

#include <stdio.h>
#include <unordered_map>

class Node {
public:
    Node *prev;
    Node *next;
    int val;
    int key;
    Node (int key, int val) {
        this->key = key;
        this->val = val;
        this->prev = NULL;
        this->next = NULL;
    }
};

class DoublyLinkedList {
public:
    DoublyLinkedList () {
        this->head = NULL;
        this->tail = NULL;
    }
    
    Node* head;
    Node* tail;
    
    void addFirst(Node* node) {
        if (!head) {
            node->prev = NULL;
            node->next = NULL;
            this->head = node;
            this->tail = node;
            return;
        }
        node->prev = NULL;
        this->head->prev = node;
        node->next =this->head;
        this->head = node;
    }
    
    void removeElement(Node* node) {
        if (this->head == this->tail) {
            this->head = NULL;
            this->tail = NULL;
            return;
        }
        if (this->head == node) {
            this->head = node->next;
            node->next->prev = NULL;
            return;
        }
        if (this->tail == node) {
            this->tail = node->prev;
            node->prev->next = NULL;
            return;
        }
        node->prev->next = node->next;
        node->next->prev = node->prev;
    }
};


class LRUCache{
public:
    int capacity;
    int size;
    std::unordered_map<int, Node*> dictionary;
    DoublyLinkedList *cache;
    
public:
    LRUCache(int capacity) {
        this->capacity = capacity;
        this->cache = new DoublyLinkedList();
        this->size = 0;
    }
    
    int get(int key) {
        if (dictionary.find(key) == dictionary.end()){
            return -1;
        } else {
            this->cache->removeElement(dictionary[key]);
            this->cache->addFirst(dictionary[key]);
            return dictionary[key]->val;
        }
    }
    
    void set(int key, int value) {
        if (dictionary.find(key) != dictionary.end()) {
            dictionary[key]->val = value;
            this->cache->removeElement(dictionary[key]);
            this->cache->addFirst(dictionary[key]);
        } else {
            if (this->size < this->capacity) {
                this->size ++;
            } else {
                this->dictionary.erase(dictionary.find(this->cache->tail->key));
                this->cache->removeElement(this->cache->tail);
            }
            Node *node = new Node(key, value);
            this->dictionary[key] = node;
            this->cache->addFirst(dictionary[key]);
        }
    }
};
