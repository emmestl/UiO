function [x, y] = opgv5_5_1(N)
    x = zeros(6, N);
    y = x;
    
    x= -2.5 + (10000 -2.5)*rand(6, 1);
    y = 2.5 + (10000 +2.5)*rand(6, 1);
    
    for n =1 : N-1
        for k = 1 : 6
            x(k, n+1) = (1/2)*sin(x(k, n) + y(k, n));
            y(k, n+1) = (1/2)*cos(x(k, n) - y(k, n));
        end
    end
          
    for n = 1 : 6
        subplot(3,2,n)
        plot(x(n, :))
        hold on 
        plot(y(n, :))
    end
    
