package com.five.fiveeducation.service;

import com.five.fiveeducation.dao.SponsorDao;
import com.five.fiveeducation.entity.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorService {

    @Autowired
    private SponsorDao sponsorMeunDao;

    public List<Sponsor> findAll() {
        return sponsorMeunDao.findAll();
    }
}
