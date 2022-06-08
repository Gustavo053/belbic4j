package equation;

import java.io.Serializable;

public class BelbicEquation implements Serializable {

    public static Double weightAmygdalaEquation(
            Double alpha,
            Double sensoryInputValue,
            Double rew,
            Double amygdalaValue
    ) {
        return alpha * (sensoryInputValue * Math.max(0, rew - amygdalaValue));
    }

    public static Double weightOrbitofrontalEquation(
            Double beta,
            Double sensoryInputValue,
            Double rew,
            Double orbitofrontalCortexValue
    ) {
        return beta * (sensoryInputValue * (orbitofrontalCortexValue - rew));
    }

    public static Double amygdalaEquation(Double weightAmygdala, Double sensoryInputValue) {
        return weightAmygdala * sensoryInputValue;
    }

    public static Double orbitofrontalEquation(Double weightOrbitofrontal, Double sensoryInputValue) {
        return weightOrbitofrontal * sensoryInputValue;
    }
}
