package com.shubham.Firstspring.Services;

import com.shubham.Firstspring.Models.Company;
import com.shubham.Firstspring.Models.Reviews;
import com.shubham.Firstspring.Repositories.CompanyRepository;
import com.shubham.Firstspring.Repositories.ReviewRepository;
import com.shubham.Firstspring.Services.Interfaces.CompanyServiceInterface;
import com.shubham.Firstspring.Services.Interfaces.ReviewServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewService implements ReviewServiceInterface {
    private final ReviewRepository reviewRepository;
    CompanyRepository companyRepository ;

    public ReviewService(ReviewRepository reviewRepository, CompanyRepository companyRepository){
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Reviews> getReviews(Long id) {
       return reviewRepository.findByCompanyId(id);
    }

    @Override
    public boolean addReviewForComapny(Long id, Reviews review) {
        Company company = companyRepository.findById(id).orElse(null);
        if(company==null)return false;
        review.setCompany(company);
        reviewRepository.save(review);
        return true;
    }

    @Override
    public Reviews getReviewByid(Long id, Long reviewId) {
        List<Reviews> reviews = reviewRepository.findByCompanyId(id);
        if(reviews!=null){
            for(Reviews reviews1 : reviews){
                if(reviews1.getId().equals(reviews1))
                    return reviews1;
            }
        }

        return null;
    }

    @Override
    public boolean updateReview(Long id, Long reviewId, Reviews review) {
        Company company = companyRepository.findById(id).orElse(null);
        if(company==null)return false;

        Reviews reviewstoupdate = reviewRepository.findById(reviewId).orElse(null);
        if(reviewstoupdate==null)return false;

        reviewstoupdate.setCompany(company);
        reviewstoupdate.setContent(review.getContent());
        reviewstoupdate.setType(review.isType());

        reviewRepository.save(reviewstoupdate);

        return true;
    }

    @Override
    public boolean deleteReview(Long id, Long reviewId) {
        if(!reviewRepository.existsById(reviewId))return false;
        reviewRepository.deleteById(reviewId);
        return true;
    }

}
