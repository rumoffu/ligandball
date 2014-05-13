/*
 * Kyle Wong, Tifany Yung
 * 14.5.12
 * Machine Learning
 * Final Project
 * Nearest Neighbors
 */
package sphere;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import cs475.ClassificationLabel;
import cs475.Instance;
import cs475.Label;
import cs475.Predictor;
import cs475.Util;

/**
 * This class is a label predictor that uses the epsilon-sphere nearest neighbors algorithm.
 */
@SuppressWarnings("serial")
public class SphereNearestNeighborPredictor extends Predictor{
	private double eps; // default epsilon value
	
	private ArrayList<double[]> pts = new ArrayList<double[]>(); //track training pts
	private int[] labels; // track training point labels
	
	private final int UNINITIALIZED = -1;
	private int num_features_to_select = UNINITIALIZED;
	private Double[] infogains;
	private Double[] weights;
	private int[] bestgains;
	
	private double distsum;
	private int numpred;
	
	/**
	 * This main method is a test driver for the method in cs475.Util that calculates Euclidean distance.
	 * @param args This method does not require any command-line arguments.
	 */
	public static void main(String[] args) {
		Double[] a = new Double[2];
		Double[] b = new Double[2];
		a[0] = 3.0;
		a[1] = 5.0;
		b[0] = 6.0;
		b[1] = 1.0;
		double c = Util.euclideanDistance(a, b);
		System.out.println("euclidean distance expected 5: " + c);
	}

	/**
	 * This method creates an instance of a label predictor that uses the epsilon-sphere nearest neighbors algorithm.
	 * @param eps The value of epsilon to be used, the distance around a test point within which all data points should be used.
	 * @param input_num_features The number of features in an instance.
	 */
	public SphereNearestNeighborPredictor(double eps, int input_num_features) {
		this.eps = eps;

		this.num_features_to_select = input_num_features;
		this.distsum = 0;
		this.numpred = 0;
	}
	
	/**
	 * This method returns as String basic information about the epsilon-sphere nearest neighbor label predictor.
	 * @return The number of features selected via information gain to be used, the epsilon value, and the average
	 * distance between two points in the given dataset.
	 */
	public String toString() {
		return "Basic Nearest Neighbor with IG numfeatures: " + String.valueOf(num_features_to_select) + " with epsilon " + String.valueOf(this.eps)
				+ " average distance : " + String.valueOf(this.distsum / this.numpred);
	}
	
	/**
	 * This method trains the epsilon-sphere nearest neighbors algorithm.
	 * Training involves reading in the data points from the training set, which includes each instance and the label it belongs to.
	 * @param instances The training data points to use.
	 */
	public void train(List<Instance> instances) {

		selectFeatures(instances);
		double[] xi = new double[this.num_features_to_select];
		
		this.labels = new int[instances.size()];
		for(int i = 0; i < instances.size(); i++) {
			double[] all = new double[this.num_features_to_select];
			for (int j = 0; j < this.num_features_to_select; j++) {
				all[j] = instances.get(i).getFeatureVector().get(this.bestgains[j]);
			}
			xi = all;
			pts.add(xi);
			this.labels[i] = Integer.parseInt(instances.get(i).getLabel().toString());
		}
	}
	
	/**
	 * This method predicts the label of an instance using the epsilon-sphere nearest neighbor algorithm.
	 * Prediction involves finding the majority label of all points within a Euclidean distance of epsilon.
	 * from the test point and assigning the test point that label.
	 * @param instance The test point whose label is to be predicted.
	 * @return The label of the test point.
	 */
	public Label predict(Instance instance) {
		double dist;
		double[] xi = new double[this.num_features_to_select];
		int ballcount = 0;
		int positivecount = 0;
		for(int k = 0; k < this.pts.size(); k++) { //for each training point 
			double[] all = new double[this.num_features_to_select];
			for (int j = 0; j < this.num_features_to_select; j++) {
				all[j] = instance.getFeatureVector().get(this.bestgains[j]);
			}
			xi = all;
			dist = Util.euclideanDistance(xi, pts.get(k));
			this.distsum += dist;
			this.numpred++;
			if(dist < this.eps){ // within epsilon ball radius
				ballcount++;
				positivecount += labels[k]; // add the 1's, ignore 0's
			}
		}
		if (positivecount > ballcount/2) { //clear positive majority
			return new ClassificationLabel(1);
		}
		else { //no majority is most likely negative
			return new ClassificationLabel(0);
		}
	}
	
	/**
	 * This method selects the best num_features_to_select features to use based on information gain,
	 * where num_features_to_select was inputed via command-line argument.
	 * @param instances The training data points.
	 */
	private void selectFeatures(List<Instance> instances){

		Double thresh_sum;
		Double threshold;
		double px, pyx0, pyx1;
		double pxj, pyixj0, pyixj1;
		
		// if uninitialized, just use all features
		int maxkey = Util.getMaxFeatureKey(instances);
		if(num_features_to_select == UNINITIALIZED){
			num_features_to_select = maxkey;
		}
		
		if(maxkey < num_features_to_select){
			maxkey = num_features_to_select;
		}
		
		//initialize IG to 0 for each 
		this.infogains = new Double[maxkey];
		this.weights = new Double[num_features_to_select];
		for(int i = 0; i < maxkey; i++){
			this.infogains[i] = null;
		}
		
		for(int i = 0; i < maxkey; i++){ //for each feature	
			// set the threshold to the mean of all the instances
			thresh_sum = 0.0;
			px = 0;
			pyx0 = 0;
			pyx1 = 0;
			for(Instance inst : instances){
				thresh_sum += inst.getFeatureVector().get(i+1);
			}
			threshold = thresh_sum / instances.size();
			
			//count 0's and 1's above threshold
			for(Instance inst: instances){
				if(inst.getFeatureVector().get(i+1) <= threshold){
					px++;
					if(inst.getLabel().toString().equals("0")){
						pyx0++;
					}
					else if(inst.getLabel().toString().equals("1")){
						pyx1++;
					}
				}
			}
			
			// calculate IG for this feature
			pxj = px / instances.size();
			pyixj0 = pyx0 / instances.size();
			pyixj1 = pyx1 / instances.size(); //log of 0 is NaN - might be a problem when lacking train data
			if (pyixj0 == 0 || pyixj1 == 0) {
				this.infogains[i] = 0.0;
			}
			else {
				int factor = 1;
				this.infogains[i] = factor*pyixj0*Math.log(pyixj0 / pxj) + factor* pyixj1*Math.log(pyixj1 / pxj);
			}
		}
		
		// select the features with best IG and save their id
		this.bestgains = new int[this.num_features_to_select];
		double[] bestvalues = new double[this.num_features_to_select];
		for(int j = 0; j < num_features_to_select; j++){
			this.weights[j] = 0.0;
			double bestig = Double.NEGATIVE_INFINITY;
			int bestid = 0;
			for(int i = 0; i < maxkey; i++){ // was num_features_to_select
				if(bestig < this.infogains[i]){ // was <=, but it seems to skip some
					bestig = this.infogains[i];
					bestid = i;
				}
			}
			this.bestgains[j] = bestid+1; //features are 1 based, not 0 based
			bestvalues[j] = bestig; // save the best value for checking
			this.infogains[bestid] = Double.NEGATIVE_INFINITY;
		}
		Arrays.sort(bestgains); // to track weight with feature number ordering //KTW
	}
}

