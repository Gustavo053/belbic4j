package contract;

public interface BelEquation {
    Float thalamusExecuteEquation(Float sensoryInputValue);
    Float weightAmygdalaExecuteEquation(
            Float alpha,
            Float sensoryInputValue,
            Float rew,
            Float amygdalaCortexValue
    );
    Float weightOrbitofrontalExecuteEquation(
            Float beta,
            Float sensoryInputValue,
            Float rew,
            Float orbitofrontalCortexValue
    );
    Float amygdalaEquation(Float weightAmygdala, Float sensoryInputValue);
    Float orbitofrontalEquation(Float weightOrbitofrontal, Float sensoryInputValue);
}
