x = linspace (0, pi, 50);
y1 = opgv2a(2 ,pi*rand ,50);
y2 = opgv2a(2, pi*rand ,50);
y3 = opgv2a(2, pi*rand ,50);

plot(x ,y1)
hold on 
plot(x, y2)
hold on
plot(x, y3)

print -depsc opgv2bFig