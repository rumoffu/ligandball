/*
 * Kyle Wong, Tifany Yung
 * 14.5.11
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

@SuppressWarnings("serial")
public class KMeansSpherePredictor extends Predictor{
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

	private double cluster_lambda;
	private int clustering_training_iterations;
	private ArrayList<ArrayList<Integer>> rnk = new ArrayList<ArrayList<Integer>>(); //track which instance's are in a cluster by id
	private ArrayList<double[]> mewk = new ArrayList<double[]>(); //track the mew - centers of each cluster (x-dimensional)

	
	/**
	 * @param args
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

	public KMeansSpherePredictor(double eps, int input_num_features, double cluster_lambda, int clustering_training_iterations) {
		this.eps = eps;

		this.num_features_to_select = input_num_features;
		this.distsum = 0;
		this.numpred = 0;
		this.cluster_lambda = cluster_lambda;
		this.clustering_training_iterations = clustering_training_iterations;
//		this.clustering_training_iterations = clustering_training_iterations;
		
	}
	
	public String toString() {
		return "K Means Nearest Neighbor with IG numfeatures: " + String.valueOf(num_features_to_select) + " with epsilon " + String.valueOf(this.eps)
				+ " average distance : " + String.valueOf(this.distsum / this.numpred);
//		return "K Means Nearest Neighbor with IG numfeatures: " + String.valueOf(num_features_to_select) + " with epsilon " + String.valueOf(this.eps)
//				+ " average distance : " + String.valueOf(this.distsum / this.numpred);
	
	}
	
	public void train(List<Instance> instances) {

		// set num features to select based on input and max feature key
		selectFeatures(instances);
		double[] xi = new double[this.num_features_to_select];

//		System.out.println("num features: " + this.num_features_to_select);
//		this.number_of_features = Util.getMaxFeatureKey(instances);
		
		//add all points with features organized by IG and save their labels
		this.labels = new int[instances.size()];
		for(int i = 0; i < instances.size(); i++) { // for each instance
//			xi = instances.get(i).getFeatureVector().getAlld(this.num_features_to_select);
			double[] all = new double[this.num_features_to_select];
			for (int j = 0; j < this.num_features_to_select; j++) {
				all[j] = instances.get(i).getFeatureVector().get(this.bestgains[j]);
			}
			xi = all;
			pts.add(xi);
			this.labels[i] = Integer.parseInt(instances.get(i).getLabel().toString());
		}
		
		// Calculate clusters for the points
		
		// Initialize prototype vector to the mean of all instances
//		this.num_features_to_select = Util.getMaxFeatureKey(instances);
		double[] sum = new double[this.num_features_to_select];
		for(int i = 0; i < this.num_features_to_select; i++){
			sum[i] = 0.0;
		}		
		for(Instance e : instances){
			xi = e.getFeatureVector().getAlld(this.num_features_to_select);
			sum = Util.vectorAdd(sum, xi);
		}
		mewk.add(Util.scalarMultiply(1.0/instances.size(), sum));
		
		// Initialize rnk
		ArrayList<Integer> newCluster = new ArrayList<Integer>();
		rnk.add(newCluster);
		
		// Initialize Lambda Value to the average
		if(this.cluster_lambda == 0.0){
			double lambdasum = 0.0;
			for(Instance e : instances){
				xi = e.getFeatureVector().getAlld(this.num_features_to_select);
				lambdasum += Util.euclideanDistance(xi, mewk.get(0));
			}
			this.cluster_lambda = 1.0/instances.size() * lambdasum;
		}
		System.out.println("Cluster lambda: " + this.cluster_lambda);
		System.out.println("Num EM Iterations for clustering: " + this.clustering_training_iterations);
		// Perform training iterations
		for(int i = 0; i < this.clustering_training_iterations; i++){
			Estep(instances);
			Mstep(instances);
		}
		System.out.println("Number of mews: " + mewk.size());
	}
	
	private void Estep(List<Instance> instances){
		double minDist = Double.POSITIVE_INFINITY;
		double dist;
		double[] xi;
		int minCluster = -1;
		// Reset old cluster assignments
		for(ArrayList<Integer> ra : rnk){
			ra.clear();
		}
		// For each instance, assign to cluster
		for(int j = 0; j < instances.size(); j++){
			xi = instances.get(j).getFeatureVector().getAlld(this.num_features_to_select);
			minDist = Double.POSITIVE_INFINITY;
			// get the minimum distance cluster k that the instance belongs to 
			for(int k = 0; k < this.mewk.size(); k++){
				dist = Util.euclideanDistance(xi, mewk.get(k));
				if(dist < minDist){//defaults to break ties by assigning to lowest cluster number
					minDist = dist;
					minCluster = k;
				}
			}
			if(minDist <= this.cluster_lambda){
				// fits in a current cluster, so get the cluster's arraylist and add the instance id to it
				rnk.get(minCluster).add(j);
			}
			else{ //bigger than lambda so we make a new cluster and make a new mew_k
				ArrayList<Integer> newCluster = new ArrayList<Integer>();
				newCluster.add(j);
				rnk.add(newCluster);
				mewk.add(xi);
			}
		}
	}
	
	private void Mstep(List<Instance> instances){
		double[] xi;
		double[] sum = new double[this.num_features_to_select];
		
		for(int k = 0; k < mewk.size(); k++){ // for each mew
			for(int i = 0; i < this.num_features_to_select; i++){
				sum[i] = 0.0;
			}
			ArrayList<Integer> cluster = rnk.get(k);
			for(int n : cluster){ //for each instance in mew
				xi = instances.get(n).getFeatureVector().getAlld(this.num_features_to_select);
				sum = Util.vectorAdd(sum, xi);
			}
			if(cluster.size() == 0){ //if it is empty, set it to 0's
				sum = new double[this.num_features_to_select];
				for(int i = 0; i < this.num_features_to_select; i++){
					sum[i] = 0.0;
				}
				mewk.set(k, sum);
			}
			else{//update to 1 over n times the sum of each instance in it
				mewk.set(k, Util.scalarMultiply(1.0/cluster.size(), sum));
			}
		}	
	}
	
	public Label predict(Instance instance) {
		//find the minimum distance cluster
		double minDist = Double.POSITIVE_INFINITY;
		double dist;
		double[] xi = instance.getFeatureVector().getAlld(this.num_features_to_select);
		int minCluster = -1;
		for(int k = 0; k < this.mewk.size(); k++){ //compare to each mewk
			dist = Util.euclideanDistance(xi, mewk.get(k));
			if(dist < minDist){ //defaults to break ties by assigning to lowest cluster number
				minDist = dist;
				minCluster = k;
			}
		}
		
		// for each point in minimum distance cluster, check if distance < epsilon
		int ballcount = 0;
		int positivecount = 0;
		
		for(int k : this.rnk.get(minCluster)) {
			double[] all = new double[this.num_features_to_select];
			for (int j = 0; j < this.num_features_to_select; j++) {
				all[j] = instance.getFeatureVector().get(this.bestgains[j]);
			}
			xi = all;
			dist = Util.euclideanDistance(xi, pts.get(k));
			this.distsum += dist;
			this.numpred++;
			if(dist < this.eps) {
				ballcount++;
				positivecount += labels[k]; // add 1's, ignore 0's
			}
		}
		if (positivecount > ballcount/2) { //clear positive majority
			return new ClassificationLabel(1);
		}
		else { //no majority is most likely negative
			return new ClassificationLabel(0);
		}
		
	}
	
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
		
		// ???? remove this?
		if(maxkey < num_features_to_select){ //KTW was less than..?
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
			pyixj1 = pyx1 / instances.size();//log of 0 is NaN - might be a problem when lacking train data
			if (pyixj0 == 0 || pyixj1 == 0) {
				this.infogains[i] = 0.0;
			}
			else {
				int factor = 1;
				this.infogains[i] = factor*pyixj0*Math.log(pyixj0 / pxj) + factor* pyixj1*Math.log(pyixj1 / pxj);
//			this.infogains[i] = -1*pyixj0*Math.log(pyixj0 / pxj) + -1* pyixj1*Math.log(pyixj1 / pxj);
			}
			
//			double temp = this.infogains[i]; 
//			System.out.printf("%s %s\n", i, temp);
		}
//		for(int k = 0; k < infogains.length; k++) System.out.printf("infogains %s %s\n", k, infogains[k]);

		// select the features with best IG and save their id
		this.bestgains = new int[this.num_features_to_select];
		double[] bestvalues = new double[this.num_features_to_select];
		for(int j = 0; j < num_features_to_select; j++){
			this.weights[j] = 0.0;
			double bestig = Double.NEGATIVE_INFINITY;
			int bestid = 0;
			for(int i = 0; i < maxkey; i++){ //KTW should be maxkey? was num_features_to_select
				if(bestig < this.infogains[i]){ // was <=, but it seems to skip some
					bestig = this.infogains[i];
					bestid = i;
				}
			}
			this.bestgains[j] = bestid+1; //features are 1 based, not 0 based
			bestvalues[j] = bestig; // save the best value for checking
			this.infogains[bestid] = Double.NEGATIVE_INFINITY;
//			System.out.println("bestid: "+bestgains[j]+" bestvalues: " + bestvalues[j]); //verified speech.train
		}
		Arrays.sort(bestgains); // to track weight with feature number ordering //KTW
//		for(int j = 0; j < num_features_to_select; j++) System.out.println("bestid: "+bestgains[j]+" bestvalues: " + bestvalues[j]);
	}
}
