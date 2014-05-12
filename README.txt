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


Train---

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
