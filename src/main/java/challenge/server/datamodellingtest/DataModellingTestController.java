package challenge.server.datamodellingtest;

import challenge.server.datamodellingtest.dto.ReportDto;
import challenge.server.datamodellingtest.entity.Habit;
import challenge.server.datamodellingtest.entity.Report;
import challenge.server.datamodellingtest.entity.Review;
import challenge.server.datamodellingtest.mapper.HabitMapper;
import challenge.server.datamodellingtest.mapper.ReportMapper;
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
    private final ReportMapper reportMapper;

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

    // ?????? ??????????????? ?????? ??????
    @GetMapping("/habits/search")
    public ResponseEntity searchHabitsByCategory(@RequestParam("categoryId") Long categoryId) {
        Page<Habit> pageHabits = habitRepository.findAllByCategoryCategoryId(categoryId, PageRequest.of(0, 1000, Sort.by("habitId").descending()));
        List<Habit> habits = pageHabits.getContent();
        return new ResponseEntity(habitMapper.habitsToHabitResponses(habits), HttpStatus.OK);
    }

    // ?????? ????????? ?????? ??????
    @GetMapping("/reviews/habits/{habit-id}")
    public ResponseEntity getReviewsByHabitId(@PathVariable("habit-id") @Positive Long habitId) {
        Page<Review> pageReviews = reviewRepository.findAllByUserHabitHabitHabitId(habitId, PageRequest.of(0, 1000, Sort.by("reviewId").descending()));
        List<Review> reviews = pageReviews.getContent();
        return new ResponseEntity(reviewMapper.reviewsToReviewResponses(reviews), HttpStatus.OK);
    }

    // ?????? ????????? ????????? ?????? ??????
    @GetMapping("/reviews/users/{user-id}")
    public ResponseEntity getReviewsByUserId(@PathVariable("user-id") @Positive Long userId) {
        Page<Review> pageReviews = reviewRepository.findAllByUserHabitUserUserId(userId, PageRequest.of(0, 1000, Sort.by("reviewId").descending()));
        List<Review> reviews = pageReviews.getContent();
        return new ResponseEntity(reviewMapper.reviewsToReviewResponses(reviews), HttpStatus.OK);
    }

    // ?????? ?????? ??????
    @GetMapping("/reports")
    public ResponseEntity getReports() {
        Page<Report> pageReports = reportRepository.findAll(PageRequest.of(0, 1000, Sort.by("reportId").descending()));
        List<Report> reports = pageReports.getContent();
        return new ResponseEntity(reportMapper.reportsToReportResponses(reports), HttpStatus.OK);
    }

    // ???????????? ????????? ?????? ?????? ??????
    @GetMapping("/reports/habits")
    public ResponseEntity getHabitReports() {
        Page<Report> pageReports = reportRepository.findAllByHabitNotNull(PageRequest.of(0, 1000, Sort.by("reportId").descending()));
        List<Report> reports = pageReports.getContent();
        return new ResponseEntity(reportMapper.reportsToReportResponses(reports), HttpStatus.OK);
    }

    // 2023.1.7(???) ?????? = ???????????? ????????? ?????? ?????? ????????? ?????? ??????
    @GetMapping("/report/habits")
    public ResponseEntity getCountOfHabitReportsByTypes(@RequestParam("reportType") String reportType) {
        Long count = reportRepository.countAllByHabitNotNullAndAndReportTypeIsLike(reportType);
        /* select count(*)
        from habit
        where habit not null
        group by report_type

        reportType = HATEFUL, SEXUAL, SPAM, VIOLENT
         */
//        List<Report> reports = pageReports.getContent();
//        return new ResponseEntity(reportMapper.reportsToReportResponses(reports), HttpStatus.OK);
        return new ResponseEntity(new ReportDto.CountResponse(reportType, count), HttpStatus.OK);
    }

    // ???????????? ????????? ?????? ?????? ?????? ??????
    @GetMapping("/reports/auths")
    public ResponseEntity getAuthReports() {
        Page<Report> pageReports = reportRepository.findAllByAuthNotNull(PageRequest.of(0, 1000, Sort.by("reportId").descending()));
        List<Report> reports = pageReports.getContent();
        return new ResponseEntity(reportMapper.reportsToReportResponses(reports), HttpStatus.OK);
    }

    // ?????? ?????? 5??? ??? ?????? ??????
//    @PatchMapping("/users/")
}
