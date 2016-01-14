package AI;

import java.io.File;
import java.io.IOException;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;


public class Cluster {
	
	public Cluster(){}
	
	public Dataset[] kMeans(String path, int numberOfClusters, int numberOfIterations, int key) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new KMeans(numberOfClusters, numberOfIterations);
		return clusterer.cluster(data);
	}
}
