package com.tecsup.evahuaytalla.repository;

import com.tecsup.evahuaytalla.entity.NroOrdenC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NroOrdenCRepository extends JpaRepository<NroOrdenC, Long> {
}
