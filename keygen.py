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
0 1:-0.998427 2:0.560088 3:1.054289 4:-0.234745 5:-0.444116 6:1.546273 7:-0.239544 8:-0.826991 9:-0.059459 10:-0.392420
1 1:1.150259 2:0.940590 3:0.418209 4:0.215897 5:-0.670951 6:-1.872950 7:-0.015380 8:1.192074 9:2.184925 10:-0.484831

'''
def compilefred(fredcsv):
  ligand = 'ligand'
  lig = open(ligand, 'wb')
  sep = ' '

  header = fredcsv.readline()
  first = fredcsv.readline()
  oldcsid, result, fid, cg4 = first.strip().split(',')
  lig.write(result + sep + fid + ':' + cg4)
  for li in fredcsv.readlines():
    csid, result, fid, cg4 = li.strip().split(',')
    if csid == oldcsid:
      lig.write(sep + fid + ':' + cg4)
    else:
      lig.write('\n')
      oldcsid = csid
      lig.write(result + sep + fid + ':' + cg4)


def main():
  csv = 'freddata.csv'
  fredcsv = open(csv, 'r')
  compilefred(fredcsv)
  

if __name__ == '__main__':
  main()
