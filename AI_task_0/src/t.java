import java.io.IOException;
import java.util.ArrayList;

public class t {

	public static void main(String[] args) throws IOException {
		ReadFile rf = new ReadFile();
		
		String file2 = "C:/Users/Mateusz/git/AI/AI_task_0/src/Letters/Alfabet.txt";
		//String file2 = "C:/Users/vyder/git/AI/AI_task_0/src/Letters/Alfabet.txt";

		rf.readAllLetters(file2);		
		rf.read(rf.getAllLetters());
		
		/** 
		 * przepisanie liter na wektory wejœciowe oraz normalizacja 
		 * 
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
				}
			}
			System.out.println(ltrNormalized + " normalized");
		}
		
		


	}

}
