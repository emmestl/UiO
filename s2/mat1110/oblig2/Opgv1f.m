A = [3 1 0 0 ; -1 1 0 0 ; 0 0 1 4; 0 0 1 4];
[U, V] = eig(sym(A))
rref(U)