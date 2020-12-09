group_all = group X by id;
count_id=foreach group_all generate COUNT(X.fname);

