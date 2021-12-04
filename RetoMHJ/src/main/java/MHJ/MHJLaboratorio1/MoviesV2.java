package MHJ.MHJLaboratorio1;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public class MoviesV2 extends Movies {

    public MoviesV2() {

    }

    public MoviesV2(int _id, String _title, int _year, String _lang, String img, String _tipoPeli) {
        super(_id, _title, _year, img, _tipoPeli);
        this.lang = _lang;
    }

    private String lang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
