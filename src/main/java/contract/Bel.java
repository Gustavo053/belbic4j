package contract;

import java.util.Map;
import java.util.concurrent.Callable;

public interface Bel {
    Float sensoryInputExecute(Callable callable) throws Exception;
    Map thalamusExecute(Float sensoryInputValue);
    Float sensoryCortexExecute(
                Float sensoryInputValue,
                Float rew,
                Float amygdalaCortexValue,
                Float amygdalaCortexFinalValue,
                Float weightAmygdala,
                Float weightOrbitofrontal
            );
    Float orbitofrontalCortexExecute(
            Float weightOrbitofrontal,
            Float sensoryInputValue,
            Float amygdalaCortexValue,
            Float orbitofrontalCortexValue,
            Float rew
    );
    Float amygdala(
            Float weightAmygdala,
            Float sensoryInputValue,
            Float amygdalaCortexValue,
            Float orbitofrontalCortexValue,
            Float rew
    );
}
