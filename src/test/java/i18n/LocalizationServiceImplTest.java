package i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    @Test
    void locale() {
        LocalizationService localizationService = new LocalizationServiceImpl();

        assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
        assertEquals("Welcome", localizationService.locale(Country.USA));
        assertNotEquals("Welcome", localizationService.locale(Country.RUSSIA));
    }
}