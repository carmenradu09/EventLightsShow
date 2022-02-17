public class CommandCoordinates {
    private String lightsCommand;
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public CommandCoordinates() {
        this.lightsCommand = "";
        this.minX = 0;
        this.maxX = 0;
        this.minY = 0;
        this.maxY = 0;
    }

    public String getLightsCommand() {
        return lightsCommand;
    }

    public void setLightsCommand(String lightsCommand) {
        this.lightsCommand = lightsCommand;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
}
