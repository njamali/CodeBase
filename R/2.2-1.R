
rm(list = ls())

library(kernlab)

data <- read.table("/Users/Chewy/Downloads/credit_card_data.txt", stringsAsFactors = FALSE, header = FALSE)
head(data)

set.seed(1)

model_scaled <- ksvm(as.matrix(data[,1:10]),as.factor(data[,11]),
		   type = "C-svc", 
              kernel = "vanilladot", 
              C = 100,
		   scaled=TRUE) 
              


model_scaled <- ksvm(V11~.,data=data,
              type = "C-svc", 
              kernel = "vanilladot", 
              C = 100,
		   scaled=TRUE) 


attributes(model_scaled)


model_scaled


a_scaled <- colSums(model_scaled@xmatrix[[1]] * model_scaled@coef[[1]])

a0_scaled<- -model_scaled@b

a_scaled
a0_scaled


predicted_scaled<-rep(0,nrow(data))

for (i in 1:nrow(data)){


  if (sum(a_scaled*(data[i,1:10]-model_scaled@scaling$x.scale$`scaled:center`)/model_scaled@scaling$x.scale$`scaled:scale`) + a0_scaled >= 0){
    predicted_scaled[i] <- 1
  }


  if (sum(a_scaled*(data[i,1:10]-model_scaled@scaling$x.scale$`scaled:center`)/model_scaled@scaling$x.scale$`scaled:scale`) + a0_scaled < 0){
    predicted_scaled[i] <- 0
  }
}
predicted_scaled


pred_scaled <- predict(model_scaled,data[,1:10])
pred_scaled


sum(pred_scaled == data$V11) / nrow(data)
sum(predicted_scaled == data$V11) / nrow(data)

model_unscaled <- ksvm(as.matrix(data[,1:10]),as.factor(data[,11]),
		   type = "C-svc", 
              kernel = "vanilladot", 
              C = 100,
		   scaled=FALSE)
              

model_unscaled <- ksvm(V11~.,data=data,
              type = "C-svc", 
              kernel = "vanilladot", 
              C = 100,
		   scaled=FALSE) 

attributes(model_unscaled)

model_unscaled

a_unscaled <- colSums(model_unscaled@xmatrix[[1]] * model_unscaled@coef[[1]])


a0_unscaled <- -model_unscaled@b
a_unscaled
a0_unscaled


predicted_unscaled<-rep(0,nrow(data))


for (i in 1:nrow(data)){


  if (sum(a_unscaled*data[i,1:10]) + a0_unscaled >= 0){
    predicted_unscaled[i] <- 1
  }


  if (sum(a_unscaled*data[i,1:10]) + a0_unscaled < 0){
    predicted_unscaled[i] <- 0
  }
}
predicted_unscaled

pred_unscaled <- predict(model_unscaled,data[,1:10])
pred_unscaled

sum(pred_unscaled == data$V11) / nrow(data)
sum(predicted_unscaled == data$V11) / nrow(data)
