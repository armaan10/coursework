 X = load '/user/hduser/pigdata' using PigStorage(',') as (id:int,fname:chararray,lname:chararray,age:int,phno:int,city:chararray);
 q1= FILTER X BY age > 23 and EqualsIgnoreCase(city,'chennai');
 dump q1;

