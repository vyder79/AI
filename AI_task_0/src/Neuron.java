import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * @author vyder
 *
 */
public class Neuron {
	
	ArrayList<Double> xList = new ArrayList<>();
	ArrayList<Double> weights = new ArrayList<>();
	ActivationFunction aFunction = new ActivationFunction();
	double z = 0;
	
	public Neuron(){
		this.xList = new ArrayList<>();
		this.weights = new ArrayList<>();
		ActivationFunction aFunction = new ActivationFunction();
		this.z = 0;
	}
	
	public Neuron(ArrayList<Double> weights_list){
		this.weights = weights_list;	
	}
	
	// learning neuron
	public double learn(ArrayList<Double> inputs, double output){
		
		for (int i = 0; i < inputs.size(); i++) {
			z += inputs.get(i) * this.weights.get(i);
		}

		return aFunction.func(z);
	}
	
	// learned neuron
	public double activate(ArrayList<Double> inputs){
		
		for (int i = 0; i < inputs.size(); i++) {
			z += inputs.get(i) * this.weights.get(i);
		}

		return aFunction.func(z);
	}
	
	// set random weights at the start of learning
	public void setRandomWeights(ArrayList<Double> inputData, double output) {
		
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

	
	// getters and setters
	public ArrayList<Double> getWeights() {
		return weights;
	}

	public void setWeights(ArrayList<Double> weights) {
		this.weights = weights;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public ActivationFunction getaFunction() {
		return aFunction;
	}

	public void setaFunction(ActivationFunction aFunction) {
		this.aFunction = aFunction;
	}

	public ArrayList<Double> getxList() {
		return xList;
	}

	public void setxList(ArrayList<Double> xList) {
		this.xList = xList;
	}

}
