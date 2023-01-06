package challenge.server.datamodellingtest.mapper;

import challenge.server.datamodellingtest.dto.HabitDto;
import challenge.server.datamodellingtest.entity.Habit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HabitMapper {
    List<HabitDto.Response> habitsToHabitResponses(List<Habit> habits);
}
