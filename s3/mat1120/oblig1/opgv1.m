P = [1 0.7 0 0 0 ; 0 0 0.5 0 0 ; 0 0.3 0 0.65 0 ; 0 0 0.5 0 0 ; 0 0 0 0.35 1];
Pn = P;
k = [3 4 40 80];

for n = 1 : 4;
    start = [0; 0; 0; 1; 0]; %har at alle utenom posisjon 4 er lik 0 siden vi vil vite hva som skjer om vi starter her   
    for a = 1 : k(n); %antar vi sier k begynner paa 1
        
        Pn = P * Pn;
    end    
    
    'Etter "a" tidsløp'
    a
    Pn
    Pn*start
end


