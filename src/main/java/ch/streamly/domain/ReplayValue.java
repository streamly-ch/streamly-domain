package ch.streamly.domain;

/**
 * A value wrapper that indicates if the current value is the first value replayed in the replay loop.
 * @param <T> data type
 */
public interface ReplayValue<T> extends WrappedValue<T> {

    /**
     * @return true if this object is the loop restart signal (meaning that the replay loop has restarted from the beginning)
     */
    boolean isLoopRestart();

    /**
     *
     * @param value the value to wrap.
     * @return a ReplayValue that is not a loop restart.
     */
    default ReplayValue newValue(T value){
        return new ReplayValueImpl<>(value);
    }

    /**
     *
     * @param value the value to wrap.
     * @return a loop restart value.
     */
    default ReplayValue newLoopRestartValue(T value){
        return new ReplayValueImpl<>(true, value);
    }
}
