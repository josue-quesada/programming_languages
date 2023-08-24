package main

import "fmt"

func printFigure(n int) {
	if n > 0 && n%2 != 0 {
		var i, j, k int
		for i = 1; i <= n-n/2; i++ {
			for j = 1; j <= n-i; j++ {
				print(" ")
			}
			for k = 1; k <= i*2-1; k++ {
				fmt.Print("*")
			}
			fmt.Println()
		}
		for i = n / 2; i > 0; i-- {
			for j = 1; j <= n-i; j++ {
				print(" ")
			}
			for k = 1; k <= i*2-1; k++ {
				fmt.Print("*")
			}
			fmt.Println()
		}

	} else {
		fmt.Println("Invalid number")
	}
}

func main() {
	printFigure(9)
}
