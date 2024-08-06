package com.example.exammanagement.utility.entity;

import jakarta.persistence.PrePersist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


class CoreEntityListener {

    @PrePersist
    public void prePersist(CoreEntity coreEntity) {
        coreEntity.setStatus("A");
    }
}
