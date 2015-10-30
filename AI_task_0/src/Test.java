import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test class to check Neuron in action.
 * 
 * @author vyder
 *
 */
public class Test {
	
	// when TRUE, additional data is shown when computing weights
	final static boolean DEBUG = false;

	
	public static void main(String[] args) {
		
		// create neuron
		Neuron n = new Neuron();
		
		NeuronTrenningList ntl = new NeuronTrenningList();
		n.setRandomWeights(ntl.getTreningList().get(0));
		long iterations = 0l;
		boolean neuronLearned = false;
		ArrayList<Double> errors = new ArrayList<>();
		
		// learning
		while (!neuronLearned) {
			iterations++;
			errors.clear();
			for (TreningPattern pattern : ntl.getTreningList()) {
				errors.add(Math.abs(n.backwardErrorPropagation(pattern, Constants.EPSILON)));
			}
			neuronLearned = true;
			for (double e : errors) {
				if (e > Constants.ERROR_VALUE){
					neuronLearned = false;
				}
			}
		}
		
		// neuron learned
		System.out.println();
		System.out.println("needs " + iterations + " iterations to reduce error value to " + errors.toString());
		System.out.println("weights: " + n.getWeights().toString());
		System.out.println();
	}

}
