module Functional.subStrings
(*2)	Haciendo uso de la función filter, implemente una función que, a partir de una lista de cadenas de parámetro, 
filtre aquellas que contengan una subcadena que el usuario indique en otro argumento. Ej

sub_cadenas “la” [“la casa, “el perro”, “pintando la cerca”]

[“la casa, “pintando la cerca”]
*)
let filterWords (word:string) (list: string list) =
    list
    |> List.filter(fun str -> str.Contains(word))
    
let str = ["la casa";"el perro"; "pintando la cerca"; "no se cual"] 
printfn "%A" (filterWords "la" str)