neighbors
==========

Upon request, a link to the github repository containing the code is available.


Eclipse command arguments for running the code (use Classify.java):

for SphereNearestNeighborPredictor.java:

For ligand data
to train:
-mode train -algorithm ball -model_file models/lig.ball.model -data data/ligand.train -epsilon 37 -num_features_to_select 500

to test development data:
-mode test -model_file models/lig.ball.model -data data/ligand.dev -predictions_file models/lig.dev.ball.predictions

For ball data
to train:
-mode train -algorithm ball -model_file models/ball.model -data data/ball.train -epsilon 35 -num_features_to_select 50

to test development data:
-mode test -model_file models/ball.model -data data/ball.dev -predictions_file models/dev.ball.predictions

=================================================================================================================================================

for KMeansSpherePredictor.java

to train:
-mode train -algorithm kmeansball -model_file models/kmeans.ball.model -data data/ball.train -epsilon 35 -num_features_to_select 50

to test development data:
-mode test -model_file models/kmeans.ball.model -data data/ball.dev -predictions_file models/kmeans.dev.ball.predictions


