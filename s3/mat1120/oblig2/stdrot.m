function rot = stdrot(p)
    numtimes = 30;
    tol = 0.5 * 10^(-6);
    x = zeros(max(size(p))-1); %start columarray
    x = x(:, 1);
    x(1) = 1;
    
    rot = 0; %to stop matlab for complaining
    
    C = zeros(max(size(p))- 1, max(size(p)) - 1);

    %going form polynom to matrix
    for n = 1: max(size(p))-1
        if n == max(size(p))-1
            for m = 2: max(size(p))
                C(n, max(size(p))-(m) +1) = - p(m);
            end
        else
            C(n, n+1) = 1;   
        end
    end
   
    
    %using the code given but changing the output
    for n = 1: numtimes
        x = C*x;
        rot = max(abs(x));
        x = (1/rot)*x;
        error = max(abs(C*x-rot*x));
    
        if error < tol
            break;
        end
    end
    
    if error > tol
        disp('there is no dominant root in p')
    end
end
