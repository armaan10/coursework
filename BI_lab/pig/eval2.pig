 X = load '/user/hduser/pigdata' using PigStorage(',') as (id:int,fname:chararray,lname:chararray,age:int,phno:int,city:chararray);
grouped = group X by age;
age_count = foreach grouped generate group as age,COUNT(X.id) as count;
dump age_count;
