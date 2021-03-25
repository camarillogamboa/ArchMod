package arch.tools.collection.node;

import java.util.LinkedList;
import java.util.List;

public final class Vertex<V, W> {

    final List<Edge<V, W>> edges;

    public Vertex() {
        this.edges = new LinkedList<>();
    }

}
