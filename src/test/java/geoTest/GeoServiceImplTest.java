package geoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

public class GeoServiceImplTest {


    @MethodSource
    @ParameterizedTest
    public void testGeoServiceImplParameters(String data, Location result) {
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location location = geoService.byIp(data);

//      assertThat(location).isEqualTo(result);
        Assertions.assertEquals(location, result);
    }

    public static Stream<Arguments> testGeoServiceImplParameters() {
        return Stream.of(Arguments.of("127.0.0.1", new Location(null, null, null, 0)),
                Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32)),
                Arguments.of("172.13.312313.1313.13", new Location("Moscow", Country.RUSSIA, null, 0)),
                Arguments.of("96.23.244242.24", new Location("New York", Country.USA, null, 0)),
                Arguments.of("21", null));
    }
}
