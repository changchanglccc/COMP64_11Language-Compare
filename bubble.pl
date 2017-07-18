bubble(Input,Sorted) :- swap(Input,List) , ! , bubble(List,Sorted).
                        bubble(Sorted,Sorted).
swap([A,B|List],[B,A|List]) :- A > B.
swap([C|List],[C|List1]) :- swap(List,List1).
