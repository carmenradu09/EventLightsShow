import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CommandCoordinatesTest {

    @Test
    void givenValidCommandCoordinatesWithDefaultProperties_whenGetCommandCoordinates_thenDefaultsAreReturned() {
        // Arrange
        CommandCoordinates commandCoordinates = new CommandCoordinates();

        // Act
        String lightsCommand = commandCoordinates.getLightsCommand();
        int minX = commandCoordinates.getMinX();
        int minY = commandCoordinates.getMinY();
        int maxX = commandCoordinates.getMaxX();
        int maxY = commandCoordinates.getMaxY();

        // Assert
        assertThat(lightsCommand).isEqualTo("");
        assertThat(minX).isZero();
        assertThat(maxX).isZero();
        assertThat(minY).isZero();
        assertThat(maxY).isZero();

    }

}