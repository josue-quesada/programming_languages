(*
    4) Modifique el ejercicio de búsqueda en profundidad visto
     en clase para ingresar pesos a los vértices.
*)

type WeightedGraph = (char * (char * int) list) list

let dfsWeighted graph start goal =
    let rec dfs_aux path goal =
        if List.isEmpty path then
            None // No path found
        elif List.head path = goal then
            Some (List.rev path) // Goal found
        else
            let currentVertex = List.head path
            match List.tryFind (fun (neighbor, weight) -> neighbor = currentVertex) graph with
            | Some (_, neighbors) ->
                let extensions = List.choose (fun (neighbor, weight) ->
                    if not (List.contains neighbor path) then
                        Some (neighbor :: path, weight)
                    else
                        None
                ) neighbors
                let results = List.choose (fun (path', weight) ->
                    match dfs_aux path' goal with
                    | Some journey -> Some (journey, weight)
                    | None -> None
                ) extensions
                match List.minBy snd results with
                | (bestPath, bestWeight) -> Some bestPath
            | None -> None

    dfs_aux [start] goal

// Usage example:
let weightedGraph : WeightedGraph = [
    ('A', [('B', 3); ('C', 1)]);
    ('B', [('D', 2)]);
    ('C', [('D', 6)]);
    ('D', []);
]

let result = dfsWeighted weightedGraph 'A' 'D'
match result with
| Some journey ->
    printfn "Shortest path: %A" journey
| None ->
    printfn "No path found."
