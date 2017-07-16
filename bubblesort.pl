% Bubble sort in prolog, because bubble sort

/*base case, take two arguments as input, when the Sorted is an empty lis stop recuision*/ 
bubble_sort([],Sorted) :- Sorted = [].
/*base case, stop when the Sorted is the same as the left side parameter*/	
bubble_sort([X], Sorted) :- Sorted = [X].
/*recuision*/
bubble_sort(Terms, Sorted) :-
	bubble(Terms, Terms), Sorted = Terms ;/*if two sides are equal*/
	bubble(Terms, Partials), bubble_sort(Partials, Sorted)./*operate bubble function for one time , recuision for the return from bubble operation*/

/*base case, when the left side is empty*/
bubble([], Bubbled) :- Bubbled = [].
/*base case, when two sides are equal*/
bubble([X], Bubbled) :- Bubbled = [X].
/*recuision,if Y is less than X, then the next recursion takes THE bigger one(i.e. X) and the tail of current recuision(i.e. Terms) as the parameter*/
bubble([X,Y|Terms], [Y|Bubbled]) :-
	Y < X, bubble([X|Terms], Bubbled).
/*in the opposite side of the previous recursion condition*/
bubble([X,Y|Terms], [X|Bubbled]) :-
	X =< Y, bubble([Y|Terms], Bubbled).

 /* Reference: https://gist.github.com/PythonJedi/e3a9c63dc594c370e4043a7cf24275ae */