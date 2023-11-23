package pl.krysinski;

import java.util.Map;
import java.util.Scanner;

public class Application {
    Scanner scanner = new Scanner(System.in);
    void run(){
        System.out.println("Enter number of connections: ");
        int connectionsNumber = scanner.nextInt();

        GraphOperations graphOperations = new GraphOperations();
        Map<Integer, Integer> graphConnectionsMap = graphOperations.getGraphConnectionsMap(connectionsNumber, scanner);
        int separatedGraphs = graphOperations.countSeparatedGraphs(graphConnectionsMap);

        System.out.println(separatedGraphs);
        scanner.close();
    }
}
