
import java.util.List;

public interface Graph {
	
	 	boolean isConnected();

	    List<Integer> reachable(int vertex);

	    List<Edge> mst();

	    int shortestPath(int vertex1, int vertex2);

}
