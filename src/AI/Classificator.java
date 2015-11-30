package AI;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.tree.RandomForest;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

public class Classificator {

	
	public void randomForest(String path, int numberOfTrees, int key) throws IOException, IllegalArgumentException{
		
			Classifier tree = new RandomForest(numberOfTrees, false, key, new Random(numberOfTrees));
			Dataset data = FileHandler.loadDataset(new File(path), key, ",");
			tree.buildClassifier(data);
	
	}
	
}
