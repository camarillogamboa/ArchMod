package arch.tools.collection.node;

public final class Edge<V, W> {

    private W weight;

    private Vertex<V, W> vertexA;
    private Vertex<V, W> vertexB;

    public Edge(W weight, Vertex<V, W> vertexA, Vertex<V, W> vertexB) {
        this.weight = weight;
        this.vertexA = vertexA;
        this.vertexB = vertexB;
    }

    public Edge(W weight) {
        this(weight, null, null);
    }

    public Edge() {
        this(null);
    }

    public void setWeight(W weight) {
        this.weight = weight;
    }

    public void setVertexA(Vertex<V, W> vertexA) {
        if (this.vertexA != null) this.vertexA.edges.remove(this);
        if (vertexA != null) vertexA.edges.add(this);
        this.vertexA = vertexA;
    }

    public void setVertexB(Vertex<V, W> vertexB) {
        if (this.vertexB != null) this.vertexB.edges.remove(this);
        if (vertexB != null) vertexB.edges.add(this);
        this.vertexB = vertexB;
    }

    public W getWeight() {
        return weight;
    }

    public Vertex<V, W> getVertexA() {
        return vertexA;
    }

    public Vertex<V, W> getVertexB() {
        return vertexB;
    }
}
