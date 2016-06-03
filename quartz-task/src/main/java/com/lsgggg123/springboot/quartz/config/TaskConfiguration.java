/**
 *
 */
package com.lsgggg123.springboot.quartz.config;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 */
@Configuration
public class TaskConfiguration implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setJobFactory(jobFactory);
        scheduler.setTriggers(this.triggers());
        scheduler.setQuartzProperties(this.quartzProperties());
        return scheduler;
    }

	@Bean
	public JobFactory jobFactory(ApplicationContext applicationContext) {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

    private static BeanFactory getBeanFactory(){
        ConfigurableApplicationContext context = (ConfigurableApplicationContext)applicationContext;
        BeanFactory factory = context.getBeanFactory();
        return factory;
    }

    private Trigger[] triggers() {
        return initTrigger();
    }

    private Trigger[] initTrigger(){
        List<Trigger> triggers = new ArrayList<Trigger>();
        try {
            MethodInvokingJobDetailFactoryBean jobDetail = jobDetailFactoryBean("dateTask");
            jobDetail.afterPropertiesSet();
            CronTriggerFactoryBean cronTriggerFactoryBean = createCronTriggerFactoryBean("dateTask", jobDetail.getObject(), "0/1 * * * * ?");
            cronTriggerFactoryBean.afterPropertiesSet();
            triggers.add(cronTriggerFactoryBean.getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return triggers.toArray(new Trigger[triggers.size()]);
    }

    /**
     * 创建JobDetail工厂
     *
     * @param targetBeanName
     * @return
     */
    private static MethodInvokingJobDetailFactoryBean jobDetailFactoryBean(String targetBeanName) {
        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
        factoryBean.setBeanFactory(getBeanFactory());
        factoryBean.setName(targetBeanName + "FactoryBean");
        factoryBean.setTargetBeanName(targetBeanName);
        factoryBean.setTargetMethod("run");
        factoryBean.setConcurrent(false);
        return factoryBean;
    }

    /**
     * 创建Cron Trigger工厂
     *
     * @param jobDetail
     * @param cronExpression
     * @return
     */
    private static CronTriggerFactoryBean createCronTriggerFactoryBean(String triggerName, JobDetail jobDetail, String cronExpression) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setName(triggerName + "TriggerFactoryBean");
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
        factoryBean.setCronExpression(cronExpression);
        return factoryBean;
    }

    /**
     * 创建只执行一次的Trigger工厂
     *
     * @param jobDetail
     * @param startDelay the start delay in milliseconds
     * @return
     */
    private static SimpleTriggerFactoryBean createNonReaptedTriggerFactoryBean(String triggerName,JobDetail jobDetail, long startDelay) {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setName(triggerName + "TriggerFactoryBean");
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setRepeatCount(0);
        factoryBean.setRepeatInterval(0l);
        factoryBean.setStartDelay(startDelay);
        return factoryBean;
    }

    @Bean
    public Properties quartzProperties() {
        Properties properties = new Properties();
        properties.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
        return properties;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
