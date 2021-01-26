rm(list = ls())
library(kknn)

data <- read.table("credit_card_data.txt", stringsAsFactors = FALSE, header = FALSE)
head(data)

check_accuracy = function(X){
  predicted <- rep(0,(nrow(data))) 

  for (i in 1:nrow(data)){


    model=kknn(V11~V1+V2+V3+V4+V5+V6+V7+V8+V9+V10,data[-i,],data[i,],k=X, scale = TRUE) 


    predicted[i] <- as.integer(fitted(model)+0.5)
  }

  accuracy = sum(predicted == data[,11]) / nrow(data)
  return(accuracy)
}

acc <- rep(0,20)
for (X in 1:20){
  acc[X] = check_accuracy(X) 
}

acc
