#change working dir
getwd()
setwd("/home/student/Desktop/170911044/lab2")
#create points
x<-c(1:10)
y<-vector()
for( i in x)
{
y<-append(y,i^2)  
}
#plot and add legend
legs=c("hums","bantz")
plot(x,y,"b")
legend(2,20,legs)
help("legend")
#read csv
df<-read.csv("~/Downloads/Online_Retail.csv")
#draw histogram
prices=unlist(df[c("UnitPrice")])
hist(prices,breaks=1, main="Breaks=1")
help("hist")
df2<-iris
#box plit
boxplot(iris$Sepal.Length ~ iris$Species)
#barplot
barplot(df2$Sepal.Length)
#manual one hot encoding
onehotspecs=vector()
for(i in df2$Species)
{
  if(i=="virginica")
  {
    onehotspecs=append(onehotspecs,1)
  }
  
  else{
    onehotspecs=append(onehotspecs,0)
  }
}
#hist of plant species
hist(onehotspecs,breaks=2)
#Seperate input vars 
df2<-df2[c(0:4)]
install.packages("e1071")
installed.packages("e1071")
#predictive analysis
library("e1071")
iris
train=df2[c(1:100),]
train=df2[c(1:100),]
target=onehotspecs[1:100]
#naive bayes
model=naiveBayes(train,target)

predict(model,df2[c(100:150),])
# help("naiveBayes")
model=kmeans(train,2)
plot(train,col=model$cluster)
#knn
install.packages("class")
library("class")
x1 <- c(7,7,3,1)
x2 <- c(7,4,4,4)
y <- c(1,1,2,2) #label
df<- cbind(x1,x2) #train dataset
testDF <- c(3,7) #test dataset
pred <- knn(train = df, test = testDF, cl = y, k=3)
pred
read.csv("~/Downloads/")

