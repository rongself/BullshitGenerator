package com.ronccc.bullshit.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ronccc.bullshit.models.Article;
import com.ronccc.bullshit.models.BullshitWord;
import com.ronccc.bullshit.services.BullshitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BullshitController {

    @Autowired
    private BullshitService bullshitService;

    @RequestMapping("/")
    String home(Article article) throws IOException {
        return bullshitService.generate(article);
    }
}
