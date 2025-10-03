package com.embarkx.reviewms.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyID(Long companyID);
}
