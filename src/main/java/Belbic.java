import contract.Bel;
import contract.BelEquation;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

@Getter
@Setter
public class Belbic implements Bel, BelEquation, Serializable {
    private Double sensoryInputValue;
    private Double amygdalaCortexValue;
    private Double amygdalaCortexFinalValue;
    private Double orbitofrontalCortexValue;
    private Double orbitofrontalCortexFinalValue;
    private Double weightAmygdala;
    private Double weightOrbitofrontal;
    private Double rewValue;

    public void sensoryInputExecute(Runnable runnable){
        runnable.run();
    }

    public Map thalamusExecute(Double sensoryInputValue) {
        return null;
    }

    public Double sensoryCortexExecute(Double sensoryInputValue, Double rew, Double amygdalaCortexValue, Double amygdalaCortexFinalValue, Double weightAmygdala, Double weightOrbitofrontal) {
        return null;
    }

    public Double orbitofrontalCortexExecute(Double weightOrbitofrontal, Double sensoryInputValue, Double amygdalaCortexValue, Double orbitofrontalCortexValue, Double rew) {
        return null;
    }

    public Double amygdala(Double weightAmygdala, Double sensoryInputValue, Double amygdalaCortexValue, Double orbitofrontalCortexValue, Double rew) {
        return null;
    }

    public Double thalamusExecuteEquation(Double sensoryInputValue) {
        return null;
    }

    public Double weightAmygdalaExecuteEquation(Double alpha, Double sensoryInputValue, Double rew, Double amygdalaCortexValue) {
        return null;
    }

    public Double weightOrbitofrontalExecuteEquation(Double beta, Double sensoryInputValue, Double rew, Double orbitofrontalCortexValue) {
        return null;
    }

    public Double amygdalaEquation(Double weightAmygdala, Double sensoryInputValue) {
        return null;
    }

    public Double orbitofrontalEquation(Double weightOrbitofrontal, Double sensoryInputValue) {
        return null;
    }

    public void rewExecute(Runnable runnable) {
        runnable.run();
    }
}
