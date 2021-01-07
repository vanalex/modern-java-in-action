package chapter09.chainOfResponsability;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public abstract class ProcessingObject<T> {

    private ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input){
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}
