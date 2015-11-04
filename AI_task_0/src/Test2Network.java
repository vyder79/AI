import java.util.ArrayList;

public class Test2Network {

	public static void main(String[] args) {
		
		/** first input layer */
		ArrayList<Neuron> neuronsInFirstLayer = new ArrayList<>();
		ArrayList<Double> weightInFirstLayer = new ArrayList<>();
		weightInFirstLayer.add(1.0);
		
		for (int i=0; i<8; i++){
			neuronsInFirstLayer.add(new Neuron(weightInFirstLayer, "neuron_" + i));
		}
		
		SingleLayer firstInputLayer = new SingleLayer(neuronsInFirstLayer, "input layer");
		firstInputLayer.toStringOut();
		
		/** second output layer */
		ArrayList<Neuron> neuronsInSecondLayer = new ArrayList<>();
		
		ArrayList<Double> weights = new ArrayList<>();
		weights.add(0.23);
		weights.add(0.13);
		weights.add(0.27);
		weights.add(0.93);
		weights.add(0.58);
		neuronsInSecondLayer.add(new Neuron(weights, "letter a"));
		
		weights.clear();
		weights.add(0.29);
		weights.add(0.52);
		weights.add(0.22);
		weights.add(0.33);
		weights.add(0.18);
		neuronsInSecondLayer.add(new Neuron(weights, "letter b"));
		
		weights.clear();
		weights.add(0.73);
		weights.add(0.33);
		weights.add(0.93);
		weights.add(0.45);
		weights.add(0.81);
		neuronsInSecondLayer.add(new Neuron(weights, "letter c"));
		
		SingleLayer secondOutputLayer = new SingleLayer(neuronsInSecondLayer, "second Layer");
		secondOutputLayer.toStringOut();
	}

}
