function [x,y] = opgv5_4_4(a,b,N)
    x = zeros(1, N);
    y = x;
    
    x(1) = a;
    y(1) = b;
    
    for n=2 : N
        x(n) = 1.01*((x(n-1) +y(n-1))/2);
        y(n) = min(1.01*y(n-1), x(n-1));
        
    end
    
    
    %prisene vil etterhvert stige tilnærmet lineært, men ser at prisene til
    %bensinstasjon x vil alltid være litt høyere enn dem til y.