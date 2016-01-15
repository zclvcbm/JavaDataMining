import java.io.IOException;
import java.util.ArrayList;

import AI.Classificator;
import AI.Cluster;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.clustering.SOM.GridType;
import net.sf.javaml.clustering.SOM.LearningType;
import net.sf.javaml.clustering.SOM.NeighbourhoodFunction;
import net.sf.javaml.core.Dataset;

public class JDMMining {
	Classificator classificator;
	Cluster cluster;
	public JDMMining(){
		classificator = new Classificator();
		cluster = new Cluster();
	}

	public Classifier KDtreeKNN(String path, int key) throws IOException, IllegalArgumentException {
		return classificator.KDtreeKNN(path, key);
	}
	public Classifier randomForest(String path, int numberOfTrees, int key) throws IllegalArgumentException, IOException {
		return classificator.randomForest(path, numberOfTrees, key);
	}
	public Classifier kNearestNeighbors(String path, int neighbors, int key) throws IOException, IllegalArgumentException {
		return classificator.kNearestNeighbors(path, neighbors, key);
	}
	
	public Classifier nearestMeanClassifier(String path, int key)
			throws IOException, IllegalArgumentException {
		return classificator.nearestMeanClassifier(path, key);
	}
	public Classifier meanFeatureVotingClassifier(String path, int key)
			throws IOException, IllegalArgumentException {
		return classificator.meanFeatureVotingClassifier(path, key);
	}
	public Classifier som(String path, int key, int xdim, int ydim,GridType grid, int iterations, double learningRate, int initialRadius, LearningType learning, NeighbourhoodFunction nbf)
			throws IOException, IllegalArgumentException {
		return classificator.som(path, key, xdim, ydim, grid, iterations, learningRate, initialRadius, learning, nbf);
	}
	public Classifier zeroR(String path, int key)
			throws IOException, IllegalArgumentException {
		return classificator.zeroR(path, key);
	}

	
	
	public ArrayList<Object> clasify(String path, int key, Classifier tree) throws IOException{
		return classificator.clasify(path, key, tree);
	}
	public Dataset[] kMeans(String path, int numberOfClusters, int numberOfIterations, int key) throws IOException{
		return cluster.kMeans(path, numberOfClusters, numberOfIterations, key);
	}
	
	
	
}
