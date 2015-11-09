import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

	private ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();
	private ArrayList<String> allLetters = new ArrayList<>();

	/*
	 * Metoda do czytania pojedynczych liter i przygotowywuj¹ca wektor wejœciowy
	 * z otrzymanych danych. Wektor wejœciowy posiada 256 elementów element 257
	 * odpowiada Lietrze która jest zakodowana we wzorcu
	 */
	public ArrayList<ArrayList<Integer>> read(ArrayList<String> input) {
		for (int i = 0; i < input.size(); i++) {
			ArrayList<Integer> inputVector = new ArrayList<>();
			try {
				FileInputStream fileInputStream = new FileInputStream(input.get(i));

				int b = fileInputStream.read();

				while (b != -1) {
					if (b == 42) {
						inputVector.add(1);
					} else if (b == 48) {
						inputVector.add(0);
					}
					else if(b != 48 && b != 10 && b != 13 && b != 42){
						inputVector.add(b);
					}

					b = fileInputStream.read();
				}
				inputArray.add(inputVector);
				fileInputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return inputArray;
	}

	/*
	 * Metoda do wczytania œcie¿ek do wszystkich wzorców liter umieszconych w
	 * pliku
	 */
	public ArrayList<String> readAllLetters(String file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String textLine = bufferedReader.readLine();
		do {
			allLetters.add(textLine);
			textLine = bufferedReader.readLine();

		} while (textLine != null);

		bufferedReader.close();
		return allLetters;
	}

	public ArrayList<String> getAllLetters() {
		return allLetters;
	}

	public void setAllLetters(ArrayList<String> allLetters) {
		this.allLetters = allLetters;
	}

	public ArrayList<ArrayList<Integer>> getInputArray() {
		return inputArray;
	}

	public void setInputArray(ArrayList<ArrayList<Integer>> inputArray) {
		this.inputArray = inputArray;
	}

}
