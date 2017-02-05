/*********************************************
 * OPL 12.5 Model
 * Author: emmestl
 * Creation Date: Feb 5, 2017 at 3:55:31 PM
 *********************************************/
int m = ...;
int n = ...;

range rows = 1..n;
range cols = 1..m;

float b[rows] = ...;
float A[rows][cols] = ...;

dvar float+ x[cols];
dvar float+ t[rows];

minimize sum(i in rows) t[i];

subject to {
	forall (i in rows){
		b[i] - (sum(j in cols) A[i][j] *x[j]) <= t[i];
		-b[i] + (sum(j in cols) A[i][j] *x[j]) <= t[i];
	}
}