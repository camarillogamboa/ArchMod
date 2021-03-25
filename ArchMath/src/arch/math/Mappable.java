package arch.math;

import arch.math.dimath.OrderedPair;
import arch.tools.collection.StreamFactory;
import arch.tools.collection.iterator.DoubleIterator;
import arch.tools.collection.iterator.IteratorWrapper;
import arch.tools.collection.iterator.Iterators;
import arch.tools.collection.iterator.MappedIterator;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface Mappable {

    double[] DEFAULT_DOMAIN_KEY = new double[0];

    double[] apply(double... domainKey);

    default OrderedPair map(double... domainKey) {
        return new OrderedPair(domainKey, apply(domainKey));
    }

    default Iterator<OrderedPair> descriptorOf(Iterator<double[]> domain) {
        return new MappedIterator<>(domain, this::map);
    }

    default Iterator<OrderedPair> descriptorOf(DoubleIterator... domains) {
        switch (domains.length) {
            case 0:
                return descriptorOf(new IteratorWrapper<>(() -> false, () -> DEFAULT_DOMAIN_KEY));
            case 1:
                var domain = domains[0];
                return descriptorOf(new IteratorWrapper<>(domain::hasNext, () -> new double[]{domain.next()}));
            default:
                return descriptorOf(new IteratorWrapper<>(() -> {
                    var flag = true;

                    for (var d : domains) flag = flag && d.hasNext();

                    return flag;
                }, () -> {
                    var buffer = new double[domains.length];

                    for (int i = 0; i < buffer.length; i++) buffer[i] = domains[i].next();

                    return buffer;
                }));
        }
    }

    default Iterator<OrderedPair> descriptorOf(double[]... domains) {
        var iterators = new DoubleIterator[domains.length];

        for (int i = 0; i < iterators.length; i++) iterators[i] = Iterators.iterator(domains[i]);

        return descriptorOf(iterators);
    }

    default Stream<OrderedPair> streamDescriptorOf(Iterator<double[]> domain) {
        return StreamFactory.streamOf(descriptorOf(domain));
    }

    default Stream<OrderedPair> streamDescriptorOf(DoubleIterator... domains) {
        return StreamFactory.streamOf(descriptorOf(domains));
    }

    default Stream<OrderedPair> streamDescriptorOf(double[]... domains) {
        return StreamFactory.streamOf(descriptorOf(domains));
    }

    default void map(Consumer<OrderedPair> consumer, Iterator<double[]> domain) {
        Iterators.iterate(descriptorOf(domain), consumer);
    }

    default void map(Consumer<OrderedPair> consumer, DoubleIterator... domains) {
        Iterators.iterate(descriptorOf(domains), consumer);
    }

    default void map(Consumer<OrderedPair> consumer, double[]... domains) {
        Iterators.iterate(descriptorOf(domains), consumer);
    }

}
