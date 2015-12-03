import java.io.IOException;
import java.util.ArrayList;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.core.Dataset;

import AI.Classificator;
import AI.Cluster;

public class JDMMining {
	Classificator classificator;
	Cluster cluster;
	public JDMMining(){
		classificator = new Classificator();
		cluster = new Cluster();
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
	public Dataset[] kMeans(String path, int numberOfClusters, int numberOfIterations, int key) throws IOException{
		return cluster.kMeans(path, numberOfClusters, numberOfIterations, key);
	}
	
	
}
