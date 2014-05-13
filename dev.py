#!/usr/bin/env python
# Description
'''
Example input: csid, result, fid, cg4; 500 frames for each
1, 1, 1, -7.469553
1, 1, 2, -8.305443
1, 1, 3, -7.217864
...
2, 1, 1, -7.233431
...
710, 0, 500, -5.659201

Example output: label followed by 500 features as doubles
split file into dev and train data by 1/5 as dev

'''
def div(data):
  dfile = open(data, 'r')
  dev = data + '.dev'
  train = data + '.train'
  devfile = open(dev, 'w')
  trainfile = open(train, 'w')
  onecount = 0
  zerocount = 0
  #Count 1's and 0's for dividing equally
  for ln in dfile.readlines():
    result = ln[0]
    if result == '1':
      onecount = onecount + 1
    else:
      zerocount = zerocount + 1
  print onecount
  print zerocount
  #put 4/5 of the 1's into train and 4/5 of 0's
  tcount = 0
  dcount = 0
  dfile2 = open(data, 'r')
  for ln in dfile2.readlines():
    if tcount < 4*onecount/5: # 4/5 of 1's into train
      trainfile.write(ln)
      tcount = tcount + 1
    elif tcount < onecount: # 1/5 of 1's into dev
      devfile.write(ln)
      tcount = tcount + 1
    elif dcount < 4*zerocount/5: # 4/5 of 0's in train
      trainfile.write(ln)
      dcount = dcount + 1
    else: # rest of the 0's (1/5)
      devfile.write(ln)

def main():
  data = 'ball'
  div(data)
  

if __name__ == '__main__':
  main()
