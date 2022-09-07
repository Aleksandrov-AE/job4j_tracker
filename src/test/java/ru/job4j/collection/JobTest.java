package ru.job4j.collection;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorSortByName() {
        List<Job> jobs = Arrays.asList(new Job("bug1", 10),
                new Job("bug4", 1),
                new Job("bug2", 2));
        List<Job> expected = Arrays.asList(new Job("bug1", 10),
                new Job("bug2", 2),
                new Job("bug4", 1));
        jobs.sort(new JobSortByName());

        Assert.assertEquals(jobs, expected);
    }

    @Test
    public void whenComparatorSortByPriority() {
        List<Job> jobs = Arrays.asList(new Job("bug1", 10),
                new Job("bug4", 1),
                new Job("bug2", 2));
        List<Job> expected = Arrays.asList(new Job("bug4", 1),
                new Job("bug2", 2),
                new Job("bug1", 10));
        jobs.sort(new JobSortByPriority());

        Assert.assertEquals(jobs, expected);
    }

    @Test
    public void whenComparatoDescByPriority() {
        List<Job> jobs = Arrays.asList(new Job("bug1", 10),
                new Job("bug4", 1),
                new Job("bug2", 2));
        List<Job> expected = Arrays.asList(new Job("bug1", 10),
                new Job("bug2", 2),
                new Job("bug4", 1));
        jobs.sort(new JobDescByPriority());

        Assert.assertEquals(jobs, expected);
    }

    @Test
    public void whenComparatoDescByName() {
        List<Job> jobs = Arrays.asList(new Job("bug1", 10),
                new Job("bug4", 1),
                new Job("bug2", 2));
        List<Job> expected = Arrays.asList(new Job("bug4", 1),
                new Job("bug2", 2),
                new Job("bug1", 10));
        jobs.sort(new JobDescByName());

        Assert.assertEquals(jobs, expected);
    }

    @Test
    public void whenCompatorByDescNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("task2", 0),
                new Job("task1", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorBySortNameAndPrority() {
        Comparator<Job> cmpSortNamePriority = new JobSortByName().thenComparing(new JobSortByPriority());
        int rsl = cmpSortNamePriority.compare(
                new Job("Fix bug1", 0),
                new Job("Fix bug2", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorBySortNameAndProrityEqual() {
        Comparator<Job> cmpSortNamePriority = new JobSortByName().thenComparing(new JobSortByPriority());
        int rsl = cmpSortNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 11)
        );
        assertThat(rsl).isLessThan(0);
    }
}