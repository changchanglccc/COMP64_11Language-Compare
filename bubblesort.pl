bsort([],Sorted) :- Sorted = [].	
bsort([X], Sorted) :- Sorted = [X].
bsort(List, Sorted) :-
	swap(List, List), Sorted = List;
	swap(List, Partials), bsort(Partials, Sorted).
swap([], Sort) :- Sort = [].
swap([X], Sort) :- Sort = [X].
swap([X,Y|List], [Y|Sort]) :-
	X > Y, swap([X|List], Sort).
swap([X,Y|List], [X|Sort]) :-
	X =< Y, swap([Y|List], Sort).
