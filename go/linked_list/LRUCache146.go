package main

import (
	"container/list"
	"fmt"
)

type LRUCache struct {
	capacity int
	dlist    *list.List
	cache    map[int]*list.Element
}

type Entry struct {
	key   int
	value int
}

func Constructor(capacity int) LRUCache {
	return LRUCache{capacity: capacity, dlist: list.New(), cache: make(map[int]*list.Element)}
}

func (this *LRUCache) Get(key int) int {
	if elem, ok := this.cache[key]; ok {
		this.dlist.MoveToFront(elem)
		return elem.Value.(Entry).value
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if elem, ok := this.cache[key]; ok {
		elem.Value = Entry{key, value}
		this.dlist.MoveToFront(elem)
	} else {
		this.cache[key] = this.dlist.PushFront(Entry{key, value})
		if len(this.cache) > this.capacity {
			delete(this.cache, this.dlist.Remove(this.dlist.Back()).(Entry).key)
		}
	}
}

func main() {
	obj := Constructor(2)
	obj.Put(1, 1)
	obj.Put(2, 2)
	fmt.Println(obj.Get(1))
	obj.Put(3, 3)
	fmt.Println(obj.Get(2))
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
