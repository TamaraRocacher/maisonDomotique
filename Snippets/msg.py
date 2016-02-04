#!/usr/bin/env python
# -*- coding: utf-8 -*-

import serial, os, re, pwd, urllib, sys, time

def get_serial_port():
    return "/dev/"+os.popen("dmesg | egrep ttyACM | cut -f3 -d: | tail -n1").read().strip()

username = ' '# pwd.getpwuid(os.getuid()).pw_gecos
message = username + ': ' + sys.argv[1]

data = urllib.urlencode({'user':'blabla','pass':'BLABLA','msg': 'lux'})
freeAddress = "https://smsapi.free-mobile.fr/sendmsg?" + data #Adresse avec les paramètres dans l'URL encodés

cmd = 'wget --no-check-certificate -O tmpfile "'+freeAddress+'"'; #requete GET à l'URL de l'API free

ser = serial.Serial(get_serial_port(), baudrate=9600, timeout=3) #Lire le port série USB
print freeAddress

numbers = tuple()

print time.strftime("%A %d %B %Y %H:%M:%S") 

fic = open("logMsg.txt", "w")

tempsActuel = time.time();
tempsNouveau = time.time();
while 1:	#Boucle infinie pour lire les entrées du capteur de luminosité. Un event serait mieux.
    donnee=str(ser.readline())
    numbers = [int(s) for s in donnee.split() if s.isdigit()]
    temp = 0.0
    print donnee
    print numbers[0]
    if numbers[0] > 200:
        tempsNouveau = time.time()
        if tempsNouveau - tempsActuel > 3600.0:
            os.system(cmd)
            tempsActuel = tempsNouveau
            

    
'''
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import pwd, os, sys, urllib.request, urllib.parse









print(message)
print(r.text[:300] + '...')
'''
