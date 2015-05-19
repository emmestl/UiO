function [x,y] = opgv5_4_2(a, b, N)
    x = zeros(1, N);
    y = x;
    
    x(1) = a;
    y(1) = b;
    
    for n=2 : N
        x(n) = 0.9*x(n-1) + 0.02*y(n-1) -10;
        y(n) = -1.01*x(n-1) + y(n-1) +300;
        
    end
    x(N)
    y(N)
    %går mot (297, 1985)