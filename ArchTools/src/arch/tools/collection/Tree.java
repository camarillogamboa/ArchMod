package arch.tools.collection;

import arch.tools.collection.iterator.Iterators;
import arch.tools.collection.iterator.MappedIterator;
import arch.tools.collection.iterator.Sequential;

import java.util.Iterator;
import java.util.function.Consumer;

public interface Tree<E> extends AbstractCollection<E> {

    MoveCursor<E> getCursor();

    SequentialCursor<E> preorderCursor();

    SequentialCursor<E> postorderCursor();

    default void forEachPreorder(Consumer<Cursor<E>> action) {
        Iterators.iterate(preorderIterator(), action);
    }

    default void forEachPostorder(Consumer<Cursor<E>> action) {
        Iterators.iterate(postorderIterator(), action);
    }

    default Iterator<Cursor<E>> preorderIterator() {
        return createIterator(preorderCursor());
    }

    default Iterator<Cursor<E>> postorderIterator() {
        return createIterator(postorderCursor());
    }

    @Override
    default Iterator<E> iterator() {
        return new MappedIterator<>(preorderIterator(), Cursor::value);
    }

    private static <E> Iterator<Cursor<E>> createIterator(SequentialCursor<E> cursor) {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return cursor.hasNext();
            }

            @Override
            public Cursor<E> next() {
                cursor.moveToNext();
                return cursor;
            }
        };
    }

    interface Cursor<E> {
        E value();

        int level();

        boolean hasParent();

        default boolean isRoot() {
            return !hasParent();
        }

        boolean hasChildren();

        default boolean isLeaf() {
            return !hasChildren();
        }

        boolean isVoid();

        void remove();
    }

    interface MoveCursor<E> extends Cursor<E> {

        void moveToParent();

        void moveToFirstChild();

        void moveToLatestChild();

        default void moveToChild() {
            moveToFirstChild();
        }

        void put(E e);

        void putAndMove(E e);
    }

    interface SequentialCursor<E> extends Cursor<E>, Sequential {

        void moveToNext();

    }
}
