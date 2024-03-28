package unit9;

import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataFileGenerator {
    /**
     *
     * @param lastNameFile - used for random last names
     * @param firstNameFile - used for random first names
     * @param recordCount - number of records to generate
     * @param maxGrades - max grades per student (will randomly generate max/2 - max grades)
     * @param outFile - output data file to be used in assignment
     */
    public static void create(String lastNameFile, String firstNameFile, int recordCount, int maxGrades, String outFile) {
        // Create Random Number Generator
        Random rand = new Random();

        // Read the last names
        String contents = FileReader.read(lastNameFile);
        String[] allLastNames = contents.split("\n");

        // Read the first names
        contents = FileReader.read(firstNameFile);
        String[] allFirstNames = contents.split("\n");

        // Create Storage
        String[] firstNames = new String[recordCount];
        String[] lastNames = new String[recordCount];
        int[][] grades = new int[recordCount][];

        // Generate Data
        for (int i = 0; i < recordCount; i++) {
            grades[i] = new int[rand.nextInt(maxGrades/2 + 1) + maxGrades/2];
            for (int j = 0; j < grades[i].length; j++) {
                grades[i][j] = 60 + rand.nextInt(40);
            }
        }

        // Generate First and Last Names
        for (int i = 0; i < recordCount; i++) {
            String temp = allFirstNames[rand.nextInt(allFirstNames.length)];
            int lastIndex = temp.lastIndexOf(' ');
            if (lastIndex > 0)
                firstNames[i] = temp.substring(0,temp.lastIndexOf(' '));
            else
                firstNames[i] = temp;
            lastNames[i] = allLastNames[rand.nextInt(allLastNames.length)];
        }

        // Build Grade String
        String nameFormatString = "%10s %15s     ";
        String gradeFormatString = "%4d";
        
        // Serialize Data to File
        try {
            FileWriter fw = new FileWriter(outFile);
            for (int i = 0; i < recordCount; i++) {
                String outString =  String.format(nameFormatString, firstNames[i], lastNames[i]);
                // generate data and format array
                for (int j = 0; j < grades[i].length; j++) {
                    outString = outString.concat(String.format(gradeFormatString, grades[i][j]));
                }
                outString = outString.concat("\n");
                fw.write(outString);
            }
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Exception Thrown: " + e.toString());
        }
    }

    public static void main(String[] args) {
        // public DataFileGenerator(String lastNameFile, String firstNameFile, int recordCount, int maxGrades, String outFile)
        if (System.getProperty("os.name").contains("OS X"))
            DataFileGenerator.create("src/unit9/lastnames.txt", "src/unit9/firstnames.txt",
                    50, 6, "src/unit9/records.txt");
        else
            DataFileGenerator.create("src\\unit9\\lastnames.txt", "src\\unit9\\firstnames.txt",
                50, 6, "src\\unit9\\records.txt");
    }
}
