package be.atelierrafaelaferreira.gendointegration.temp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralTests {

    @Test
    public void testRegexForFirstAndLastName() {

        Pattern pattern = Pattern.compile("^(\\S\\s-\\s)?[^\\s]+");
        final String str = "O - Alex Andre Lopes de Oliveira";
        Matcher matcher = pattern.matcher(str);

        matcher.find();

        for (int i = 0; i < matcher.groupCount(); i++) {
            System.out.println("group " + i + " - " + matcher.group(i));
        }

        System.out.println(str.substring(matcher.end()).trim());
    }
}
