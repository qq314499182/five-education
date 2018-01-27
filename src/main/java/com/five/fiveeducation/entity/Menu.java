package com.five.fiveeducation.entity;

import java.util.List;

public class Menu {

    private List<Lectuer> lectuers ;

    private List<Sponsor> sponsors;

    private List<TrainSubject> trainSubjects;

    public List<Lectuer> getLectuers() {
        return lectuers;
    }

    public void setLectuers(List<Lectuer> lectuers) {
        this.lectuers = lectuers;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    public List<TrainSubject> getTrainSubjects() {
        return trainSubjects;
    }

    public void setTrainSubjects(List<TrainSubject> trainSubjects) {
        this.trainSubjects = trainSubjects;
    }
}
