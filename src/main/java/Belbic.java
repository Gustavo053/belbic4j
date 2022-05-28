import contract.Bel;
import contract.BelEquation;

import java.util.Map;
import java.util.concurrent.Callable;

public class Belbic implements Bel, BelEquation {
    private Float sensoryInputValue;
    private Float amygdalaCortexValue;
    private Float amygdalaCortexFinalValue;
    private Float orbitofrontalCortexValue;
    private Float orbitofrontalCortexFinalValue;
    private Float weightAmygdala;
    private Float weightOrbitofrontal;

    public Float sensoryInputExecute(Callable callable) throws Exception {
        return (Float) callable.call();
    }

    public Map thalamusExecute(Float sensoryInputValue) {
        return null;
    }

    public Float sensoryCortexExecute(Float sensoryInputValue, Float rew, Float amygdalaCortexValue, Float amygdalaCortexFinalValue, Float weightAmygdala, Float weightOrbitofrontal) {
        return null;
    }

    public Float orbitofrontalCortexExecute(Float weightOrbitofrontal, Float sensoryInputValue, Float amygdalaCortexValue, Float orbitofrontalCortexValue, Float rew) {
        return null;
    }

    public Float amygdala(Float weightAmygdala, Float sensoryInputValue, Float amygdalaCortexValue, Float orbitofrontalCortexValue, Float rew) {
        return null;
    }

    public Float thalamusExecuteEquation(Float sensoryInputValue) {
        return null;
    }

    public Float weightAmygdalaExecuteEquation(Float alpha, Float sensoryInputValue, Float rew, Float amygdalaCortexValue) {
        return null;
    }

    public Float weightOrbitofrontalExecuteEquation(Float beta, Float sensoryInputValue, Float rew, Float orbitofrontalCortexValue) {
        return null;
    }

    public Float amygdalaEquation(Float weightAmygdala, Float sensoryInputValue) {
        return null;
    }

    public Float orbitofrontalEquation(Float weightOrbitofrontal, Float sensoryInputValue) {
        return null;
    }
}
