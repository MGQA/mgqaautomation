call mvn clean package assembly:single
java -cp ./target/java.automation-0.0.1-SNAPSHOT-jar-with-dependencies.jar org.testng.TestNG ./src/main/resources/testng/smoke.xml