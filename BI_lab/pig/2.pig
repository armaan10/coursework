B = load '/user/hduser/lab6/tweets.csv' using PigStorage(',') ;
--find tweets with favorite keyword
X = FILTER B BY ($1 matches '(?i).*favorite.*'); 
--order by tweet id
Y = ORDER X BY $0;
--display 
dump Y;
