A = [0.7 0.3 0.25 ; 0.1 0.5 0.15 ; 0.2 0.2 0.6];
x = [1/3 1/3 1/3]';
for n =1:100
    x = A*x;
end

x