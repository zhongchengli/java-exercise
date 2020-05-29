package testdome.exercises;

import java.util.ArrayList;
import java.util.Collection;

/*
Implement a function folderNames, which accepts a string containing an XML file
that specifies folder structure and returns all folder names that start with startingLetter.
The XML format is given in the example below.

<?xml version="1.0" encoding="UTF-8"?>
<folder name="c">
    <folder name="program files">
        <folder user="my-user" name = " uninstall information " />
    </folder>
    <folder name="users" />
</folder>

 */
// PASS: https://www.testdome.com/questions/java/folders/35600?visibility=3&skillId=4
public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        String[] splitFolder = xml.split("<folder ");
        Collection<String> names = new ArrayList<>();

        for (String str : splitFolder) {
            if (str.indexOf("name") > -1) {
                String[] splitName = str.trim().split("name");
                String[] splitEqual = splitName[1].trim().split("=");
                String[] splitQuote = splitEqual[1].trim().split("\"");
                if (splitQuote[1].length() > 0 && splitQuote[1].charAt(0) == startingLetter) {
                    names.add(splitQuote[1].trim());
                }
            }
        }
        return names;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder user=\"abc\" name =\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for (String name : names)
            System.out.println(name);
    }
}
