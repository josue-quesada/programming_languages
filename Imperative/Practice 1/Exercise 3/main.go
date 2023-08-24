package main

func rotate(movements int, dir int, list *[]string) {
	if movements > len(*list) {
		movements -= len(*list)
	}
	switch dir {
	case 0:
		*list = append((*list)[movements:], (*list)[:movements]...)
	case 1:
		*list = append((*list)[len(*list)-movements:], (*list)[:len(*list)-movements]...)
	default:
		println("Dir must be and int, 0 for left or 1 for right rotation")
	}
}

func main() {
	print("List before rotation: ")
	data := []string{"a", "b", "c", "d", "e", "f", "g", "h"}
	for i := 0; i < len(data); i++ {
		print(data[i], " ")
	}
	rotate(2, 0, &data)
	print("\nList after rotation: ")
	for i := 0; i < len(data); i++ {
		print(data[i], " ")
	}
}
