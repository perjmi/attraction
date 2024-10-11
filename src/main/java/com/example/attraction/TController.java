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

    @PostMapping("/save1")
    public String saveAttraction1(@ModelAttribute Tattraction t, @RequestParam("place.city_id") int cityId, Model model) throws Exception {
        // Simulate fetching cities (this should come from a DB in a real app)
        List<City> places = Arrays.asList(new City("Roskilde", 1), new City("Cph", 2));

        // Find the city based on the city_id
        City selectedCity = places.stream()
                .filter(city -> city.getCity_id() == cityId)
                .findFirst()
                .orElseThrow(() -> new Exception("City not found"));

        // Set the city to the attraction
        t.setPlace(selectedCity);

        System.out.println(t);
        model.addAttribute("attraction", t);
        model.addAttribute("places", places);
        return "redirect:/AddTattraction";
    }

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute Tattraction t, Model model) throws Exception {
        System.out.println(t);
        System.out.println("City ID: " + t.getPlace().getCity_id());
        t.setPlace(new City("Hillerød",3));
        model.addAttribute("attraction", t);
        return "redirect:/add";
    }



}
