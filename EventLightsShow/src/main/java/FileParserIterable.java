import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

public class FileParserIterable implements Iterator<CommandCoordinates> {
    private BufferedReader bufferedReader = null;

    public FileParserIterable(String filePath) {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(filePath));
//            this.bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.filePath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        boolean ready = false;
        try {
            ready = this.bufferedReader.ready();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ready;
    }

    @Override
    public CommandCoordinates next() {
        String nextLine;
        CommandCoordinates commandCoordinates = null;
        try {
            nextLine = this.bufferedReader.readLine();
            commandCoordinates = getCommandCoordinates(nextLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commandCoordinates;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported!");
    }

    private static CommandCoordinates getCommandCoordinates(String lineFromFile) {
        final String[] lineElements = lineFromFile.split("[\\s,]+");

        final CommandCoordinates commandCoordinates = new CommandCoordinates();

        if (Objects.equals(lineElements[0], "turn")) {
            commandCoordinates.setLightsCommand(lineElements[1]);
            commandCoordinates.setMinX(Integer.parseInt(lineElements[2]));
            commandCoordinates.setMinY(Integer.parseInt(lineElements[3]));
            commandCoordinates.setMaxX(Integer.parseInt(lineElements[5]));
            commandCoordinates.setMaxY(Integer.parseInt(lineElements[6]));
        } else {
            commandCoordinates.setLightsCommand(lineElements[0]);
            commandCoordinates.setMinX(Integer.parseInt((lineElements[1])));
            commandCoordinates.setMinY(Integer.parseInt(lineElements[2]));
            commandCoordinates.setMaxX(Integer.parseInt(lineElements[4]));
            commandCoordinates.setMaxY(Integer.parseInt(lineElements[5]));
        }

        return commandCoordinates;
    }
}
