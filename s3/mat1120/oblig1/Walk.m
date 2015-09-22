function [y] = Walk(p2, p3, p4) 
    P = [p2, p3, p4];
 
    for n = 1: 3
        if(P(n) > 1 || P(n) < 0)
            printf('Illeagal input value')
            return
        end
    end
    
    Q = [];
    for n = 1: 3
        Q(n) = 1 - P(n);
    end
    
   
    A = [1 -Q(1) 0 ; -P(2) 1 Q(2) ; 0 -P(3) 1];
    b = [P(1); 0 ; 0];
    
    extendedA = ref([A b]);
    y = extendedA(:,4);
    
end