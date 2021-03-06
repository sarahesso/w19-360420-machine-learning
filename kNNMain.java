import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	double[] accuracy = new double[1000];
	
	 for(int k=0; k<1000 ; k++) {	
	String theData = args[0];
	List<DataPoint> breastCancer = DataSet.readDataSet(theData);
	
	DataPoint breastCancerPoint = breastCancer.get(3);
	double [] values = breastCancerPoint.getX();
	String printableX = Arrays.toString(values);

	//System.out.println(printableX); 
	 
	 

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	List<DataPoint> bCancerTest = DataSet.getTestSet(breastCancer,0.3);
	List<DataPoint> bCancerTraining = DataSet.getTrainingSet(breastCancer,0.7);
	

    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class) DON'T DO IT



    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
		


    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
		KNNClassifier myObject = new KNNClassifier(5);
		DataPoint [] kNeighbor = myObject.getNearestNeighbors(breastCancer,breastCancerPoint);
		//System.out.println(kNeighbor);


    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
		
	int Correct = 0;
	 
     for (int i=0; i<bCancerTest.size(); i++) {
			 DataPoint myThing = bCancerTest.get(i); 
			String prediction = myObject.predict(bCancerTraining, myThing);
			
			if(myThing.getLabel().equals (prediction))
			{
				Correct ++;
			}
      }
	  
	  double percentage = 100* ((double)Correct / (double)bCancerTest.size());
	  System.out.println(percentage);
	  accuracy[k] = percentage;
	  double mean = (double) Correct / (double) k;
	  System.out.println("the mean is: " + mean);
	  double sum =0.;
	  for( int j=0 ; j<1000 ; j++)
	  {
		 sum = Math.pow(accuracy[j]-mean,2);
	  }
	  double standardDeviation= Math.sqrt(sum / k);
	  System.out.println("the standard deviation is: " + standardDeviation);
		  
			
		 
  }

}
}
