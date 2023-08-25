package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class Scheduler {
    private final WeatherService weatherService;

    @Scheduled(cron = "0 0 0 * * SUN,MON,TUE")
    @SchedulerLock(name = "save_weather_forecast", lockAtLeastFor = "PT2M",
            lockAtMostFor = "PT10M")
    public void saveWeather() {
        log.info("Scheduler starts");
        LocalDate date = LocalDate.now();
        if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            weatherService.saveWeatherForecast(1);
        } else weatherService.saveWeatherForecast(3);
    }
}
