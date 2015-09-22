P = [1 0.7 0 0 0 ; 0 0 0.5 0 0
    0 0.3 0 0.65 0 ; 0 0 0.5 0 0 ; 0 0 0 0.35 1];
Pn = P;

start2 = [0; 1; 0; 0; 0]; %only s2 = 1, this is the state of intrest   
start3 = [0; 0; 1; 0; 0]; %only s3 = 1, this is the state of intrest   
for a = 1 : 200; %start a = 1

    Pn = P * Pn;
end    
    
Pn*start2
Pn*start3

