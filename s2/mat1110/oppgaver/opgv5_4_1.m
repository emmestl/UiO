function [x,y] = opgv5_4_1 (a,b,N)
    x = zeros(1, N);
    y = x;
    
    x(1) = a;
    y(1) = b;
    
    for n=2: N
        x(n) = 0.6*x(n-1) - 0.6*y(n-1) +0.2;
        y(n) = 0.6*x(n-1) + 0.6*y(n-1) +1;
        
    end
    
   %fikspunktet er (-1, 1)