P = [1 0.7 0 0 0 ; 0 0 0.5 0 0
    0 0.3 0 0.65 0 ; 0 0 0.5 0 0 ; 0 0 0 0.35 1];
k = [2 3 4 40 80];

for n = 1 : 5;
    Pn = P;
    start = [0; 0; 0; 1; 0]; %only s4 = 1, this is the state of intrest   
    for a = 2 : k(n); %start a = 1
        
        Pn = P * Pn;
    end    
    
    prob = Pn*start;
    
    fprintf('For n = %d\n ', a)
    disp ('P = ')
    disp (Pn)
    
    fprintf('get the followin matrix with start in s4 \n') 
    disp(prob)
    fprintf('probability to go from s4->s2 after n=%d is: %f \n\n\n',a, prob(2))
    
end


