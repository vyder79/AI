import java.util.ArrayList;
import java.util.Random;

/**
 * @author vyder
 *
 */
public class Neuron {
	/**  */
	ArrayList<Double> weights = new ArrayList<>();
	ActivationFunction aFunction = new ActivationFunction();
	
	public Neuron(){
		this.weights = new ArrayList<>();
		this.aFunction = new ActivationFunction();
	}
	
	public Neuron(ArrayList<Double> weights_list){
		this.weights = weights_list;	
	}
	
	// learning neuron
	public double learn(ArrayList<Double> inputs, double output){
		double z = 0;
		for (int i = 0; i < inputs.size(); i++) {
			z += inputs.get(i) * this.weights.get(i);
		}

		return aFunction.func(z);
	}
	
	// learned neuron
	public double activate(ArrayList<Double> inputs){
		double z = 0;
		for (int i = 0; i < inputs.size(); i++) {
			z += inputs.get(i) * this.weights.get(i);
		}

		return aFunction.func(z);
	}
	
	// set random weights at the start of learning
	public void setRandomWeights(TreningPattern tp) {
		setRandomWeights(tp.getInputList(), tp.getOutput());
	}
	
	private void setRandomWeights(ArrayList<Double> inputData, double output) {
		
		double weightsSum = 0d;
		int count = inputData.size() - 1;
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			this.weights.add(r.nextDouble());
			if (Test.DEBUG) {
				System.out.println("weight " + i + ": " + this.weights.get(i));
			}
		}
		for (int i = 0; i < count; i++) {
			weightsSum += inputData.get(i) * this.weights.get(i);
		}
		this.weights.add((output - weightsSum) / inputData.get(count));
	}
	
	// learning using backward error propagation
	public double backwardErrorPropagation(TreningPattern tp, double epsilon) {
		return backwardErrorPropagation(tp.getInputList(), tp.getOutput(), epsilon);
	}
	
	private double backwardErrorPropagation(ArrayList<Double> inputs, double output, double epsilon) {

		double errorValue = output - activate(inputs);
		ArrayList<Double> newWeights = new ArrayList<>();

		for (int i = 0; i < this.weights.size(); i++) {
			newWeights.add(this.weights.get(i) + (epsilon * errorValue) * inputs.get(i));
		}
		
		this.weights.clear();
		this.weights = newWeights;
		
		if (Test.DEBUG) {
			System.out.println("errorValue " + Math.abs(errorValue));
		}
		
		return errorValue;
	}

	
	// getters and setters
	public ArrayList<Double> getWeights() {
		return weights;
	}

	public void setWeights(ArrayList<Double> weights) {
		this.weights = weights;
	}
	
	public ActivationFunction getaFunction() {
		return aFunction;
	}

	public void setaFunction(ActivationFunction aFunction) {
		this.aFunction = aFunction;
	}

}
