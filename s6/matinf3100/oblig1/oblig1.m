b = [2, 2, 4, 9, 6, 10, 11, 20, 16, 20];
a = [0: 9];
A = [0, 1; 1, 1; 2, 1; 3, 1; 4, 1; 5, 1; 6, 1; 7, 1; 8, 1; 9, 1];

x = (inv((A.')*A))*(A.')*(b.')

scatter(a, b, 'filled', 'r')
hold on

plot(a, A*x, 'b')
hold on

plot(a, A*[2; 0], 'm')

xlabel('a')
ylabel('b')
legend('datapoints', 'regression using L2', 'regression using L1',...
 'Location', 'northwest')
