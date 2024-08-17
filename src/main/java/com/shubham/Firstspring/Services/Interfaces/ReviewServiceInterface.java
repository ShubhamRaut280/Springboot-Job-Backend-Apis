package com.shubham.Firstspring.Services.Interfaces;

import com.shubham.Firstspring.Models.Company;
import com.shubham.Firstspring.Models.Reviews;

import java.util.List;

public interface ReviewServiceInterface {
    List<Reviews> getReviews(Long id); // get reviews of company
    boolean addReviewForComapny(Long id , Reviews review);
    Reviews getReviewByid(Long id , Long reviewId);
    boolean updateReview(Long id , Long reviewId , Reviews review);
    boolean deleteReview(Long id , Long reviewId);
}
