package contract;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public interface Bel {
    void sensoryInputExecute(Runnable runnable);
    Map thalamusExecute(Double sensoryInputValue);
    Double sensoryCortexExecute(
                Double sensoryInputValue,
                Double rew,
                Double amygdalaCortexValue,
                Double amygdalaCortexFinalValue,
                Double weightAmygdala,
                Double weightOrbitofrontal
            );
    Double orbitofrontalCortexExecute(
            Double weightOrbitofrontal,
            Double sensoryInputValue,
            Double amygdalaCortexValue,
            Double orbitofrontalCortexValue,
            Double rew
    );
    Double amygdala(
            Double weightAmygdala,
            Double sensoryInputValue,
            Double amygdalaCortexValue,
            Double orbitofrontalCortexValue,
            Double rew
    );
}
