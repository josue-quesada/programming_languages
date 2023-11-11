(*
    3) Realizar una función que obtenga el n-esimo elemento de una 
    lista pero utilizando solamente map (sin recursión).
*)

let nth_position n list =
    let indices = [0..List.length list - 1]
    let elements = List.map (fun i -> List.nth list i) indices
    match List.tryFindIndex (fun x -> x = n) elements with
    | Some index -> true, index + 1 
    | None -> false, 0

let result1, index1 = nth_position 2 [1; 2; 3; 4; 5]
let result2, index2 = nth_position 3 [1; 2; 3; 4; 5]
let result3, _ = nth_position 6 [1; 2; 3; 4; 5]

printfn "Position of nth element 2: %d" index1 
printfn "Position of nth element 3: %d" index2 
printfn "Position of nth element 6: Not found" 
