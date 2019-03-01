#!/usr/bin/env python

import socket
import logEntry_pb2
import sys
import io

TCP_IP = '127.0.0.1'
TCP_PORT = 7234
BUFFER_SIZE = 1024  # Normally 1024, but we want fast response


while True:
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((TCP_IP, TCP_PORT))
    s.listen(5)
    conn, addr = s.accept()
    print 'Connection address:', addr
    data = conn.recv(BUFFER_SIZE)
    if not data: break
    print "received data:", data
    try:
      f = io.BytesIO(data)
      e = logEntry_pb2.LogEntry()
      e.ParseFromString(f.read())
      f.close()
      print "received data:", e.timestamp
      print "received data:", e.userId
      print "received data:", e.event
      
      
      file = open("demofile.txt", "a")
      # counter = str(int(f.read().strip())+1)
      file.write(str(e.timestamp))
      file.write("\n")
      file.write(str(e.userId))
      file.write("\n")
      file.write(str(e.event))
      file.write("\n")
      file.close()
      
      conn.close()
    except IOError:
      print ": Could not open file.  Creating a new one."
    

    
