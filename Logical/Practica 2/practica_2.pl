% Modificar el ejercicio de grafos para que funcione con pesos
%
% Usage example
% ruta(i,f,Ruta,Peso).
% ruta(a,f,Ruta,Peso).

conectado(i,a, 50).
conectado(i,b, 20).
conectado(a,b, 15).
conectado(a,c, 25).
conectado(b,f, 35).
conectado(b,c, 40).
conectado(c,f, 5).

conectados(X,Y):- conectado(X,Y).
conectados(X,Y):- conectado(Y,X).


ruta(Ini,Fin,Ruta, Peso):- ruta2(Ini,Fin,[],Ruta, 0, Peso).

ruta2(Fin,Fin,_Visitados,[Fin], PesoA, PesoA).
ruta2(Ini,Fin,Visitados,[Ini|Resto], PesoA, PesoTotal):-
    conectado(Ini,Alguien, Peso),
    not(member(Alguien, Visitados)),
    NuevoPeso is PesoA + Peso,
    ruta2(Alguien,Fin,[Alguien|Visitados],Resto, NuevoPeso, PesoTotal).

% Crear el codigo necesario para saber cuanto se parecen los
% cromosomas(una lista de 0 y 1) de unas personas
%
% Usage example
% persona(b, Cromosoma1), persona(g, Cromosoma2), similitud(Cromosoma1,
% Cromosoma2, Porcentaje).

persona(a, [1, 0, 1, 0, 0, 1, 0, 1, 1, 1]).
persona(b, [0, 0, 1, 0, 1, 1, 0, 0, 1, 0]).
persona(c, [1, 1, 0, 1, 0, 0, 1, 0, 1, 1]).
persona(d, [0, 0, 0, 0, 1, 1, 1, 1, 0, 1]).
persona(e, [1, 1, 1, 0, 0, 0, 1, 0, 0, 0]).
persona(f, [0, 1, 1, 0, 1, 0, 1, 1, 0, 1]).
persona(g, [0, 0, 0, 1, 1, 0, 0, 1, 1, 0]).
persona(h, [1, 0, 0, 1, 0, 0, 0, 1, 1, 1]).
persona(i, [0, 1, 0, 1, 1, 1, 0, 0, 0, 0]).
persona(j, [1, 1, 0, 0, 1, 0, 0, 0, 1, 0]).


similitud(Cromosoma1, Cromosoma2, Porcentaje) :-
    length(Cromosoma1, N), % Obtener la longitud de los cromosomas
    contar_coincidencias(Cromosoma1, Cromosoma2, 0, Coincidencias),
    Porcentaje is (Coincidencias / N) * 100.

contar_coincidencias([], [], Coincidencias, Coincidencias).
contar_coincidencias([H1|T1], [H2|T2], CoincidenciasTemp, Coincidencias) :-
    H1 =:= H2,
    NuevaCoincidenciaTemp is CoincidenciasTemp + 1,
    contar_coincidencias(T1, T2, NuevaCoincidenciaTemp, Coincidencias).
contar_coincidencias([_|T1], [_|T2], CoincidenciasTemp, Coincidencias) :-
    contar_coincidencias(T1, T2, CoincidenciasTemp, Coincidencias).
