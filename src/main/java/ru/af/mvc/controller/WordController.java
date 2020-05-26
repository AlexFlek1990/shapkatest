package ru.af.mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.af.service.dto.WordDto;
import ru.af.service.dto.WordService;

import java.security.Principal;
import java.util.List;

@RequestMapping("/words")
@Controller
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @RequestMapping(value = "/addwords", method = RequestMethod.GET)
    public ModelAndView getAllWords(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addwords");
        List<WordDto> wordList = wordService.getAllWordsByUser(principal.getName());
        modelAndView.getModelMap().addAttribute("wordList", wordList);
        return modelAndView;
    }

    @RequestMapping(value = "/addwords", method = RequestMethod.POST)
    public ModelAndView addWord(@RequestBody @ModelAttribute("word") String word, Principal principal) {
        String userName = principal.getName();
        WordDto wordDto = new WordDto();
        wordDto.setValue(word);
        wordService.saveWord(wordDto, userName);
        List<WordDto> wordList = wordService.getAllWordsByUser(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("wordList", wordList);
        modelAndView.setViewName("addwords");
        return modelAndView;
    }


}
