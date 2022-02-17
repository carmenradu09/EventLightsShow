import java.util.Objects;

public class EventLightsProcessor {
    private final int[][] lightsArray = new int[1000][1000];

    public void processLights(CommandCoordinates commandCoordinates) {
        final int minX = commandCoordinates.getMinX();
        final int maxX = commandCoordinates.getMaxX();

        final int minY = commandCoordinates.getMinY();
        final int maxY = commandCoordinates.getMaxY();

        processLightsBasedOn(commandCoordinates, minX, maxX, minY, maxY);
    }

    public void processLightsBrightness(CommandCoordinates commandCoordinates) {
        final int minX = commandCoordinates.getMinX();
        final int maxX = commandCoordinates.getMaxX();

        final int minY = commandCoordinates.getMinY();
        final int maxY = commandCoordinates.getMaxY();

        processLightsBrightnessBasedOn(commandCoordinates, minX, maxX, minY, maxY);
    }

    public int getLightsStatus() {
        int lightsCounter = 0;
        for (int[] ints : lightsArray) {
            for (int y = 0; y < lightsArray.length; y++) {
                if (ints[y] > 0) {
                    lightsCounter = lightsCounter + ints[y];
                }
            }
        }

        return lightsCounter;
    }

    private void processLightsBrightnessBasedOn(CommandCoordinates commandCoordinates,
                                                int minX, int maxX, int minY, int maxY) {
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (Objects.equals(commandCoordinates.getLightsCommand(), "on")) {
                    lightsArray[x][y]++;
                } else if (Objects.equals(commandCoordinates.getLightsCommand(), "off")) {
                    lightsArray[x][y] = lightsArray[x][y] > 0 ? lightsArray[x][y] - 1 : 0;
                } else {
                    lightsArray[x][y] = lightsArray[x][y] + 2;
                }
            }
        }
    }

    private void processLightsBasedOn(CommandCoordinates commandCoordinates, int minX, int maxX, int minY, int maxY) {
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (Objects.equals(commandCoordinates.getLightsCommand(), "on")) {
                    lightsArray[x][y] = 1;
                } else if ("off".equals(commandCoordinates.getLightsCommand())) {
                    lightsArray[x][y] = 0;
                } else {
                    lightsArray[x][y] = lightsArray[x][y] == 1 ? 0 : 1;
                }
            }
        }
    }
}