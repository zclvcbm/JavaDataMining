package AI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.classification.MeanFeatureVotingClassifier;
import net.sf.javaml.classification.NearestMeanClassifier;
import net.sf.javaml.classification.ZeroR;
import net.sf.javaml.classification.tree.RandomForest;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;

public class Classificator {

	public Classifier randomForest(String path, int numberOfTrees, int key)
			throws IOException, IllegalArgumentException {

		Classifier model = new RandomForest(numberOfTrees, false, key,
				new Random(numberOfTrees));
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}

	public Classifier kNearestNeighbors(String path, int neighbors, int key)
			throws IOException, IllegalArgumentException {

		Classifier model = new KNearestNeighbors(neighbors);
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}

	public Classifier nearestMeanClassifier(String path, int key)
			throws IOException, IllegalArgumentException {

		Classifier model = new NearestMeanClassifier();
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}

	public Classifier MeanFeatureVotingClassifier(String path, int key)
			throws IOException, IllegalArgumentException {

		Classifier model = new MeanFeatureVotingClassifier();
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}
	public Classifier zeroR(String path, int key)
			throws IOException, IllegalArgumentException {

		Classifier model = new ZeroR();
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}
	

	public ArrayList<Object> clasify(String path, int key, Classifier model)
			throws IOException {

		ArrayList<Object> predictedValues = new ArrayList<Object>();
		Dataset dataForClassification = FileHandler.loadDataset(new File(path),
				key, ",");
		for (Instance inst : dataForClassification) {
			predictedValues.add(model.classify(inst));
		}
		return predictedValues;
	}

}
