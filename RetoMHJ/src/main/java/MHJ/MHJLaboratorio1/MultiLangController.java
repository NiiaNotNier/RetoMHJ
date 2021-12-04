package MHJ.MHJLaboratorio1;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiLangController {

    @GetMapping("/test")
    public String Test(Locale locale) {
        var messages = ResourceBundle.getBundle("i18n\\messages", locale);
        return messages.getString("Main.Movies");
    }
}