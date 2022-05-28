package contract;

public interface BelEquation {
    Double thalamusExecuteEquation(Double sensoryInputValue);
    Double weightAmygdalaExecuteEquation(
            Double alpha,
            Double sensoryInputValue,
            Double rew,
            Double amygdalaCortexValue
    );
    Double weightOrbitofrontalExecuteEquation(
            Double beta,
            Double sensoryInputValue,
            Double rew,
            Double orbitofrontalCortexValue
    );
    Double amygdalaEquation(Double weightAmygdala, Double sensoryInputValue);
    Double orbitofrontalEquation(Double weightOrbitofrontal, Double sensoryInputValue);
}
