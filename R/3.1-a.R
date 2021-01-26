# ------------------------ Code for Question 3.1-A -------------------------------------

# Clear environment

rm(list = ls())

# Installing and calling packages

install.packages("kknn")
library(kknn)

# Reading the data

data <- read.table("credit_card_data.txt", stringsAsFactors = FALSE, header = FALSE)

#
# optional check to make sure the data is read correctly
#

head(data)

##   V1 V2 V3 V4 V5 V6 V7 V8 V9 V10 V11
## 1 1 30.83 0.000 1.25 1 0 1 1 202 0 1
## 2 0 58.67 4.460 3.04 1 0 6 1 43 560 1
## 3 0 24.50 0.500 1.50 1 1 0 1 280 824 1
## 4 1 27.83 1.540 3.75 1 0 5 0 100 3 1
## 5 1 20.17 5.625 1.71 1 1 0 1 120 0 1
## 6 1 32.08 4.000 2.50 1 1 0 0 360 0 1
# NOTE: ALL ROWS OF THIS FILE STARTING WITH "##" DENOTE R OUTPUT
#
# Fit the model.
# V11 is response, other variables are predictors
#

############# Using train.kknn #############
#
# This method uses n-fold cross-validation, where n is the number
# of data points, because that's how train.kknn does
# cross validation.  It's also called "leave-one-out" cross
# validation.

# Setting the random number generator seed so that our results are reproducible

set.seed(1)

# set maximum value of k (number of neighbors) to test

kmax <- 30

# use train.kknn for leave-one-out cross-validation up to k=kmax

model <- train.kknn(V11~.,data,kmax=kmax,scale=TRUE)

# create array of prediction qualities

accuracy <- rep(0,kmax)

# calculate prediction qualities

for (k in 1:kmax) {
    predicted <- as.integer(fitted(model)[[k]][1:nrow(data)] + 0.5) # round off to 0 or 1
    accuracy[k] <- sum(predicted == data$V11)
}

# show accuracies

accuracy

##   [1] 533 533 533 533 557 553 554 555 554 557 557 558 557 557 558 558 558 557 556 556 555 554 552 553 553 552 550 548 549 550
