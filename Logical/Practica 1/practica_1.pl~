% 1)Defina sumlist(L, S) que es verdadero si S es la suma de los
% elementos de L.
% Usage examples
% sumList([3,4,5], 12). returns true
% sumList([1,2,3], 2). returns false

sumList([],0).
sumList([X], X).
sumList([H | T], S) :- sumList(T, S1), S is S1 + H.

% 2) Defina la relación subconj(S, S1), donde S y S1 son listas
% representando conjuntos, que es verdadera si S1 es subconjunto de S.
% Usage examples
% subconj([1,2],[1,2,3,4]). returns true
% subconj([5],[1,2,3,4]). returns false

subConj([], _).
subConj([X|Xs], S) :- member(X, S), subconj(Xs, S).

% 3) Defina la función aplanar(L,L2). Esta función recibe una lista con
% múltiples listas anidadas como elementos otra lista que contendría los
% mismos elementos de manera lineal (sin listas).
% Usage example
% aplanar([1, [2, [3, 4], 5], [6, [7, 8], 9]], L2).


aplanar([], []).
aplanar([X|Xs], L2) :- is_list(X), aplanar(X, L1),
    aplanar(Xs, L2Rest), append(L1, L2Rest, L2).
aplanar([X|Xs], [X|L2Rest]) :- \+ is_list(X), aplanar(Xs, L2Rest).

%4) Defina un predicado llamado partir(Lista, Umbral, Menores,
% Mayores) para dividir una lista respecto un umbral dado, dejando
% los valores menores a la izquierda y los mayores a la derecha.
% Por ejemplo, el resultado de partir la lista [2,7,4,8,9,1]
% respecto al umbral 6 serían las listas [2,4,1] y [7,8,9].
% Usage example
% partir([2, 7, 4, 8, 9, 1], 6, L, G).

partir([], _, [], []).
partir([X|T], Y, [X|Less], Greater) :-
    X =< Y, partir(T, Y, Less, Greater).
partir([X|Rest], Y, Less, [X|Greater]) :-
    X > Y, partir(Rest, Y, Less, Greater).

% 5)Implemente un predicado que, a partir de una lista de cadenas string,
% filtre aquellas que contengan una subcadena que el usuario indique en
% otro argumento
% Usage examples
% subCadenas("la", ["la casa", "el perro", "pintando la cerca"],
% Filtered).

subCadenas(_, [], []).
subCadenas(S, [H|T], Filtradas) :-
    sub_atom(H, _, _, _, S),
    subCadenas(S, T, FiltradasResto),
    Filtradas = [H|FiltradasResto].

subCadenas(S, [_|T], Filtradas) :-
    subCadenas(S, T, Filtradas).
