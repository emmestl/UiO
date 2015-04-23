function y = opgv2a(a, x, N)
    y = a*sin(x);
    for i = 2: N
        y(i) = a*sin(y(i-1));
    end
end

        