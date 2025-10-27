package com.example.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cvUpdated", "October 2025");
        model.addAttribute("aboutMeEng",
            "I am a motivated and ambitious Computer Science student with strong interests in game development and software engineering. " +
            "Currently studying Business Information Technology at TH Koeln, with previous experience in Games Engineering at TUM. " +
            "I am seeking opportunities to apply my programming knowledge in real-world IT environments and continue developing my skills.");
        model.addAttribute("aboutMeGer",
            "Ich bin ein motivierter und ehrgeiziger Informatikstudent mit großem Interesse an Spieleentwicklung und Software Engineering. " +
            "Derzeit studiere ich Wirtschaftsinformatik an der TH Köln und habe zuvor Games Engineering an der TU Muenchen studiert. " +
            "Ich suche nach Moeglichkeiten, meine Programmierkenntnisse praktisch einzusetzen und meine Faehigkeiten weiterzuentwickeln.");

        // Move projects into the home model so the single page can render them.
        List<Project> projectList = List.of(
    new Project("Space Shooter - Playable Demo",
        "WebGL build of the Space Shooter playable in browser.",
        List.of("Unity", "C#", "WebGL"),
        "https://stilixdd.itch.io/spaceshooter",
        "/img/projects/SpaceShooter_thumbnail.png"),
    new Project("First Person Shooter (In Progress)",
        "Prototype of a first-person shooter focused on gameplay mechanics.",
        List.of("Unity", "OpenGL", "Game Development", "C#"),
        "#",
        "/img/projects/question.jpg"),
    new Project("Fornelli.de Website",
        "Built a responsive company website using WordPress; optimized SEO and performance.",
        List.of("HTML", "CSS", "Java", "WordPress"),
        "https://www.fornelli.de/",
        "/img/projects/fornellithumbnail.jpg")
);

        model.addAttribute("projects", projectList);

        return "home"; // single page template
    }

    // Backward compatibility: /projects -> anchor on the one-pager
    @GetMapping("/projects")
    public String projects() {
        return "redirect:/#projects";
    }
}
