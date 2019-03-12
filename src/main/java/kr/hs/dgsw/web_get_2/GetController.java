package kr.hs.dgsw.web_get_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class GetController {

    @GetMapping("/gretting")
    public String sayHello(@RequestParam(
                                    required = false,
                                    defaultValue = "HELLO"
                            ) String say,
                           @RequestParam(
                                   required = false,
                                   defaultValue = "NONAME"
                           ) String to
    ) {
        return  say+ " " + to;
    }

    @GetMapping(
            value = {
                    "/gretting1/{say}/{to}",
                    "/gretting1/{say}",
                    "/gretting1//{to}",
                    "/gretting1"
            }
            )
    public String sayHello1(@PathVariable Optional<String> say, @PathVariable Optional<String> to) {
        String tmpSay = say.isPresent() ? say.get() : "HELLO";
        String tmpTo = to.isPresent() ? to.get() : "NONAME";
        return tmpSay+" "+tmpTo;
    }
}
