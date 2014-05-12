ligandball
==========

Initialization to edit code with Eclipse:

1) find the directory you want to clone the project and clone it:
desired-location$ git clone git@github.com:rumoffu/ligandball.git
- this should create a folder called ligandball

2) open Eclipse and choose ligandball as the workspace

3) File -> Import -> General -> Existing Projects into Workspace -> next

4) Select root directory: Browse -> 
go to desired-location -> ligandball -> neighbors -> OK

5) check to import neighbors

6) File -> New -> folder : models


Eclipse command arguments:

EvenOddEasyTest
-mode test -model_file models/easy.even_odd.model -data data/easy.dev -predictions_file models/easy.dev.even_odd.predictions

EvenOddEasyTrain
-mode train -algorithm even_odd -model_file models/easy.even_odd.model -data data/easy.train

BallLigTrain
-mode train -algorithm ball -model_file models/lig.ball.model -data data/ligand.train -epsilon 45

BallLigTest
-mode test -model_file models/lig.ball.model -data data/ligand.dev -predictions_file models/lig.dev.ball.predictions

FrameBallTrain
-mode train -algorithm ball -model_file models/frame.ball.model -data data/frame.train


Ball

==============================================

Positive factor:

Train
----------------------------------------
Number correct: 520/560 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/40 (0.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 100.0 average distance : 34.589146438354916 Accuracy
Total execution time (ms): 20767

Number correct: 520/560 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/40 (0.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 60.0 average distance : 34.589146438354916 Accuracy
Total execution time (ms): 20650

Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 50.0 average distance : 34.589146438354916 Accuracy
Total execution time (ms): 20693

Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 45.0 average distance : 34.589146438354916 Accuracy
Total execution time (ms): 20725

Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 35.0 average distance : 34.589146438354916 Accuracy
Total execution time (ms): 20641

Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 30.0 average distance : 34.589146438354916 Accuracy
Total execution time (ms): 20769

Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 25.0 average distance : 34.589146438354916 Accuracy
Total execution time (ms): 20767

Dev 
------------------------------------------

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 100.0 average distance : 34.589146438354916 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 4835

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 60.0 average
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 4602

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 50.0 average distance : 34.589146438354916 Accuracy
Number correct: 140/140 (100.00%)
Precision: 10/10 (100.00%)
Recall: 10/10 (100.00%)
Total execution time (ms): 4834

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 45.0 average distance : 34.589146438354916 Accuracy
Number correct: 140/140 (100.00%)
Precision: 10/10 (100.00%)
Recall: 10/10 (100.00%)
Total execution time (ms): 4813

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 35.0 average distance : 34.589146438354916 Accuracy
Number correct: 140/140 (100.00%)
Precision: 10/10 (100.00%)
Recall: 10/10 (100.00%)
Total execution time (ms): 4766

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 30.0 average distance : 34.589146438354916 Accuracy
Number correct: 135/140 (96.43%)
Precision: 5/5 (100.00%)
Recall: 5/10 (50.00%)
Total execution time (ms): 4920

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 25.0 average distance : 34.589146438354916 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 4790



negative factor:

Train
-------------------------

Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 50.0 average distance : 34.589146438354916 Accuracy
Total execution time (ms): 20773

Number correct: 550/560 (98.21%)
Precision: 30/30 (100.00%)
Recall: 30/40 (75.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 450 with epsilon 50.0 average distance : 32.78858161071847 Accuracy
Total execution time (ms): 18413

Number correct: 530/560 (94.64%)
Precision: 10/10 (100.00%)
Recall: 10/40 (25.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 425 with epsilon 50.0 average distance : 31.859725285952 Accuracy
Total execution time (ms): 17475

Number correct: 520/560 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/40 (0.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 400 with epsilon 50.0 average distance : 30.905706622415455 Accuracy
Total execution time (ms): 16564





Dev
-------------------------

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 50.0 average distance : 34.589146438354916 Accuracy
Number correct: 140/140 (100.00%)
Precision: 10/10 (100.00%)
Recall: 10/10 (100.00%)
Total execution time (ms): 4954

Testing Basic Nearest Neighbor with IG numfeatures: 450 with epsilon 50.0 average distance : 32.78858161071847 Accuracy
Number correct: 138/140 (98.57%)
Precision: 8/8 (100.00%)
Recall: 8/10 (80.00%)
Total execution time (ms): 4237

Testing Basic Nearest Neighbor with IG numfeatures: 425 with epsilon 50.0 average distance : 31.859725285952 Accuracy
Number correct: 131/140 (93.57%)
Precision: 1/1 (100.00%)
Recall: 1/10 (10.00%)
Total execution time (ms): 4435

Testing Basic Nearest Neighbor with IG numfeatures: 400 with epsilon 50.0 average distance : 30.905706622415455 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 3863





positive factor:

Train
-------------------------

Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 50.0 average distance : 34.589146438354916 Accuracy
Total execution time (ms): 20693

Number correct: 551/560 (98.39%)
Precision: 31/31 (100.00%)
Recall: 31/40 (77.50%)
Tested Basic Nearest Neighbor with IG numfeatures: 450 with epsilon 50.0 average distance : 32.7965768889451 Accuracy
Total execution time (ms): 18490

Number correct: 520/560 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/40 (0.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 400 with epsilon 50.0 average distance : 30.921835210411032 Accuracy
Total execution time (ms): 16568



dev
-------------------------

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 50.0 average distance : 34.589146438354916 Accuracy
Number correct: 140/140 (100.00%)
Precision: 10/10 (100.00%)
Recall: 10/10 (100.00%)
Total execution time (ms): 4834

Testing Basic Nearest Neighbor with IG numfeatures: 450 with epsilon 50.0 average distance : 32.7965768889451 Accuracy
Number correct: 139/140 (99.29%)
Precision: 9/9 (100.00%)
Recall: 9/10 (90.00%)
Total execution time (ms): 4345


Testing Basic Nearest Neighbor with IG numfeatures: 400 with epsilon 50.0 average distance : 30.921835210411032 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 3759





Frame
==============================================

dev
----------------------

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 50.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 4725

Testing Basic Nearest Neighbor with IG numfeatures: 250 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 2164

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 4828

Testing Basic Nearest Neighbor with IG numfeatures: 40 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 613

Testing Basic Nearest Neighbor with IG numfeatures: 450 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 4286

Testing Basic Nearest Neighbor with IG numfeatures: 425 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 4085

Testing Basic Nearest Neighbor with IG numfeatures: 413 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 3901

Testing Basic Nearest Neighbor with IG numfeatures: 400 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 3781

Testing Basic Nearest Neighbor with IG numfeatures: 388 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 3591

Testing Basic Nearest Neighbor with IG numfeatures: 375 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 3424

Testing Basic Nearest Neighbor with IG numfeatures: 363 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 3385

Testing Basic Nearest Neighbor with IG numfeatures: 350 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 3235

Testing Basic Nearest Neighbor with IG numfeatures: 300 with epsilon 130.0 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 2757




train
-----------------------

Total data time (ms): 875
Total train time (ms): 1100
Testing Basic Nearest Neighbor with IG numfeatures: 300 with epsilon 130.0 Accuracy
Number correct: 520/560 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/40 (0.00%)
Total execution time (ms): 12306

Testing Basic Nearest Neighbor with IG numfeatures: 350 with epsilon 130.0 Accuracy
Number correct: 526/560 (93.93%)
Precision: 6/6 (100.00%)
Recall: 6/40 (15.00%)
Total execution time (ms): 14708

Total data time (ms): 875
Total train time (ms): 1108
Testing Basic Nearest Neighbor with IG numfeatures: 363 with epsilon 130.0 Accuracy
Number correct: 532/560 (95.00%)
Precision: 12/12 (100.00%)
Recall: 12/40 (30.00%)
Total execution time (ms): 15166


Total data time (ms): 866
Total train time (ms): 1096
Testing Basic Nearest Neighbor with IG numfeatures: 375 with epsilon 130.0 Accuracy
Number correct: 540/560 (96.43%)
Precision: 20/20 (100.00%)
Recall: 20/40 (50.00%)
Total execution time (ms): 15687

Total data time (ms): 871
Total train time (ms): 1106
Testing Basic Nearest Neighbor with IG numfeatures: 388 with epsilon 130.0 Accuracy
Number correct: 549/560 (98.04%)
Precision: 29/29 (100.00%)
Recall: 29/40 (72.50%)
Total execution time (ms): 16051

Total train time (ms): 1179
Testing Basic Nearest Neighbor with IG numfeatures: 400 with epsilon 130.0 Accuracy
Number correct: 556/560 (99.29%)
Precision: 36/36 (100.00%)
Recall: 36/40 (90.00%)
Total execution time (ms): 16396

Total data time (ms): 871
Total train time (ms): 1121
Testing Basic Nearest Neighbor with IG numfeatures: 413 with epsilon 130.0 Accuracy
Number correct: 559/560 (99.82%)
Precision: 39/39 (100.00%)
Recall: 39/40 (97.50%)
Total execution time (ms): 17310


Total data time (ms): 795
Total train time (ms): 1047
Testing Basic Nearest Neighbor with IG numfeatures: 425 with epsilon 130.0 Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Total execution time (ms): 17520

Total data time (ms): 859
Total train time (ms): 1096
Testing Basic Nearest Neighbor with IG numfeatures: 450 with epsilon 130.0 Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Total execution time (ms): 18494

Total data time (ms): 862
Total train time (ms): 1055
Testing Basic Nearest Neighbor with IG numfeatures: 40 with epsilon 130.0 Accuracy
Number correct: 520/560 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/40 (0.00%)
Total execution time (ms): 2064

Total data time (ms): 868
Total train time (ms): 1111
Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 130.0 Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Total execution time (ms): 20956


Total data time (ms): 866
Total train time (ms): 1079
Testing Basic Nearest Neighbor with IG numfeatures: 250 with epsilon 130.0 Accuracy
Number correct: 520/560 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/40 (0.00%)
Total execution time (ms): 10143

Total data time (ms): 938
Total train time (ms): 1180
Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 50.0 Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Total execution time (ms): 20763



==============================================

Results:

Dev---
Testing Basic Nearest Neighbor with epsilon 37.0 Accuracy
Number correct: 140/142 (98.59%)
Total execution time (ms): 8705

Testing Basic Nearest Neighbor with epsilon 35.0 Accuracy
Number correct: 140/142 (98.59%)
Total execution time (ms): 8631

Testing Basic Nearest Neighbor with epsilon 39.0 Accuracy
Number correct: 140/142 (98.59%)
Precision: 0/0 (NaN%)
Recall: 0/2 (0.00%)
Total execution time (ms): 4422

Testing Basic Nearest Neighbor with IG with epsilon 39.0 Accuracy
Number correct: 140/142 (98.59%)
Precision: 0/0 (NaN%)
Recall: 0/2 (0.00%)
Total execution time (ms): 5050

Testing Basic Nearest Neighbor with IG numfeatures: 50 with epsilon 39.0 Accuracy
Number correct: 140/142 (98.59%)
Precision: 0/0 (NaN%)
Recall: 0/2 (0.00%)
Total execution time (ms): 679


Train---

Total data time (ms): 888
Total train time (ms): 1076
Testing Basic Nearest Neighbor with IG numfeatures: 50 with epsilon 39.0 Accuracy
Number correct: 560/568 (98.59%)
Precision: 0/0 (NaN%)
Recall: 0/8 (0.00%)
Total execution time (ms): 2306

Total data time (ms): 893
Total train time (ms): 1131
Testing Basic Nearest Neighbor with IG with epsilon 39.0 Accuracy
Number correct: 566/568 (99.65%)
Precision: 6/6 (100.00%)
Recall: 6/8 (75.00%)
Total execution time (ms): 21753

---- pre IG

Total data time (ms): 1018
Total train time (ms): 1063
Testing Basic Nearest Neighbor with epsilon 39.0 Accuracy
Number correct: 566/568 (99.65%)
Precision: 6/6 (100.00%)
Recall: 6/8 (75.00%)
Total execution time (ms): 17154

Total data time (ms): 902
Total train time (ms): 946
Testing Basic Nearest Neighbor with epsilon 500.0 Accuracy
Number correct: 560/568 (98.59%)
Total execution time (ms): 17220

Total data time (ms): 892
Total train time (ms): 938
Testing Basic Nearest Neighbor with epsilon 45.0 Accuracy
Number correct: 560/568 (98.59%)
Total execution time (ms): 17236

Total data time (ms): 917
Total train time (ms): 962
Testing Basic Nearest Neighbor with epsilon 40.0 Accuracy
Number correct: 561/568 (98.77%)
Total execution time (ms): 17481

Total data time (ms): 887
Total train time (ms): 932
Testing Basic Nearest Neighbor with epsilon 39.0 Accuracy
Number correct: 566/568 (99.65%)
Total execution time (ms): 17501

Total data time (ms): 904
Total train time (ms): 949
Testing Basic Nearest Neighbor with epsilon 38.0 Accuracy
Number correct: 567/568 (99.82%)
Total execution time (ms): 17203

Total data time (ms): 901
Total train time (ms): 948
Testing Basic Nearest Neighbor with epsilon 37.0 Accuracy
Number correct: 568/568 (100.00%)
Total execution time (ms): 17296
