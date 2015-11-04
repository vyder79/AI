import java.io.IOException;

public class t {

	public static void main(String[] args) throws IOException {
		ReadFile rf = new ReadFile();
		
//		String file = "C:/Users/Mateusz/Desktop/Literki 16x16/B.txt";
		String file2 = "C:/Users/Mateusz/git/AI/AI_task_0/src/Letters/Alfabet.txt";
		
//		rf.read(file);
//		System.out.println(rf.getInputVector().size());
		
		rf.readAllLetters(file2);		
		rf.read(rf.getAllLetters());
		System.out.println(rf.getInputArray().get(25).size());


	}

}
