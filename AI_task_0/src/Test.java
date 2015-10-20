import java.util.ArrayList;

public class Test {
	
	final static boolean DEBUG = false;

	public static void main(String[] args) {
		
		Neuron n = new Neuron();
		
		ArrayList<Double> inputs = new ArrayList<>();
		inputs.add(0.1);
		inputs.add(0.3);
		inputs.add(0.7);
		
		double output = 0.45;
		
		n.setRandomWeights(inputs, output);
		
		System.out.println("inputs: " + inputs.toString());
		System.out.println("weights: "+ n.getWeights().toString());
		System.out.println("output: " + n.activate(inputs));

	}

}
