import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class EventLightsProcessorTest {
    @InjectMocks
    EventLightsProcessor sut;


    @Test
    void givenLightsCommandAndCoordinatesInRange_whenProcessingLightsBasedOnCommandCoordinates_thenLightsOnEqualTheExpected() {
        // Arrange
        final int EXPECTED_LIGHTS_ON = 1000000;

        CommandCoordinates commandCoordinates = new CommandCoordinates();
        commandCoordinates.setLightsCommand("on");
        commandCoordinates.setMinX(0);
        commandCoordinates.setMinY(0);
        commandCoordinates.setMaxX(999);
        commandCoordinates.setMaxY(999);

        // Act
        sut.processLights(commandCoordinates);

        // Assert
        assertThat(sut.getLightsStatus()).isEqualTo(EXPECTED_LIGHTS_ON);
    }

    @Test
    void givenLightsCommandAndCoordinatesInRange_whenProcessingLightsBrightnessBasedOnCommandCoordinates_thenLightsOnEqualTheExpected() {
        // Arrange
        final int EXPECTED_LIGHTS_ON = 1000000;

        CommandCoordinates commandCoordinates = new CommandCoordinates();
        commandCoordinates.setLightsCommand("on");
        commandCoordinates.setMinX(0);
        commandCoordinates.setMinY(0);
        commandCoordinates.setMaxX(999);
        commandCoordinates.setMaxY(999);

        // Act
        sut.processLightsBrightness(commandCoordinates);

        // Assert
        assertThat(sut.getLightsStatus()).isEqualTo(EXPECTED_LIGHTS_ON);
    }

    @Test
    void givenLightsCommandIsOnAndCoordinatesNotInRange_whenProcessingLightsBasedOnCommandCoordinates_then() {
        // Arrange
        CommandCoordinates commandCoordinates = new CommandCoordinates();
        commandCoordinates.setLightsCommand("on");
        commandCoordinates.setMinX(0);
        commandCoordinates.setMinY(0);
        commandCoordinates.setMaxX(9999);
        commandCoordinates.setMaxY(999);

        // Act & Assert
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> sut.processLights(commandCoordinates));
    }
}
