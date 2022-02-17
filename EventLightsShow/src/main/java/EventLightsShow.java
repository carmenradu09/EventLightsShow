public class EventLightsShow {
    public static void main(String[] args) {
        final FileParserIterable fileParserIterable = new FileParserIterable(args[0]);

        final EventLightsProcessor firstLightsProcessor = new EventLightsProcessor();
        final EventLightsProcessor secondLightsProcessor = new EventLightsProcessor();

        while (fileParserIterable.hasNext()) {
            final CommandCoordinates next = fileParserIterable.next();

            firstLightsProcessor.processLights(next);
            secondLightsProcessor.processLightsBrightness(next);
        }

        System.out.println("Total lights on: " + firstLightsProcessor.getLightsStatus());
        System.out.println("Total lights on after system upgrade: " + secondLightsProcessor.getLightsStatus());
    }
}

