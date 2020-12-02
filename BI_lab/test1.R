#get current working dir
getwd()
#assign var
x=1
#get mode of 'x'
mode(x)
#assign 'str' and get mode and len
str1<-"sdasd"
mode(str1)
length(str1)
#create vector
vec<-c(1,2,3,4)
mode(vec)
x<-c(1:30)
x<-x-1
#help func
help("sequence")
#create vars v1 to v3
myvars<-paste("v",1:3,sep="")
myvars
vec1<-1:4
vec2<-c(-1,2,65,3)
#vectorized ifelse
res<-ifelse(vec1>vec2,vec1,vec2)
print(res)
#for loop
for(i in vec2)
{
  print(i)
}
#create dataframe
df<-data.frame(branch=c("IT","CSE","ECE"),sem=c(2,6,8),sex=c("Female","Male","Male"))
print(df)
#read csv
csv<-read.csv("Online Retail.csv")
#keep columns
csv[c(1,2)]

help(apply)
