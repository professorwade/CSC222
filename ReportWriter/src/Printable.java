interface Printable {

    /**
     * Retrieves the text of the object for the purpose of printing
     * @return ASCII text of object
     */
    String getText();

    /**
     * Retrieves the suggested filename of the printed text to be saved under
     * @return filename string
     */
    String getFileName();
}
