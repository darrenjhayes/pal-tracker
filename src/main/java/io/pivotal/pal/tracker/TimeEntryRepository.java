package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {
    TimeEntry create(TimeEntry timeEntry);

    TimeEntry find(long timeEntryId);

    TimeEntry update(long timeEntryId, TimeEntry timeEntry);

    void delete(long timeEntryId);

    List<TimeEntry> list();
}
