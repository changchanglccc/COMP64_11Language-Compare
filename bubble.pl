/**
* Bubble Sort With Recursion
* Example:
* bubble([10,99,8,2,6,5,4,3,2,1],Sorted).
*/
bubble(Input,Sorted) :- swap(Input,List) , ! , bubble(List,Sorted).
bubble(Sorted,Sorted).
swap([A,B|List],[B,A|List]) :- A > B.
swap([C|List],[C|List1]) :- swap(List,List1).
