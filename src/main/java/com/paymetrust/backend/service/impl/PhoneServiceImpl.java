package com.paymetrust.backend.service.impl;

import com.paymetrust.backend.entity.Phone;
import com.paymetrust.backend.repository.PhoneRepository;
import com.paymetrust.backend.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of PhoneService interface.
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found with id: " + id));
    }

    @Override
    public List<Phone> findByPhoneNumber(String phoneNumber) {
        return phoneRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Phone> findByCarrierName(String carrierName) {
        return phoneRepository.findByCarrierName(carrierName);
    }

    @Override
    public List<Phone> findByCreationDate(LocalDate creationDate) {
        return phoneRepository.findByCreationDate(creationDate);
    }

    @Override
    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone updatePhone(Long id, Phone phoneDetails) {
        Phone phone = getPhoneById(id);
        
        phone.setPhoneNumber(phoneDetails.getPhoneNumber());
        phone.setCarrierName(phoneDetails.getCarrierName());
        phone.setDetails(phoneDetails.getDetails());
        phone.setUpdatedAt(LocalDateTime.now());
        
        return phoneRepository.save(phone);
    }

    @Override
    public void deletePhone(Long id) {
        Phone phone = getPhoneById(id);
        phoneRepository.delete(phone);
    }
}