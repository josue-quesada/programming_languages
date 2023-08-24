package main

import (
	"fmt"
	"strings"
	"unicode/utf8"
)

func count(s string) {
	fmt.Println("Words:", len(strings.Fields(s)))
	fmt.Println("Characters:", utf8.RuneCountInString(s))
	fmt.Println("Lines:", strings.Count(s, "\n")+1)
}

func main() {
	count("This is an example of some text \nalso this one")
}
