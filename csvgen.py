#!/usr/bin/env python
# Description
'''
Example output: csid, result, fid, cg4; 500 frames for each
1, 1, 1, -7.469553
1, 1, 2, -8.305443
1, 1, 3, -7.217864
...
2, 1, 1, -7.233431
...
710, 0, 500, -5.659201

'''
import random

def getFrames(csid, csv):
  mu = -6.544621958
  dev = 1.362293285
  numframes = 500

  if csid < 11:
    res = 1;
  else:
    res = 0;
  for frame in range(1, numframes+1):
    x = random.normalvariate(mu, dev)
    csv.write(str(csid) + ',' + str(res) + ',' + str(frame) + ',' + str(x) + '\n') 

#x= random.normalvariate(2,17)

def main():
  fredcsv = 'freddata.csv'
  numcsid = 710
  csv = open(fredcsv, 'w')
  for csid in range(1, numcsid+1):
    getFrames(csid, csv)

if __name__ == '__main__':
  main()

