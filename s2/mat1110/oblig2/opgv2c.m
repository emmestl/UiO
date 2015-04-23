x = linspace (0, 2*pi, 1000);
y1 = opgv2a(2 ,pi*rand ,50);
y2 = opgv2a(2, pi*rand ,50);

plot(x ,y1)
hold on 
plot(x, y2)

print -depsc opgv2cFig