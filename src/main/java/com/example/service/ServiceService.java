package com.example.service;

import com.example.model.ServiceEntity;
import com.example.repository.ServiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceEntity> findAll() {
        return serviceRepository.findAll();
    }

    public Optional<ServiceEntity> findById(UUID id) {
        return serviceRepository.findById(id);
    }

    public List<ServiceEntity> findByCategory(String category) {
        return serviceRepository.findByServiceCategory(category);
    }

    public ServiceEntity save(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    public void deleteById(UUID id) {
        serviceRepository.deleteById(id);
    }
}
