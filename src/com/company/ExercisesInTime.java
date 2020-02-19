package com.company;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ExercisesInTime {
    ExercisesInTime() {

        daysSinceBirth();
        timeAcrossThePond();
        fridayAndThirteen();
        shittyPhone();
        eatSleepDie();

    }

    void daysSinceBirth() {
        Period age = Period.between(LocalDate.of(1990, Month.JANUARY, 26), LocalDate.now());
        System.out.println("~~~THE STORY OF MY LIFE~~~\nMy life has been " + (int) (age.getYears() * 365.242199 + age.getMonths() * 30.4368499 + age.getDays()) + " days of agony.\n");
    }

    void eatSleepDie() {
        long timeLeftForMe = 0L;
        long timeSpent = 0L;
        long timeElapsed = 0L;
        double sleep = 60 * 8;
        double workSchool = 60 * (8 + 1);
        double chores = 60;
        double hygiene = 30;
        double toilet = 27;
        double eat = 30;
        double phone = 60 * 3;
        LocalDate birth = LocalDate.of(1990, Month.JANUARY, 1);
        for (LocalDate age = birth; age.getYear() <= birth.getYear() + 80; age = age.plusDays(1)) {
            double dailyTimeSpent = 0;
            timeElapsed += (60 * 24);
            dailyTimeSpent += sleep + hygiene + eat + toilet;
            if (age.getYear() - birth.getYear() < 6) {
                dailyTimeSpent += toilet;
            } else if (age.getYear() - birth.getYear() >= 65) {
                dailyTimeSpent += hygiene + eat + toilet + chores + chores + phone;
            } else {
                dailyTimeSpent += phone;
                if (age.getDayOfWeek() == DayOfWeek.SATURDAY || age.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    dailyTimeSpent += chores;
                } else dailyTimeSpent += workSchool;
            }
            if (age.getYear() - birth.getYear() > 30) {
                timeLeftForMe += (24 * 60) - dailyTimeSpent;
            }
            timeSpent += dailyTimeSpent;
        }

        System.out.printf("%n%n~~~EAT SLEEP DIE~~~ %nAverage percentage of time alive not spent at school/work/sleeping/shitting/cleaning/scrolling: " +
                "%.1f%%%nAverage amount of hours alive not spent at school/work/sleeping/shitting/cleaning/scrolling: %.0f hours.%nHours of leisure left for me if i live to age 80: %d hours.%n%n", 100 - ((double) timeSpent / (double) timeElapsed) * 100, (double) (timeElapsed - timeSpent) / 60, timeLeftForMe / 60);
    }

    void shittyPhone() {
        double minutesOfToiletTime = 0;
        System.out.print("~~~SHITTY PHONE~~~\nIf you got your phone (at age 10) on the date 2000-01-01,\n");
        LocalDate gotPhone = LocalDate.of(2000, Month.JANUARY, 1);
        LocalDate thisYear = gotPhone;
        for (; gotPhone.getYear() + 70 != thisYear.getYear(); thisYear = thisYear.plusDays(1)) {
            if (thisYear.getYear() > 2017) minutesOfToiletTime += 27;
            else minutesOfToiletTime += 14.5;
        }
        System.out.printf("you will have spent %.0f minutes on the toilet by the age of 80! [citation needed]%n", minutesOfToiletTime);
        System.out.printf("That is equal to %.0f seconds! Or %.0f days!", minutesOfToiletTime * 60, minutesOfToiletTime / 60 / 24);
    }

    void fridayAndThirteen() {
        int fridayThirteenCounter = 0;
        for (LocalDate start = LocalDate.of(1900, Month.JANUARY, 1); !start.isEqual(LocalDate.now()); start = start.plusDays(1)) {
            if (start.getDayOfMonth() == 13 && start.getDayOfWeek() == DayOfWeek.FRIDAY) {
                ++fridayThirteenCounter;
            }
        }
        System.out.println("\n~~~F13~~~\nThere has been " + fridayThirteenCounter + " Friday-The-Thirteenths since 1900-01-01.");
        System.out.printf("There has been an average of %.3f Friday-The-Thirteenths per year.%n%n", ((double) fridayThirteenCounter / (LocalDate.now().getYear() - 1900)));
    }


    void timeAcrossThePond() {
        ZonedDateTime yank = ZonedDateTime.of(LocalDateTime.of(2020, Month.APRIL, 1, 11, 30), ZoneId.of("America/New_York"));
        System.out.println("~~~YANK~~~\nSo, I says like let's chat at " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(new Locale("en", "US")).format(yank));
        System.out.println("And they're like aight, see you at " + yank.withZoneSameInstant(ZoneId.of("Europe/Stockholm")).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
    }


}
