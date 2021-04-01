package arch.tools.collection.node;

public final class Block<V> extends NodeBase<V> {

    private Block<V> next;
    private Block<V> previus;
    private Block<V> top;
    private Block<V> botton;

    public Block(V value) {
        super(value);
    }

    public Block() {
        super();
    }

    public void setNext(Block<V> next) {
        if (this.next != null) this.next.previus = null;
        if (next != null) next.previus = this;
        this.next = next;
    }

    public void setPrevius(Block<V> previus) {
        if (this.previus != null) this.previus.next = null;
        if (previus != null) previus.next = this;
        this.previus = previus;
    }

    public void setTop(Block<V> top) {
        if (this.top != null) this.top.botton = null;
        if (top != null) top.botton = this;
        this.top = top;
    }

    public void setBotton(Block<V> botton) {
        if (this.botton != null) this.botton.top = null;
        if (botton != null) botton.top = this;
        this.botton = botton;
    }

    public Block<V> getNext() {
        return next;
    }

    public Block<V> getPrevius() {
        return previus;
    }

    public Block<V> getTop() {
        return top;
    }

    public Block<V> getBotton() {
        return botton;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrevius() {
        return previus != null;
    }

    public boolean hasTop() {
        return top != null;
    }

    public boolean hasBotton() {
        return botton != null;
    }

}
