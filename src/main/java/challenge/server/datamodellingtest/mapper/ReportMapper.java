package challenge.server.datamodellingtest.mapper;

import challenge.server.datamodellingtest.dto.ReportDto;
import challenge.server.datamodellingtest.entity.Report;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    ReportDto.Response reportToReportResponse(Report report);

    List<ReportDto.Response> reportsToReportResponses(List<Report> reports);
}
