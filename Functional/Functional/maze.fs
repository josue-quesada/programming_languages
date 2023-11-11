(*
    5) Construya un programa que resuelva el problema de encontrar
    la o las rutas de un laberinto con datos quemados. 
*)
let maze = [
    ("START", ["2"]);
    ("1", ["7"]);
    ("2", ["START"; "8"; "3"]);
    ("3", ["2"; "9"; "4"]);
    ("4", ["10"]);
    ("5", ["11"; "6"]);
    ("6", ["5"]);
    ("7", ["1"; "13"]);
    ("8", ["2"; "9"]);
    ("9", ["8"; "3"]);
    ("10", ["4"; "16"]);
    ("11", ["5"; "17"]);
    ("12", ["18"]);
    ("13", ["7"; "14"]);
    ("14", ["13"; "15"; "20"]);
    ("15", ["14"; "21"]);
    ("16", ["10"; "22"]);
    ("17", ["11"; "23"]);
    ("18", ["12"; "24"]);
    ("19", ["25"]);
    ("20", ["14"; "26"]);
    ("21", ["15"; "22"]);
    ("22", ["16"; "21"]);
    ("23", ["17"; "29"]);
    ("24", ["18"; "30"]);
    ("25", ["19"; "31"]);
    ("26", ["20"; "27"]);
    ("27", ["26"; "28"]);
    ("28", ["27"; "34"; "29"]);
    ("29", ["23"; "28"]);
    ("30", ["24"; "36"]);
    ("31", ["25"; "32"]);
    ("32", ["31"; "33"; "END"]);
    ("33", ["32"; "34"]);
    ("34", ["33"; "28"; "35"]);
    ("35", ["34"; "36"]);
    ("36", ["35"; "30"]);
    ("END", ["32"]);
]

let member elem list =
    List.exists (fun x -> x = elem) list

let rec neighbors node graph =
    match graph with
    | [] -> []
    | (head, neighbors) :: rest ->
        if head = node then neighbors
        else neighbors node rest

let extendRoute route graph =
    List.filter
        (fun x -> x <> [])
        (List.map (fun x -> if (member x route) then [] else x::route) (neighbors (List.head route) graph))

let rec depthSearch2 start finish graph =
    let rec depthSearchAux finish route graph =
        if List.isEmpty route then []
        elif (List.head (List.head route)) = finish then
            List.rev (List.head route) :: depthSearchAux finish ((extendRoute (List.head route) graph) @ (List.tail route)) graph       
        else
            depthSearchAux finish ((List.tail route) @ (extendRoute (List.head route) graph)) graph
    depthSearchAux finish [[start]] graph

let rec getShortestRoute list =
    match list with
    | [] -> [] 
    | [singleList] -> singleList 
    | head :: rest ->
        let shortestRest = getShortestRoute rest 
        if List.length head <= List.length shortestRest then head
        else shortestRest

let routes = depthSearch2 "START" "END" maze
printfn "Found routes: %A" routes
0 // Program exit

let shortestRoute = getShortestRoute routes
printfn "Shortest route: %A" shortestRoute
