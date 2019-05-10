import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	String theData = args[0];
	List<DataPoint> iris1 = DataSet.readDataSet(theData);
	Datapoint irisPoint = iris1.get(3);
	
	double [] values = irisPoint.getX(); 
	String irisFlower = irisPoint.getLabel();
	
	for (int i=0; i<values.length;i++)
	{ System.out.println(values[i]);
	}


    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	
//DataPoint dp = mylist.get(4);
	//double [] dpx = dp.getX();
	//String.printableX = Arrays.toString(dp.getX());
	//System.out.pritnln(printableX);

    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)



    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)



    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label



    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.


  }

}
