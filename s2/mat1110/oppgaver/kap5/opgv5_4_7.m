function x = opgv5_4_7(x1, N)
    x = zeros(1, N);
    x(1) = x1;
    
    for n = 1:  N-1
        x(n+1) = x(n)^(2)+ x(n) + -2;
    end
    
    plot (x);
    