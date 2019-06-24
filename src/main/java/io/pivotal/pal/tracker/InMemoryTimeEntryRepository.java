package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    private List<TimeEntry> timeEntryList = new ArrayList<>(timeEntries.values());
    private long currentMaxId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(currentMaxId);
        timeEntries.put(currentMaxId, timeEntry);
        timeEntryList = new ArrayList<>(timeEntries.values());
        currentMaxId = currentMaxId + 1;
        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return timeEntries.get(timeEntryId);
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry timeEntry) {
        TimeEntry timeEntryToUpdate = find(timeEntryId);

        if (timeEntryToUpdate == null) { return null; }

        timeEntry.setId(timeEntryId);
        timeEntries.put(timeEntryId, timeEntry);
        timeEntryList = new ArrayList<>(timeEntries.values());

        return find(timeEntryId);
    }

    @Override
    public void delete(long timeEntryId) {
        timeEntries.remove(timeEntryId);
        timeEntryList = new ArrayList<>(timeEntries.values());
    }

    @Override
    public List<TimeEntry> list() {
        return timeEntryList;
    }
}
