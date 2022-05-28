import contract.Bel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
public class Belbic implements Bel, Serializable {
    private Double alpha;
    private Double beta;
    private Double sensoryInputValue;
    private Double amygdalaValue;
    private Double orbitofrontalCortexValue;
    private Double weightAmygdala;
    private Double weightOrbitofrontal;
    private Double rewValue;

    public void initParamsBelbic(Double alpha, Double beta, Double rewValue, Double amygdalaValue, Double orbitofrontalCortexValue, Double weightAmygdala, Double weightOrbitofrontal) {
        this.alpha = alpha;
        this.beta = beta;
        this.rewValue = rewValue;
        this.amygdalaValue = amygdalaValue;
        this.orbitofrontalCortexValue = orbitofrontalCortexValue;
        this.weightAmygdala = weightAmygdala;
        this.weightOrbitofrontal = weightOrbitofrontal;
    }

    public Double run() {
        Map<String, Double> resultSensoryCortex = sensoryCortex(
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

        Double resultOrbitofrontalCortex = orbitofrontalCortex(
                weightOrbitofrontal,
                sensoryInputValue,
                rewValue
        );

        this.orbitofrontalCortexValue = resultOrbitofrontalCortex;

        Double resultAmygdala = amygdala(
                weightAmygdala,
                sensoryInputValue,
                rewValue
        );

        this.amygdalaValue = resultAmygdala;

        return (amygdalaValue - orbitofrontalCortexValue) * rewValue;
    }
}
