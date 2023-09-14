module Functional.shift
(*
1)	Realizar ejercicio para desplazar (SHIFT) una lista de elementos
 n posiciones a la izquierda o la derecha según se indique por 
 0argumento. Ej:

desplazar “izq” 3  [1,2,3,4,5]
[4,5,0,0,0]

desplazar “der” 2  [1,2,3,4,5]
[0,0,1,2,3]

desplazar “izq” 6  [1,2,3,4,5]
[0,0,0,0,0]
*)

let shift dir moves list =
    let size = List.length list
    let n = if dir = "left" then moves % size else size - (moves % size)
    
    let rec takeNum n list =
        match n, list with
        | 0, _ -> []
        | _, [] -> []
        | _, head::tail -> head::takeNum (n - 1) tail 
        
    let rec leaveNum n list =
        match n, list with
        | 0, _ -> list
        | _, [] -> []
        | _, head::tail -> leaveNum (n - 1) tail
        
    let leftSide = takeNum n list
    let rightSide = leaveNum n list
    let newList = rightSide @ leftSide
    
    newList

let res1 = shift "left" 3 [1; 2; 3; 4; 5]
let res2 = shift "right" 2 [5; 4; 3; 2; 1]
let res3 = shift "right" 1 [8; 6; 1; 4; 2]

printfn "%A" res1
printfn "%A" res2
printfn "%A" res3


