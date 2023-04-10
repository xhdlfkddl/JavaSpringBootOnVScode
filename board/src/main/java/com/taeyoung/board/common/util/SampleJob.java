package com.taeyoung.board.common.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SampleJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // System.out.println("Sample job excute.");
    }
    
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob()
                         .ofType(SampleJob.class)
                         .storeDurably()
                         .withIdentity("Test sample job detail")
                         .withDescription("Sample job detail 테스트입니다.")
                         .build();
    }

    @Bean
    public Trigger trigger(JobDetail jobDetail) {

        CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("2 * * * * ?");

        return TriggerBuilder.newTrigger()
                             .forJob(jobDetail)
                             .withIdentity("Test sample trigger")
                             .withDescription("Sample trigger 테스트입니다.")
                             .withSchedule(cronSchedule)
                             .build();
    }

}
