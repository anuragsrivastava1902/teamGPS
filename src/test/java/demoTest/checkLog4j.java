package demoTest;

public class checkLog4j {

        public static void main(String[] args) {
            try {
                // Try to load Log4j class at runtime
                Class.forName("org.apache.logging.log4j.Logger");
                System.out.println("Log4j is present in the classpath.");
            } catch (ClassNotFoundException e) {
                System.out.println("Log4j is NOT present in the classpath.");
            }
        }
    }

