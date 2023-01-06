package challenge.server.datamodellingtest;

import challenge.server.datamodellingtest.entity.Habit;
import challenge.server.datamodellingtest.entity.Report;
import challenge.server.datamodellingtest.entity.Review;
import challenge.server.datamodellingtest.mapper.HabitMapper;
import challenge.server.datamodellingtest.mapper.ReviewMapper;
import challenge.server.datamodellingtest.repository.DataModellingTestHabitRepository;
import challenge.server.datamodellingtest.repository.DataModellingTestReportRepository;
import challenge.server.datamodellingtest.repository.DataModellingTestReviewRepository;
import challenge.server.datamodellingtest.repository.DataModellingTestUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/datamodelling")
@Validated
@RequiredArgsConstructor
public class DataModellingTestController {
    //    private final DataModellingTestService dataModellingTestService;

    private final HabitMapper habitMapper;
    private final ReviewMapper reviewMapper;

    private final DataModellingTestHabitRepository habitRepository;
    private final DataModellingTestReviewRepository reviewRepository;
    private final DataModellingTestReportRepository reportRepository;
    private final DataModellingTestUserRepository userRepository;


//    public DataModellingTestController(DataModellingTestHabitRepository habitRepository, DataModellingTestReviewRepository reviewRepository, DataModellingTestReportRepository reportRepository, DataModellingTestUserRepository userRepository) {
//        this.habitRepository = habitRepository;
//        this.reviewRepository = reviewRepository;
//        this.reportRepository = reportRepository;
//        this.userRepository = userRepository;
//    }

    // 특정 카테고리의 습관 조회
    @GetMapping("/habits/search")
    public ResponseEntity searchHabitsByCategory(@RequestParam("categoryId") Long categoryId) {
        Page<Habit> pageHabits = habitRepository.findAllByCategoryCategoryId(categoryId, PageRequest.of(0, 1000, Sort.by("habitId").descending()));
        List<Habit> habits = pageHabits.getContent();
        return new ResponseEntity(habitMapper.habitsToHabitResponses(habits), HttpStatus.OK);
    }

    // 특정 습관의 리뷰 조회
    @GetMapping("/reviews/habits/{habit-id}")
    public ResponseEntity getReviewsByHabitId(@PathVariable("habit-id") @Positive Long habitId) {
        Page<Review> pageReviews = reviewRepository.findAllByUserHabitHabitHabitId(habitId, PageRequest.of(0, 1000, Sort.by("reviewId").descending()));
        List<Review> reviews = pageReviews.getContent();
        return new ResponseEntity(reviewMapper.reviewsToReviewResponses(reviews), HttpStatus.OK);
    }

    // 특정 회원이 작성한 리뷰 조회
    @GetMapping("/reviews/users/{user-id}")
    public ResponseEntity getReviewsByUserId(@PathVariable("user-id") @Positive Long userId) {
        Page<Review> pageReviews = reviewRepository.findAllByUserHabitUserUserId(userId, PageRequest.of(0, 1000, Sort.by("reviewId").descending()));
        List<Review> reviews = pageReviews.getContent();
        return new ResponseEntity(reviewMapper.reviewsToReviewResponses(reviews), HttpStatus.OK);
    }

    // 모든 신고 조회
    @GetMapping("/reports")
    public ResponseEntity getReports() {
        Page<Report> pageReports = reportRepository.findAll(PageRequest.of(0, 1000, Sort.by("reportId").descending()));
        List<Report> reports = pageReports.getContent();
        return new ResponseEntity(reports, HttpStatus.OK);
    }

    // 습관에서 발생한 모든 신고 유형 조회
    @GetMapping("/reports/habits")
    public ResponseEntity getHabitReports() {
        Page<Report> pageReports = reportRepository.findAllByHabitNotNull(PageRequest.of(0, 1000, Sort.by("reportId").descending()));
        List<Report> reports = pageReports.getContent();
        return new ResponseEntity(reports, HttpStatus.OK);
    }

    // 인증에서 발생한 모든 신고 유형 조회
    @GetMapping("/reports/auths")
    public ResponseEntity getAuthReports() {
        Page<Report> pageReports = reportRepository.findAllByAuthNotNull(PageRequest.of(0, 1000, Sort.by("reportId").descending()));
        List<Report> reports = pageReports.getContent();
        return new ResponseEntity(reports, HttpStatus.OK);
    }

    // 누적 신고 5회 시 회원 정지
//    @PatchMapping("/users/")
}
