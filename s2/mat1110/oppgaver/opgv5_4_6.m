function [x,y] = opgv5_4_6(a, b, p, q, N)
    x = zeros(1, N);
    y = x;
    
    x(1) = a;
    y(1) = b;
    
    for n=2 : N
        x(n) = 2.2*x(n-1)*(1 - x(n-1)) +0.01*x(n-1)*y(n-1);
        y(n) = 3.1*y(n-1)*(1- y(n-1)) - 0.02*x(n-1)*y(n-1);
        
    end
    
    plot(x)
    hold on
    plot(y)
    hold off