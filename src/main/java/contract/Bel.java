package contract;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public interface Bel extends BelEquation {
//    Map thalamusExecute(Double sensoryInputValue);
    default Map<String, Double> sensoryCortex(
                Double alpha,
                Double beta,
                Double sensoryInputValue,
                Double rew,
                Double amygdalaValue,
                Double orbitofrontalCortexValue,
                Double weightAmygdala,
                Double weightOrbitofrontal
            ) {
        Map<String, Double> result = new HashMap();
        result.put(
                "newWeightAmygdala",
                weightAmygdalaEquation(alpha, sensoryInputValue, rew, amygdalaValue) + weightAmygdala
        );
        result.put(
                "newWeightOrbitofrontal",
                weightOrbitofrontalEquation(beta, sensoryInputValue, rew, orbitofrontalCortexValue) + weightOrbitofrontal
        );

        return result;
    }
    default Double orbitofrontalCortex(
            Double weightOrbitofrontal,
            Double sensoryInputValue,
            Double rew
    ) {
        return orbitofrontalEquation(weightOrbitofrontal, sensoryInputValue) * rew;
    }
     default Double amygdala(
            Double weightAmygdala,
            Double sensoryInputValue,
            Double rew
    ) {
        return amygdalaEquation(weightAmygdala, sensoryInputValue) * rew;
     }
}
