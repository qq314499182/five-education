package com.five.fiveeducation.service;

import com.five.fiveeducation.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private TrainSubjectMenuService trainSubjectMenuService;

    @Autowired
    private LectuerService lectuerMenuService;

    @Autowired
    private SponsorService sponsorMenuService;


    public Menu findAll() {
        Menu menu = new Menu();
        menu.setTrainSubjects(trainSubjectMenuService.findAll());
        //menu.setLectuers(lectuerMenuService.findAll());
        //menu.setSponsors(sponsorMenuService.findAll());
       return menu;
    }
}
