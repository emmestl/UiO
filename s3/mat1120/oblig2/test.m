p = [1 2 3 4 5 6 7 8 9];
size(p)
C = zeros(max(size(p)), max(size(p)));

for n = 1: max(size(p));
    if n == max(size(p))
        for m = 1: max(size(p))
            C(n, m) = - p(m);
        end
    else
        C(n, n+1) = 1;   
    end
end
