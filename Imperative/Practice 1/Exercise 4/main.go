package main

type shoe struct {
	brand string
	price int
	size  int
	stock int
}

type shoes []shoe

var lshoes shoes

func (s *shoes) addShoe(brand string, price int, size int, stock int) {
	var shoe = s.searchShoe(brand)
	if shoe != nil {
		for i := 0; i < len(*s); i++ {
			if (*s)[i].size == size {
				(*s)[i].stock += stock
				if (*s)[i].price != price {
					(*s)[i].price = price
				}
				return
			}
		}
	}
	*s = append(*s, shoe{brand: brand, price: price, size: size, stock: stock})
}

func (s *shoes) searchShoe(brand string) *shoe {
	var result *shoe = nil
	var i int
	for i = 0; i < len(*s); i++ {
		if (*s)[i].brand == brand {
			result = &((*s)[i])
			break
		}
	}
	return result
}
