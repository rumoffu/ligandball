/*
 * Kyle Wong, Tifany Yung
 * 14.5.11
 * Machine Learning
 * Final Project
 * Nearest Neighbors
 */
package cs475;

import sphere.SphereNearestNeighborPredictor;
import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;

public class Classify {
	static public LinkedList<Option> options = new LinkedList<Option>();
	final static long startTime = System.currentTimeMillis();
	public static void main(String[] args) throws IOException {
//		startTime = System.currentTimeMillis();
		// Parse the command line.
		String[] manditory_args = { "mode"};
		createCommandLineOptions();
		CommandLineUtilities.initCommandLineParameters(args, Classify.options, manditory_args);
	
		String mode = CommandLineUtilities.getOptionValue("mode");
		String data = CommandLineUtilities.getOptionValue("data");
		String predictions_file = CommandLineUtilities.getOptionValue("predictions_file");
		String algorithm = CommandLineUtilities.getOptionValue("algorithm");
		String model_file = CommandLineUtilities.getOptionValue("model_file");
		
		double eps = 50;
		if (CommandLineUtilities.hasArg("epsilon")){
			eps = Double.parseDouble(CommandLineUtilities.getOptionValue("epsilon"));
		}
		if (mode.equalsIgnoreCase("train")) {
			if (data == null || algorithm == null || model_file == null) {
				System.out.println("Train requires the following arguments: data, algorithm, model_file");
				System.exit(0);
			}
			// Load the training data.
			DataReader data_reader = new DataReader(data, true);
			List<Instance> instances = data_reader.readData();
			data_reader.close();
			final long dataTime = System.currentTimeMillis();
			System.out.println("Total data time (ms): " + (dataTime - startTime) );
			
			// Train the model.
			Predictor predictor = train(instances, algorithm, eps);
			saveObject(predictor, model_file);		
			
		} else if (mode.equalsIgnoreCase("test")) {
			if (data == null || predictions_file == null || model_file == null) {
				System.out.println("Train requires the following arguments: data, predictions_file, model_file");
				System.exit(0);
			}
			
			// Load the test data.
			DataReader data_reader = new DataReader(data, true);
			List<Instance> instances = data_reader.readData();
			data_reader.close();
			
			// Load the model.
			Predictor predictor = (Predictor)loadObject(model_file);
			evaluateAndSavePredictions(predictor, instances, predictions_file);
		} else {
			System.out.println("Requires mode argument.");
		}
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time (ms): " + (endTime - startTime) );
	}
	

	private static Predictor train(List<Instance> instances, String algorithm, double eps) {
		// TODO Train the model using "algorithm" on "data"
		// TODO Evaluate the model
		//AccuracyEvaluator evaluator = new AccuracyEvaluator();
		double accuracy;
		Predictor returnPredictor;
		if(algorithm.equalsIgnoreCase("even_odd")){
			EvenOddClassifier predictor = new EvenOddClassifier();
			predictor.train(instances);
			//System.out.printf("Testing %s Accuracy\n", predictor);
			//accuracy = evaluator.evaluateAccuracy(instances, predictor);
//			return (Predictor) predictor;
			returnPredictor = (Predictor) predictor;
		}
		else if(algorithm.equalsIgnoreCase("ball")){
			SphereNearestNeighborPredictor predictor = new SphereNearestNeighborPredictor(eps);
			predictor.train(instances);
			//System.out.printf("Testing %s Accuracy\n", predictor);
			//accuracy = evaluator.evaluateAccuracy(instances, predictor);
//			return (Predictor) predictor;
			returnPredictor = (Predictor) predictor;
		}
		else {
			returnPredictor = null;
		}
		
		final long trainTime = System.currentTimeMillis();
		System.out.println("Total train time (ms): " + (trainTime - startTime) );
		
		AccuracyEvaluator evaluator = new AccuracyEvaluator();
		System.out.printf("Testing %s Accuracy\n", returnPredictor);
//		accuracy = evaluator.evaluateAccuracy(instances, returnPredictor);

		accuracy = evaluator.evaluatePR(instances, returnPredictor);
		
		return returnPredictor;
	}

	private static void evaluateAndSavePredictions(Predictor predictor,
			List<Instance> instances, String predictions_file) throws IOException {
		PredictionsWriter writer = new PredictionsWriter(predictions_file);
		// TODO Evaluate the model if labels are available. 
		double accuracy;
		if(instances.get(0).getLabel() != null){
			AccuracyEvaluator evaluator = new AccuracyEvaluator();
			System.out.printf("Testing %s Accuracy\n", predictor);
//			accuracy = evaluator.evaluateWriteAccuracy(instances, predictor, writer);
			accuracy = evaluator.evaluateWritePR(instances, predictor, writer);
			
		}
		else{ //courtesy information message
			System.out.println("Test data therefore accuracy cannot be calculated.");
			for (Instance instance : instances) {
				Label label = predictor.predict(instance);
				writer.writePrediction(label);
			}
		}
		
		writer.close();
		
	}

	public static void saveObject(Object object, String file_name) {
		try {
			ObjectOutputStream oos =
				new ObjectOutputStream(new BufferedOutputStream(
						new FileOutputStream(new File(file_name))));
			oos.writeObject(object);
			oos.close();
		}
		catch (IOException e) {
			System.err.println("Exception writing file " + file_name + ": " + e);
		}
	}

	/**
	 * Load a single object from a filename. 
	 * @param file_name
	 * @return
	 */
	public static Object loadObject(String file_name) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(file_name))));
			Object object = ois.readObject();
			ois.close();
			return object;
		} catch (IOException e) {
			System.err.println("Error loading: " + file_name);
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading: " + file_name);
		}
		return null;
	}
	
	public static void registerOption(String option_name, String arg_name, boolean has_arg, String description) {
		OptionBuilder.withArgName(arg_name);
		OptionBuilder.hasArg(has_arg);
		OptionBuilder.withDescription(description);
		Option option = OptionBuilder.create(option_name);
		
		Classify.options.add(option);		
	}
	
	private static void createCommandLineOptions() {
		registerOption("data", "String", true, "The data to use.");
		registerOption("mode", "String", true, "Operating mode: train or test.");
		registerOption("predictions_file", "String", true, "The predictions file to create.");
		registerOption("algorithm", "String", true, "The name of the algorithm for training.");
		registerOption("model_file", "String", true, "The name of the model file to create/load.");
		registerOption("epsilon", "double", true, "The value of epsilon for epsilon nearest neighbors.");
		// Other options will be added here.
	}
}
