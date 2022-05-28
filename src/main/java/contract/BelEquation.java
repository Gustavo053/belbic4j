package contract;

public interface BelEquation {

    /*
    The thalamus will not be used because the algorithm is working with a single emotional signal,
    not an array of emotional signals
    default Double thalamusExecuteEquation(Double sensoryInputValue) {

    }
     */

    default Double weightAmygdalaEquation(
            Double alpha,
            Double sensoryInputValue,
            Double rew,
            Double amygdalaValue
    ) {
        return alpha * (sensoryInputValue * Math.max(0, rew - amygdalaValue));
    }
    default Double weightOrbitofrontalEquation(
            Double beta,
            Double sensoryInputValue,
            Double rew,
            Double orbitofrontalCortexValue
    ) {
        return beta * (sensoryInputValue * (orbitofrontalCortexValue - rew));
    }
    default Double amygdalaEquation(Double weightAmygdala, Double sensoryInputValue) {
        return weightAmygdala * sensoryInputValue;
    }

    default Double orbitofrontalEquation(Double weightOrbitofrontal, Double sensoryInputValue) {
        return weightOrbitofrontal * sensoryInputValue;
    }
}
