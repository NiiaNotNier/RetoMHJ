package MHJ.MHJLaboratorio1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/testHtml")
    public ModelAndView Test() {
        return new ModelAndView("test");
    }
}
