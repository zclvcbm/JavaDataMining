import java.io.IOException;
import java.util.ArrayList;

import net.sf.javaml.classification.Classifier;

import AI.Classificator;

public class JDMMining {
	Classificator classificator;
	
	public JDMMining(){
		classificator = new Classificator();
	}

	public Classifier randomForest(String path, int numberOfTrees, int key) throws IllegalArgumentException, IOException {
		return classificator.randomForest(path, numberOfTrees, key);
	}
	public Classifier kNearestNeighbors(String path, int neighbors, int key) throws IOException, IllegalArgumentException {
		return classificator.kNearestNeighbors(path, neighbors, key);
	}
	public ArrayList<Object> clasify(String path, int key, Classifier tree) throws IOException{
		return classificator.clasify(path, key, tree);
	}
	
	
	
}
