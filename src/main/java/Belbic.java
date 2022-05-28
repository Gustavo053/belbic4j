import equation.BelbicEquation;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
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

        return (amygdalaValue - orbitofrontalCortexValue) * rewValue;
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
        return BelbicEquation.orbitofrontalEquation(weightOrbitofrontal, sensoryInputValue) * rew;
    }

    private Double amygdalaExecute(
            Double weightAmygdala,
            Double sensoryInputValue,
            Double rew
    ) {
        return BelbicEquation.amygdalaEquation(weightAmygdala, sensoryInputValue) * rew;
    }
}
