
--load dataset
A = load '/user/hduser/lab6/users.csv' using PigStorage(',') ;
--filter rows where city column is NY
ny_usrs = FILTER A BY EqualsIgnoreCase($2,'NY');
--Display users from NY
dump ny_usrs;

