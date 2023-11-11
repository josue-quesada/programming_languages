package main

import (
	"fmt"
	"sort"
)

type product struct {
	name     string
	quantity int
	price    int
}

type productList []product

var products productList

const minimumStock int = 10

func (l *productList) addProduct(name string, quantity int, price int) {
	found := false
	for i, prod := range *l {
		if prod.name == name {
			(*l)[i].quantity += quantity
			if prod.price != price {
				(*l)[i].price = price
			}
			found = true
			break
		}
	}

	if !found {
		*l = append(*l, product{name: name, quantity: quantity, price: price})
	}
}

func (l *productList) addMultipleProducts(products ...product) {
	for _, p := range products {
		l.addProduct(p.name, p.quantity, p.price)
	}
}

func (l *productList) findProduct(name string) (product, int, int) {
	for i, prod := range *l {
		if prod.name == name {
			return prod, i, 0
		}
	}
	return product{}, -1, -1
}

func (l *productList) sellProduct(name string, quantity int) int {
	_, prodIndex, err := l.findProduct(name)
	if err != 0 {
		return err
	}

	if (*l)[prodIndex].quantity >= quantity {
		(*l)[prodIndex].quantity -= quantity
		if (*l)[prodIndex].quantity == 0 {
			l.removeProductByIndex(prodIndex)
		}
		return 0
	}
	return -2
}

func (l *productList) removeProductByIndex(index int) {
	*l = append((*l)[:index], (*l)[index+1:]...)
}

func (l *productList) modifyPrice(name string, newPrice int) int {
	_, prodIndex, err := l.findProduct(name)
	if err != 0 {
		return err
	}

	(*l)[prodIndex].price = newPrice
	return 0
}

func (l *productList) modifyProductPrice(name string, newPrice int) int {
	_, prodIndex, err := l.findProduct(name)
	if err != 0 {
		return err
	}

	(*l)[prodIndex].price = newPrice
	return 0
}

func (l *productList) listMinimumProducts() []product {
	minimumProducts := []product{}
	for _, prod := range *l {
		if prod.quantity <= minimumStock {
			minimumProducts = append(minimumProducts, prod)
		}
	}
	return minimumProducts
}

func (l *productList) restockMinimumProducts(minimumList []product) {
	for _, prod := range minimumList {
		requiredQuantity := minimumStock - prod.quantity
		if requiredQuantity > 0 {
			l.addProduct(prod.name, requiredQuantity, prod.price)
		}
	}
}

func (l *productList) sortByPrice() {
	sort.SliceStable(*l, func(i, j int) bool {
		return (*l)[i].price < (*l)[j].price
	})
}

func fillData() {
	products.addProduct("rice", 15, 2500)
	products.addProduct("beans", 4, 2000)
	products.addProduct("milk", 8, 1200)
	products.addProduct("coffee", 12, 4500)
	products.addProduct("rice", 20, 2000)
}

func main() {
	fillData()
	fmt.Println("Initial inventory:")
	fmt.Println(products)

	// Modify the price of a product
	products.modifyPrice("rice", 2700)
	products.modifyProductPrice("beans", 2100)

	// Add various products
	products.addMultipleProducts(
		product{name: "sugar", quantity: 5, price: 1000},
		product{name: "salt", quantity: 10, price: 500},
	)

	// Sell products
	products.sellProduct("rice", 1)
	products.sellProduct("beans", 3)

	fmt.Println("Inventory after modifications, additions, and sales:")
	fmt.Println(products)

	// List products with minimum stock
	minimumProducts := products.listMinimumProducts()
	fmt.Println("Products with minimum stock:")
	fmt.Println(minimumProducts)

	// Restock inventory of minimum stock products
	products.restockMinimumProducts(minimumProducts)
	fmt.Println("Inventory after restocking minimum stock products:")
	fmt.Println(products)

	// Sort the product list by price
	products.sortByPrice()
	fmt.Println("Inventory sorted by price:")
	fmt.Println(products)
}
