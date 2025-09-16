package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GeoServiceImplTest {

    @ParameterizedTest
    @CsvSource({
            "127.0.0.1, null, null, null, 0",
            "172.0.32.11, Moscow, Russia, Lenina, 15",
            "96.44.183.149, New York, USA, 10th Avenue, 32"})
    void byIp(String ipAddress, String expectedCity, String expectedCountry, String expectedStreet, int expectedBuilding) {
        GeoService geoService = new GeoServiceImpl();
        Location actualLocation = geoService.byIp(ipAddress);
        if (expectedCity == null) {
            assertEquals(null, actualLocation);
        } else {
            Assertions.assertEquals(actualLocation.getCountry(), geoService.byIp(ipAddress).getCountry());
            Assertions.assertEquals(actualLocation.getCity(), geoService.byIp(ipAddress).getCity());
            Assertions.assertEquals(actualLocation.getStreet(), geoService.byIp(ipAddress).getStreet());
            Assertions.assertEquals(actualLocation.getBuiling(), geoService.byIp(ipAddress).getBuiling());
        }
    }
}