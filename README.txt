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
