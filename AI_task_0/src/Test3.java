import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test3 {

	public static void main(String[] args) throws IOException {
		ReadFile rf = new ReadFile();
		
		//String file2 = "C:/Users/Mateusz/git/AI/AI_task_0/src/Letters/Alfabet.txt";
		String file2 = "C:/Users/vyder/git/AI/AI_task_0/src/Letters/Alfabet.txt";

		rf.readAllLetters(file2);		
		rf.read(rf.getAllLetters());
		
		/** utworzenie pierwszej warstwy neuronów */
		ArrayList<Neuron> neuronsInFirstLayer = new ArrayList<>();
		ArrayList<Double> weightInFirstLayer = new ArrayList<>();
		weightInFirstLayer.add(1.0);
		
		for (int i=0; i<26; i++){
			neuronsInFirstLayer.add(new Neuron(weightInFirstLayer, "neuron_" + i));
		}
		
		SingleLayer firstInputLayer = new SingleLayer(neuronsInFirstLayer, "input layer");
		firstInputLayer.toStringOut();
		
		/** second (output) layer */
		ArrayList<Neuron> neuronsInSecondLayer = new ArrayList<>();
		
		/** 
		 * przepisanie liter na wektory wejœciowe oraz normalizacja 
		 * (zamiast na sztywno "26" mo¿na by jakoœ inaczej podawaæ liczbê wzorców)
		 */
		for(int i = 0; i < 26; i++){
			ArrayList<Integer> ltr = new ArrayList<>(); // tablica litery zero-jedynkowa
			ArrayList<Double> ltrNormalized = new ArrayList<>(); // tablica litery jako znormalizowane double
			ltr.addAll(rf.getInputArray().get(i));
			int ones = 0;
			
			// policzenie jedynek w literze
			for (Integer l : ltr){
				if (l == 1) {
					ones++;
				}
			}
			System.out.println(ltr + " jedynki:" + ones);
			
			// zamiana jedynek na znormalizowan¹ wartoœæ
			for (Integer l : ltr){
				if (l == 1) {
					ltrNormalized.add(1/Math.sqrt(ones));
				} else {
					ltrNormalized.add(0d);
				}
			}
			System.out.println(ltrNormalized + " normalized" + " ["  + ltr.get(256).toString() + "]");
			neuronsInSecondLayer.add(new Neuron(ltrNormalized, ltr.get(256).toString()));
		}
		
		SingleLayer secondLayer = new SingleLayer(neuronsInSecondLayer, "output layer");
		
		ArrayList<SingleLayer> layers = new ArrayList<>();
		layers.add(firstInputLayer);
		layers.add(secondLayer);
		
		NeuronNetwork net = new NeuronNetwork(layers, "neutal MADALINE network");
		
		ArrayList<Integer> inputVector = new ArrayList<>();
		// A = [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 65]
		int[] array = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0};
		for (int i : array) {
			inputVector.add(i);
		}

		net.checkLetter(inputVector);

	}

}
