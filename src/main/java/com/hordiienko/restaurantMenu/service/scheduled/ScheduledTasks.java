package com.hordiienko.restaurantMenu.service.scheduled;

import org.hibernate.type.LocalDateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0 0 13 * * THU")
    public void reportCurrentTime() throws InterruptedException, IOException {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime lastDate = getLastDate();
        DayOfWeek currentDay = currentDate.getDayOfWeek();
        DayOfWeek targetDay = DayOfWeek.WEDNESDAY;
        long days = DAYS.between(lastDate, currentDate);
        if(!currentDay.equals(targetDay) || days < 6L) {
            return;
        }
        setNewDate();
    }

    private LocalDateTime getLastDate() throws IOException {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            LocalDateTime lastDate = LocalDateTime.parse(prop.get("mailing.date").toString(), FORMATTER);
            log.info(lastDate.toString());
            return lastDate;

        } catch (IOException io) {
            throw io;
        }
    }

    private void setNewDate() {
        try (OutputStream output = new FileOutputStream("src/main/resources/config.properties")) {

            Properties prop = new Properties();
            LocalDateTime dateTime = LocalDateTime.now();
            // set the properties value
            prop.setProperty("mailing.date", FORMATTER.format(dateTime));

            // save properties to project root folder
            prop.store(output, null);

            log.info(prop.toString());

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
