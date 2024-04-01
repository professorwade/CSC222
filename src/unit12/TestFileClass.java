package unit12;

public class TestFileClass {
    public static void main(String[] args) {
        java.io.File file = new java.io.File("image/us.gif");
        System.out.println("Does it exist? " + file.exists());
        System.out.println("The file has " + file.length() + " bytes");
        System.out.println("Can it be read? " + file.canRead());
        System.out.println("Can it be written? " + file.canWrite());
        System.out.println("Is it a directory? " + file.isDirectory());
        System.out.println("Is it a file? " + file.isFile());
        System.out.println("Is it absolute? " + file.isAbsolute());
        System.out.println("Is it hidden? " + file.isHidden());
        System.out.println("Absolute path is " +
                file.getAbsolutePath());
        System.out.println("Last modified on " +
                new java.util.Date(file.lastModified()));

        // with a valid file
        java.io.File file2 = new java.io.File("src/unit12/TestFileClass.java");
        System.out.println("Does it exist? " + file2.exists());
        System.out.println("The file has " + file2.length() + " bytes");
        System.out.println("Can it be read? " + file2.canRead());
        System.out.println("Can it be written? " + file2.canWrite());
        System.out.println("Is it a directory? " + file2.isDirectory());
        System.out.println("Is it a file? " + file2.isFile());
        System.out.println("Is it absolute? " + file2.isAbsolute());
        System.out.println("Is it hidden? " + file2.isHidden());
        System.out.println("Absolute path is " +
                file2.getAbsolutePath());
        System.out.println("Last modified on " +
                new java.util.Date(file2.lastModified()));




    }
}