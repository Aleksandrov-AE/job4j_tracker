package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sum = 0;
        int n = 0;
        for (Pupil pupil: pupils) {
            for (Subject subject: pupil.subjects()) {
                sum += subject.score();
                n++;
            }
        }
        return (double) sum / n;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil: pupils) {
            int sum = 0;
            for (Subject subject: pupil.subjects()) {
                sum += subject.score();
            }
            result.add(new Label(pupil.name(), (double) sum / pupil.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldScope, newScope) -> oldScope + newScope);
            }
        }
        for (String subject : map.keySet()) {
            result.add(new Label(subject, (double) map.get(subject) / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil: pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            result.add(new Label(pupil.name(), sum));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {

                if (map.containsKey(subject.name())) {
                    map.put(subject.name(), subject.score() + map.get(subject.name()));
                } else {
                    map.put(subject.name(), subject.score());
                }
            }
        }
        for (String subject : map.keySet()) {
            result.add(new Label(subject, (double) map.get(subject)));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
