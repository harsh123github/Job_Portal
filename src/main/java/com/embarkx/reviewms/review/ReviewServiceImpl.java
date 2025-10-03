package com.embarkx.reviewms.review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

//    @Autowired
//    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyID(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId,Review review) {
        if (review != null && companyId!=null) {
            review.setCompanyID(companyId);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Review getReview(Long reviewId) {
       return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview( Long reviewId,
                                Review updatedreview) {
        Review review=reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setCompanyID(updatedreview.getCompanyID());
            review.setTitle(updatedreview.getTitle());
            review.setDescription(updatedreview.getDescription());
            review.setRating(updatedreview.getRating());
            reviewRepository.save(updatedreview);
            return true;
        }

        else{
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long reviewId) {

        Review review=reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {

            reviewRepository.delete(review);
            return true;
        }
        else {
            return false;
        }
    }
}