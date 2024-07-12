package testI18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.stream.Stream;

public class TestLocalizationServiceImpl {

    @MethodSource
    @ParameterizedTest
    public void testLocalizationServiceImpl(String welcome, Country country) {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        String result = localizationService.locale(country);

        Assertions.assertEquals(result, welcome);
    }

    public static Stream<Arguments> testLocalizationServiceImpl() {
        return Stream.of(Arguments.of("Добро пожаловать", Country.RUSSIA),
                Arguments.of("Welcome", Country.USA),
                Arguments.of("Welcome", Country.BRAZIL),
                Arguments.of("Welcome", Country.GERMANY));
    }
}
