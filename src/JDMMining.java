import java.io.IOException;

import AI.Classificator;

public class JDMMining {
	Classificator classificator;
	
	public JDMMining(){
		classificator = new Classificator();
	}

	public void randomForest(String path, int numberOfTrees, int key) throws IllegalArgumentException, IOException {
		classificator.randomForest(path, numberOfTrees, key);
	}
	
}
