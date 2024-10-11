package com.example.attraction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class TController {

    @GetMapping("/add")
    public String addAttraction(Model model) {
        List<City> places = new ArrayList<>();
        places.add(new City("Roskilde",1));
        places.add(new City("Cph",2));
        Tattraction t = new Tattraction("Vikingemuseet", "Genoplev den rå fortid", places.get(0));
        model.addAttribute("attraction", t);
        model.addAttribute("places", places);
        return "AddTattraction";
    }
}
