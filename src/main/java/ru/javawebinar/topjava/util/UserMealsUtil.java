package ru.javawebinar.topjava.util;

import jdk.internal.util.xml.impl.Pair;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        List<UserMealWithExceed> lst = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);

        for(UserMealWithExceed meal : lst) {
            System.out.println(meal.toString());
        }
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesPerDateMap = mealList.stream()
                .collect(Collectors.toMap(p -> p.getDateTime().toLocalDate(), UserMeal::getCalories, Integer::sum));

        return mealList.stream().
                filter(meal -> {
                    LocalTime mealTime = meal.getDateTime().toLocalTime();
                    return TimeUtil.isBetween(mealTime, startTime, endTime);
                }).
                map(meal -> new UserMealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(),
                        caloriesPerDateMap.get(meal.getDateTime().toLocalDate()) > caloriesPerDay)).
                collect(Collectors.toList());
    }
}
