# belbic4j

A simple *BELBIC* algorithm library for Java language .

This project aims to make the task of creating and writing wiki documents in Java much easier.

## How to use

The artifact is in the [Maven](http://search.maven.org/) repository so all you need to do is add it as a dependency in your project.

###### Maven
----------

``` xml
 <dependency>
      <groupId>com.github.gustavo053</groupId>
      <artifactId>belbic4j</artifactId>
      <version>1.0.0</version>
</dependency> 
```

### Usage belbic

- Instance belbic controller:
```java
Belbic belbic = new Belbic();
```

- Set the initial parameters for the algorithm:
```java
belbic.initParams(Double alpha, Double beta, Double amygdalaValue, Double orbitofrontalCortexValue, Double weightAmygdala, Double weightOrbitofrontal);
```
These parameters must be adjusted for each issue (especially alpha and beta). 

Generally, the initial values ​​of the amygdala and orbitofrontal cortex are set to zero so as not to influence learning algorithm.

- Incremental alpha and beta update:
```java
belbic.setAlpha(Double alpha);
belbic.setBeta(Double beta);
```

- Set values for SI block and reward algorithm:
```java
belbic.setSensoryInputValue(Double sensoryInputValue);
belbic.setRewValue(Math.abs(Double rewValue);
```

- Run the algorithm and get the control signal:
```java
double u = belbic.run();
```

### Full usage example
    
```java
import core.Belbic;
import java.util.Arrays;

public class BelbicTestRun {
    //amplifier
    private static double ka = 10;
    private static double taua = 0.1;

    //exciter
    private static double ke = 1;
    private static double taue = 1;

    //generator
    private static double kg = 1;
    private static double taug = 1;

    //sensor
    private static double kr = 1;
    private static double taur = 0.06;

    private static double tMax = 60;
    private static double h = 0.01;
    private static long nPoints = Math.round(tMax / h);

    private static double uMax = 3.3;

    private static double[] vRef = new double[Integer.parseInt(String.valueOf(nPoints))];
    private static double[] vr = new double[Integer.parseInt(String.valueOf(nPoints))];
    private static double[] vf = new double[Integer.parseInt(String.valueOf(nPoints))];
    private static double[] vt = new double[Integer.parseInt(String.valueOf(nPoints))];
    private static double[] vs = new double[Integer.parseInt(String.valueOf(nPoints))];
    private static double[] ve = new double[Integer.parseInt(String.valueOf(nPoints))];

    private static double[] uPlot = new double[Integer.parseInt(String.valueOf(nPoints))];
    private static double[] ePlot = new double[Integer.parseInt(String.valueOf(nPoints))];

    //private double[] tPlot;

    static void amplifier(Integer i, Double u) {
        vr[i] = vr[i - 1] + (h/taua) * (-vr[i - 1]) + ka * u;
    }

    static void exciter(Integer i) {
        vf[i] = vf[i - 1] + (h/taue) * (-vf[i - 1] + ke * vr[i]);
    }

    static void generator(Integer i) {
        vt[i] = vt[i - 1] + (h/taug) * (-vt[i - 1] + kg * vf[i]);
    }

    static Double sensor(Integer i) {
        return vs[i] = vs[i - 1] + (h/taur) * (-vs[i - 1] + kr * vt[i]);
    }

    private static double eant = 0;
    private static double iant = 0;

    static Double pid(Double e) {
        double kp = 3.38;
        double ki = 0.58;
        double kd = 0.63;
        double iMax = 3.3;

        double P = e * kp;
        double I = iant + (ki * h) * (e + eant);
        double D = (kd/h) * (e - eant);

        if (I > iMax) {
            I = iMax;
        } else if (I <= 0) {
            I = 0;
        }

        eant = e;
        iant = I;
        return P + I + D;
    }

    public static void main(String[] args) {
        Arrays.fill(vRef, 2);
        
        //belbic here
        Belbic belbic = new Belbic();
        belbic.initParams(0.45, 0.01, 0.0, 0.0, 0.81, 1.0);

        for (int i = 1; i < nPoints; i++) {
            ve[i] = vRef[i - 1] - vs[i - 1];

            belbic.setAlpha(belbic.getAlpha() * h);
            belbic.setBeta(belbic.getBeta() * h);

            belbic.setSensoryInputValue(pid(ve[i]));
            belbic.setRewValue(Math.abs(ve[i]));

            double u = belbic.run();

            if (u > uMax) {
                u = uMax;
            } else if (u < 0){
                u = 0;
            }

            amplifier(i, u);
            exciter(i);
            generator(i);
            double sensorValue = sensor(i);

            System.out.println(sensorValue);
        }
    }
}
```