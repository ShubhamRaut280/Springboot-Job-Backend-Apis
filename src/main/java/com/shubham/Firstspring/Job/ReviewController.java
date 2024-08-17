package com.shubham.Firstspring.Job;

import com.shubham.Firstspring.Models.Company;
import com.shubham.Firstspring.Models.Reviews;
import com.shubham.Firstspring.Services.CompanyService;
import com.shubham.Firstspring.Services.Interfaces.ReviewServiceInterface;
import com.shubham.Firstspring.Services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {
     ReviewService reviewService;
     ReviewController(ReviewService service) {
        this.reviewService = service;
    }


    @GetMapping
    public ResponseEntity<List<Reviews>> getReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getReviews(companyId), OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Reviews reviews) {
        boolean res = reviewService.addReviewForComapny(companyId, reviews);
        if (res) return new ResponseEntity<>("Successfully added ", CREATED);

        return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Reviews> getReviewByid(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Reviews res = reviewService.getReviewByid(companyId, reviewId);
        if (res == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res, OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Reviews review) {
        boolean res = reviewService.updateReview(companyId, reviewId, review);
        if (res) return new ResponseEntity<>("Review updated succesfully", OK);

        return new ResponseEntity<>("Cound't update review or not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean res = reviewService.deleteReview(companyId, reviewId);
        if (res) return new ResponseEntity<>("Review deleted succesfully", OK);
        return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
    }

}
