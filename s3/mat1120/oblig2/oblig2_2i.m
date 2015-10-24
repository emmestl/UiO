C = [0 1 0 ; 0 0 1; 4 4 -1];
[U, V] = eig(sym(C));

disp('egenvektorer')
U

disp('egenverider')
V