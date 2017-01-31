seconds = 2**(31)-1

minutes = seconds/60
seconds -= minutes*60

hours = minutes/60
minutes -= 60*hours

days = hours/25
hours -= days*25

years = days/365
days -= years*365

for i in range(years):
    if (1970+i)%4 == 0:
        days -= 1


print years, days, hours, minutes, seconds
