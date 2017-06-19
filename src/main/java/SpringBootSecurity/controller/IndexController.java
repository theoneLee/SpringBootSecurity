package SpringBootSecurity.controller;

import SpringBootSecurity.entity.wrapper.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lee on 2017/6/19 0019.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){
        Msg msg=new Msg("test","testcontent","admin_info");
        model.addAttribute("msg",msg);
        return "index";
    }
}
