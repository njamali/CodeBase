import yfinance as yf
tkr = yf.Ticker(‘INO’)
hist = tkr.history(period=”3mo”)
type(hist)
hist.head()
df = hist.iloc[:,0:1]
df = df.reset_index() 
columns = dict(map(reversed, enumerate(df.columns)))
df = df.rename(columns=columns) 
df.head()
from datetime import date, timedelta, datetime
event_date = ‘22-Jun-2020’ 
dat_prev = datetime.strftime(datetime.strptime(event_date,’%d-%b-%Y’) — timedelta(days = 1) , ‘%Y-%m-%d’) 
dat_cur = datetime.strftime(datetime.strptime(event_date,’%d-%b-%Y’), ‘%Y-%m-%d’)
dat_next = datetime.strftime(datetime.strptime(event_date,’%d-%b-%Y’) + timedelta(days = 1) , ‘%Y-%m-%d’)
while not any(df[0] == dat_prev): 
      dat_prev = datetime.strftime(datetime.strptime(dat_prev,'%Y-%m-%d') — timedelta(days = 1) , '%Y-%m-%d')
while not any(df[0] == dat_next): 
      dat_next = datetime.strftime(datetime.strptime(dat_next,'%Y-%m-%d') + timedelta(days = 1) , '%Y-%m-%d')
 
print('Date_prev: ', dat_prev) 
print('Date_cur: ', dat_cur)
print('Date_next: ', dat_next)

prev_price = float(df[(df[0] == dat_prev)][1].values.tolist()[0])
cur_price = float(df[(df[0] == dat_cur)][1].values.tolist()[0])
next_price = float(df[(df[0] == dat_next)][1].values.tolist()[0])
print(‘The price on the day before the report: ‘, prev_price)
print(‘The price on the day of the report: ‘, cur_price)
print(‘The price on the next day of the report: ‘, next_price)

import matplotlib.pyplot as plt 
plt.plot([dat_prev,dat_cur,dat_next],[prev_price,cur_price,next_price])
plt.title(‘Stock prices’) 
plt.show()
