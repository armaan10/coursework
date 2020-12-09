--load user data
 users = load '/user/hduser/lab6/users.csv' using PigStorage(',') as (u_name:chararray,name:chararray,city:chararray);
--load tweet data
 tweets = load '/user/hduser/lab6/tweets.csv' using PigStorage(',') as (tweet_id:int,tweet:chararray,u_name:chararray);
--group by username
grouped = group tweets by u_name;
--count number of tweets per user
tweet_count = foreach grouped generate group as u_name,COUNT(tweets.$1) as count;
--display
dump tweet_count;
