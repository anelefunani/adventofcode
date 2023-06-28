package za.co.code.aoc.tuningtrouble;

import za.co.code.aoc.tuningtrouble.controller.TuningTroubleController;
import za.co.code.aoc.tuningtrouble.service.TuningService;
import za.co.code.aoc.tuningtrouble.service.impl.TuningServiceComplex;
import za.co.code.aoc.tuningtrouble.service.impl.TuningServiceSimple;

public class Application {

    public static void main(String[] args) {
        final String fileLocation = "tuning-trouble/src/main/resources/input.data";
        System.out.println("Simple");
        tune(new TuningServiceSimple(fileLocation));
        System.out.println("Complex");
        tune(new TuningServiceComplex(fileLocation));
    }

    private static void tune(TuningService tuningService) {
        TuningTroubleController tuningTroubleController = new TuningTroubleController(
                tuningService
        );
        System.out.println("Marker index: " + tuningTroubleController.getMarkerIndex());
    }

}
