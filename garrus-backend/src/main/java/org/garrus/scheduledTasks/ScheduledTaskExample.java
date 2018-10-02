package org.garrus.scheduledTasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTaskExample {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTaskExample.class);

    
//    You can autowire services or repositories here.
//    @Autowired
//    private SomeRepository repo;

    //This task will execute on the 00:00 of each day. 
    //See https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html 
    // for more info.
//    @Scheduled(cron="0 0 0 * * ?")
    public void cronTask() {
    	log.debug("Cron task executing...");
    }
    
//    @Scheduled(fixedRate=50000)
    public void fixedRateTask() {
    	log.debug("This task will execute every 50 seconds...");
    }
}