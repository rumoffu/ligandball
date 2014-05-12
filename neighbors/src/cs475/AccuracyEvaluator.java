package cs475;

import java.io.IOException;
import java.util.List;

public class AccuracyEvaluator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double evaluateAccuracy(List<Instance> instances, Predictor predictor, PredictionsWriter writer) throws IOException {
		int numTested = 0;
		int numCorrect = 0;
		Label prediction;
		for(Instance element : instances){
			prediction = predictor.predict(element);
			writer.writePrediction(prediction);
			numTested++;
			if( element.getLabel() != null && prediction != null){
				if (prediction.toString().equals(element.getLabel().toString())){
					numCorrect++;
				}
			}
		}
		System.out.printf("Number correct: %s/%s (%.2f%%)\n", numCorrect, numTested, 100.0*numCorrect / numTested);
		return (double) numCorrect / numTested;
	}
	
	public double evaluateAccuracyOnly(List<Instance> instances, Predictor predictor) {
		int numTested = 0;
		int numCorrect = 0;
		Label prediction;
		for(Instance element : instances){
			prediction = predictor.predict(element);
			numTested++;
			if( element.getLabel() != null && prediction != null){
				if (prediction.toString().equals(element.getLabel().toString())){
					numCorrect++;
				}
			}
		}
		System.out.printf("Number correct: %s/%s (%.2f%%)\n", numCorrect, numTested, 100.0*numCorrect / numTested);
		return (double) numCorrect / numTested;
	}
	
	/**
	 * Evaluates Precision and Recall
	 * @param instances
	 * @param predictor
	 * @return
	 */
	public double evaluatePR(List<Instance> instances, Predictor predictor){
		int numTested = 0;
		int numCorrect = 0;
		
		int numOnes = 0;
		int numTrueOnes = 0;
		int numCorrectOnes = 0;
		
		Label prediction;
		for(Instance element : instances){
			prediction = predictor.predict(element);
			numTested++;
			if( element.getLabel() != null && prediction != null){
//				System.out.println(prediction.toString());
				if (prediction.toString().equals(element.getLabel().toString())){
					numCorrect++;
				}
				if (element.getLabel().toString().equals("1")) { //truly a 1
					numTrueOnes++;
					if (prediction.toString().equals("1")) { // correct 1 predicted
						numCorrectOnes++;
					}
				}
				if (prediction.toString().equals("1")) { //1 is predicted
					numOnes++;
				}
			}
		}
		System.out.printf("Number correct: %s/%s (%.2f%%)\n", numCorrect, numTested, 100.0*numCorrect / numTested);
		System.out.printf("Precision: %s/%s (%.2f%%)\n", numCorrectOnes, numOnes, 100.0*numCorrectOnes / numOnes);
		System.out.printf("Recall: %s/%s (%.2f%%)\n", numCorrectOnes, numTrueOnes, 100.0*numCorrectOnes / numTrueOnes);
		return (double) numCorrect / numTested;
	}

}
