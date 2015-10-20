import java.util.ArrayList;

public class Test {
	
	final static boolean DEBUG = false;

	public static void main(String[] args) {
		
		Neuron n = new Neuron();
		
		ArrayList<Double> inputs = new ArrayList<>();
		inputs.add(0.10001);
		inputs.add(0.36754);
		inputs.add(0.00567);
		inputs.add(0.32009);
		TreningPattern tp = new TreningPattern(inputs, 0.40009);
		
		ArrayList<Double> inputs2 = new ArrayList<>();
		inputs2.add(0.310751);
		inputs2.add(0.354003);
		inputs2.add(0.079987);
		inputs2.add(0.002009);
		TreningPattern tp2 = new TreningPattern(inputs2, 0.1411111);
		
		n.setRandomWeights(tp);
		
		System.out.println("initial weights: "+ n.getWeights().toString());
		System.out.println("inputs for 1 data: " + inputs.toString());
		System.out.println("output for 1 data: " + n.activate(inputs) + ", should be " + tp.getOutput());
		System.out.println("inputs for 2 data: " + inputs2.toString());
		System.out.println("output for 2 data: " + n.activate(inputs2) + ", should be " + tp2.getOutput());
		System.out.println("------------------------------------------------");
		
		long iterations = 0l;
		double errorValue = 1d;
		double errorValue2 = 1d;

		
		while (errorValue > Constants.ERROR_VALUE || errorValue2 > Constants.ERROR_VALUE ) {
			errorValue = Math.abs(n.backwardErrorPropagation(tp, Constants.EPSILON));
			errorValue2 = Math.abs(n.backwardErrorPropagation(tp2, Constants.EPSILON));
			iterations++;
		}
		System.out.println("needs " + iterations + " iterations to reduce error value to " 
				+ errorValue + " and " + errorValue2);
		System.out.println("weights: " + n.getWeights().toString());
	}

}
