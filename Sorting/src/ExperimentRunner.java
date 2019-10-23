import algorithms.*;
import helpers.DegreeOfSortednessHelper;
import helpers.PercentageSplittingHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ExperimentRunner {

    static String[] getFilePathsInDirectory(String dirPath){
        File dir = new File(dirPath);
        ArrayList<String> fileNames = new ArrayList<>();
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (int i=0;i<directoryListing.length;i++) {
                File child = directoryListing[i];
                fileNames.add(child.getAbsolutePath());
            }
        }
        return fileNames.toArray(new String[0]);
    }

    static String getDirName(String dirPath){
        File dir = new File(dirPath);
        return dir.getName();
    }

    static String[] getFileNamesInDirectory(String dirPath){
        File dir = new File(dirPath);
        ArrayList<String> fileNames = new ArrayList<>();
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (int i=0;i<directoryListing.length;i++) {
                File child = directoryListing[i];
                fileNames.add(child.getName());
            }
        }
        return fileNames.toArray(new String[0]);
    }

    public static void main(String args[]) throws IOException {
        int[] percentages = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        String sizeDataSetDir = "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\sizeDatasets";
        String[] degreeOfSortednessDirs={ "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\data1",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\data2",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\priceDataSet250k",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\priceDataSet500k"};
        PercentageSplittingHelper.createPercentages(getFilePathsInDirectory(sizeDataSetDir),getFileNamesInDirectory(sizeDataSetDir),percentages,10);

        for (String dir: degreeOfSortednessDirs
             ) {
            String name = getDirName(dir);
            DegreeOfSortednessHelper.createCSVs(getFilePathsInDirectory(dir), getDirName(dir), 10);
        }

    }
}
