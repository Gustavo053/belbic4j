package core;

import equation.BelbicEquation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Belbic implements Serializable {
    private Double alpha;
    private Double beta;
    private Double sensoryInputValue;
    private Double amygdalaValue;
    private Double orbitofrontalCortexValue;
    private Double weightAmygdala;
    private Double weightOrbitofrontal;
    private Double rewValue;

    public void initParams(Double alpha, Double beta, Double amygdalaValue, Double orbitofrontalCortexValue, Double weightAmygdala, Double weightOrbitofrontal) {
        this.alpha = alpha;
        this.beta = beta;
        this.rewValue = rewValue;
        this.amygdalaValue = amygdalaValue;
        this.orbitofrontalCortexValue = orbitofrontalCortexValue;
        this.weightAmygdala = weightAmygdala;
        this.weightOrbitofrontal = weightOrbitofrontal;
    }

    public Double run() {
        Map<String, Double> resultSensoryCortex = sensoryCortexExecute(
                alpha,
                beta,
                sensoryInputValue,
                rewValue,
                amygdalaValue,
                orbitofrontalCortexValue,
                weightAmygdala,
                weightOrbitofrontal
        );

        this.weightAmygdala = resultSensoryCortex.get("newWeightAmygdala");
        this.weightOrbitofrontal = resultSensoryCortex.get("newWeightOrbitofrontal");

        Double resultOrbitofrontalCortex = orbitofrontalCortexExecute(
                weightOrbitofrontal,
                sensoryInputValue,
                rewValue
        );

        this.orbitofrontalCortexValue = resultOrbitofrontalCortex;

        Double resultAmygdala = amygdalaExecute(
                weightAmygdala,
                sensoryInputValue,
                rewValue
        );

        this.amygdalaValue = resultAmygdala;

        Double controlSignal = amygdalaValue - orbitofrontalCortexValue;
        return controlSignal;
    }

    private Map<String, Double> sensoryCortexExecute(
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
                BelbicEquation.weightAmygdalaEquation(alpha, sensoryInputValue, rew, amygdalaValue) + weightAmygdala
        );
        result.put(
                "newWeightOrbitofrontal",
                BelbicEquation.weightOrbitofrontalEquation(beta, sensoryInputValue, rew, orbitofrontalCortexValue) + weightOrbitofrontal
        );

        return result;
    }

    private Double orbitofrontalCortexExecute(
            Double weightOrbitofrontal,
            Double sensoryInputValue,
            Double rew
    ) {
        return BelbicEquation.orbitofrontalEquation(weightOrbitofrontal, sensoryInputValue);
    }

    private Double amygdalaExecute(
            Double weightAmygdala,
            Double sensoryInputValue,
            Double rew
    ) {
        return BelbicEquation.amygdalaEquation(weightAmygdala, sensoryInputValue);
    }

    public Double getAlpha() {
        return alpha;
    }

    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    public Double getBeta() {
        return beta;
    }

    public void setBeta(Double beta) {
        this.beta = beta;
    }

    public Double getSensoryInputValue() {
        return sensoryInputValue;
    }

    public void setSensoryInputValue(Double sensoryInputValue) {
        this.sensoryInputValue = sensoryInputValue;
    }

    public Double getAmygdalaValue() {
        return amygdalaValue;
    }

    public void setAmygdalaValue(Double amygdalaValue) {
        this.amygdalaValue = amygdalaValue;
    }

    public Double getOrbitofrontalCortexValue() {
        return orbitofrontalCortexValue;
    }

    public void setOrbitofrontalCortexValue(Double orbitofrontalCortexValue) {
        this.orbitofrontalCortexValue = orbitofrontalCortexValue;
    }

    public Double getWeightAmygdala() {
        return weightAmygdala;
    }

    public void setWeightAmygdala(Double weightAmygdala) {
        this.weightAmygdala = weightAmygdala;
    }

    public Double getWeightOrbitofrontal() {
        return weightOrbitofrontal;
    }

    public void setWeightOrbitofrontal(Double weightOrbitofrontal) {
        this.weightOrbitofrontal = weightOrbitofrontal;
    }

    public Double getRewValue() {
        return rewValue;
    }

    public void setRewValue(Double rewValue) {
        this.rewValue = rewValue;
    }
}
