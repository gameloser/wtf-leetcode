package main

import "fmt"

// slice pointer
func test(res *[]string) {
	*res = append(*res, "1.1.1.1")
}

func main() {
	res := &[]string{}
	test(res)
	fmt.Println(*res)
}
