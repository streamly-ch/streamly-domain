package ch.streamly.domain;

/**
 * Wraps a value with its timestamp.
 *
 * @param <T> data type
 */
public interface Timed<T>  extends WrappedValue<T> {
    long time();
}
