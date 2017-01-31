/*********************************************
 * OPL 12.5 Model
 * Author: emmestl
 * Creation Date: Jan 25, 2017 at 12:52:10 PM
 *********************************************/
int m = ...;
int n = ...;

range rows = 1..m;
range cols = 1..n;

float c[cols] = ...;
float b[rows] = ...;
float A[rows][cols] = ...;

dvar float+ x[cols];

maximize sum(i in cols) c[i] * x[i];

subject to {
	forall (j in rows){
		(sum(i in cols) A[j][i] *x[i]) <= b[j];
	}
}