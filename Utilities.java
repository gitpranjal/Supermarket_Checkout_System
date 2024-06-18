import java.util.HashMap;
import java.util.Map;

public class Utilities {
    
      public static void prettyPrintMap(HashMap<String, ?> map, String keyName, String valueName) {
        // Find the maximum key and value length to format the table
        int maxKeyLength = "Key".length();
        int maxValueLength = "Value".length();
        
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (entry.getKey().length() > maxKeyLength) {
                maxKeyLength = entry.getKey().length();
            }
            if (String.valueOf(entry.getValue()).length() > maxValueLength) {
                maxValueLength = String.valueOf(entry.getValue()).length();
            }
        }

        // Print the header
        String format = "| %-" + maxKeyLength + "s | %-" + maxValueLength + "s |%n";
        System.out.printf(format, keyName, valueName);
        System.out.println(new String(new char[maxKeyLength + maxValueLength + 7]).replace('\0', '-'));

        // Print the key-value pairs
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            System.out.printf(format, entry.getKey(), String.valueOf(entry.getValue()));
        }
    }
}
