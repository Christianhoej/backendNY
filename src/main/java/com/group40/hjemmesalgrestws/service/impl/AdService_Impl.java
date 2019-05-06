package com.group40.hjemmesalgrestws.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.group40.hjemmesalgrestws.dtos.AdDTO;
import com.group40.hjemmesalgrestws.entitiy.AdEntity;
import com.group40.hjemmesalgrestws.repository.AdRepository;
import com.group40.hjemmesalgrestws.service.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdService_Impl implements AdService {
    @Autowired
    AdRepository adRepository;

    @Override
    public AdDTO createAd(AdDTO adDetails) {
        AdEntity adEntity = new AdEntity();
        BeanUtils.copyProperties(adDetails, adEntity);
        AdEntity storedAdDetails = adRepository.save(adEntity);
        AdDTO returnValue = new AdDTO();
        BeanUtils.copyProperties(storedAdDetails, returnValue);

        return returnValue;

    }
}
