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

CBallTrain
-mode train -algorithm ball -model_file models/ball.model -data data/ball.train -epsilon 35

CBallTest
-mode test -model_file models/ball.model -data data/ball.dev -predictions_file models/dev.ball.predictions

KmeansTrain
-mode train -algorithm kmeansball -model_file models/kmeans.ball.model -data data/ball.train -epsilon 35

KmeansTest
-mode test -model_file models/kmeans.ball.model -data data/ball.dev -predictions_file models/kmeans.dev.ball.predictions


==============================================

KMeans Train
---------------
Cluster lambda: 24.28859812275311
Num EM Iterations for clustering: 10
Number of mews: 44
Testing K Means Nearest Neighbor with IG numfeatures: 500 with epsilon 35.0 average distance : NaN Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested K Means Nearest Neighbor with IG numfeatures: 500 with epsilon 35.0 average distance : 31.478136034861638 Accuracy
Total execution time (ms): 18799

Cluster lambda: 24.28859812275311
Num EM Iterations for clustering: 10
Number of mews: 44
Testing K Means Nearest Neighbor with IG numfeatures: 500 with epsilon 30.0 average distance : NaN Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested K Means Nearest Neighbor with IG numfeatures: 500 with epsilon 30.0 average distance : 31.478136034861638 Accuracy
Total execution time (ms): 18763

Cluster lambda: 24.28859812275311
Num EM Iterations for clustering: 10
Number of mews: 44
Testing K Means Nearest Neighbor with IG numfeatures: 500 with epsilon 25.0 average distance : NaN Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested K Means Nearest Neighbor with IG numfeatures: 500 with epsilon 25.0 average distance : 31.478136034861638 Accuracy
Total execution time (ms): 18973

Cluster lambda: 7.68699626243977
Num EM Iterations for clustering: 10
Number of mews: 149
Testing K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 35.0 average distance : NaN Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 35.0 average distance : 9.933489689215703 Accuracy
Total execution time (ms): 1949

Cluster lambda: 7.68699626243977
Num EM Iterations for clustering: 10
Number of mews: 149
Testing K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 10.0 average distance : NaN Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 10.0 average distance : 9.933489689215703 Accuracy
Total execution time (ms): 1981

Cluster lambda: 7.68699626243977
Num EM Iterations for clustering: 10
Number of mews: 149
Testing K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 5.0 average distance : NaN Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 5.0 average distance : 9.933489689215703 Accuracy
Total execution time (ms): 2003

Cluster lambda: 7.68699626243977
Num EM Iterations for clustering: 10
Number of mews: 149
Testing K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 25.0 average distance : NaN Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 25.0 average distance : 9.933489689215703 Accuracy
Total execution time (ms): 1963

Cluster lambda: 17.180123325061587
Num EM Iterations for clustering: 10
Number of mews: 57
Testing K Means Nearest Neighbor with IG numfeatures: 250 with epsilon 25.0 average distance : NaN Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested K Means Nearest Neighbor with IG numfeatures: 250 with epsilon 25.0 average distance : 22.18518020695555 Accuracy
Total execution time (ms): 9153




KMeans Dev
----------------
Testing K Means Nearest Neighbor with IG numfeatures: 500 with epsilon 35.0 average distance : 31.478136034861638 Accuracy
Number correct: 140/140 (100.00%)
Precision: 10/10 (100.00%)
Recall: 10/10 (100.00%)
Total execution time (ms): 4291

Testing K Means Nearest Neighbor with IG numfeatures: 500 with epsilon 30.0 average distance : 31.478136034861638 Accuracy
Number correct: 135/140 (96.43%)
Precision: 5/5 (100.00%)
Recall: 5/10 (50.00%)
Total execution time (ms): 4389

Testing K Means Nearest Neighbor with IG numfeatures: 500 with epsilon 25.0 average distance : 31.478136034861638 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 4245

Testing K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 35.0 average distance : 9.933489689215703 Accuracy
Number correct: 140/140 (100.00%)
Precision: 10/10 (100.00%)
Recall: 10/10 (100.00%)
Total execution time (ms): 630

Testing K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 25.0 average distance : 9.933489689215703 Accuracy
Number correct: 140/140 (100.00%)
Precision: 10/10 (100.00%)
Recall: 10/10 (100.00%)
Total execution time (ms): 627

Testing K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 10.0 average distance : 9.933489689215703 Accuracy
Number correct: 132/140 (94.29%)
Precision: 2/2 (100.00%)
Recall: 2/10 (20.00%)
Total execution time (ms): 636

Testing K Means Nearest Neighbor with IG numfeatures: 50 with epsilon 5.0 average distance : 9.933489689215703 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 629

Testing K Means Nearest Neighbor with IG numfeatures: 250 with epsilon 25.0 average distance : 22.18518020695555 Accuracy
Number correct: 140/140 (100.00%)
Precision: 10/10 (100.00%)
Recall: 10/10 (100.00%)
Total execution time (ms): 1901

xxxxxxxxxxxxxxxxxxxxxxxxxxx

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 7.68 average distance : NaN Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 7.68 average distance : 34.589146438354916 Accuracy
Total execution time (ms): 20978

Testing Basic Nearest Neighbor with IG numfeatures: 500 with epsilon 7.68 average distance : 34.589146438354916 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 4889

Testing Basic Nearest Neighbor with IG numfeatures: 50 with epsilon 7.68 average distance : NaN Accuracy
Number correct: 560/560 (100.00%)
Precision: 40/40 (100.00%)
Recall: 40/40 (100.00%)
Tested Basic Nearest Neighbor with IG numfeatures: 50 with epsilon 7.68 average distance : 10.949857737729925 Accuracy
Total execution time (ms): 2429

Testing Basic Nearest Neighbor with IG numfeatures: 50 with epsilon 7.68 average distance : 10.949857737729925 Accuracy
Number correct: 130/140 (92.86%)
Precision: 0/0 (NaN%)
Recall: 0/10 (0.00%)
Total execution time (ms): 691



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
