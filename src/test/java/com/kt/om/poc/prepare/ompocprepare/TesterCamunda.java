package com.kt.om.poc.prepare.ompocprepare;

import java.sql.SQLException;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.camunda.bpm.engine.test.Deployment;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.junit.Assert.*;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */

public class TesterCamunda {
	//@Rule
	public ProcessEngineRule rule = new ProcessEngineRule(new StandaloneInMemProcessEngineConfiguration().buildProcessEngine());
	
	//@Test
	//@Deployment(resources="process.bpmn")
	public void testHappyPath(){
		/*
		ProcessEngine processEngine = rule.getProcessEngine();
		
		ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey("ompocprepare");
		
		HistoricProcessInstance historicProcessInstance = processEngine.getHistoryService().createHistoricProcessInstanceQuery().processInstanceId(pi.getId()).singleResult();
		
		//assertThat(pi).isStarted().isEnded();
		//assertNotNull(historicProcessInstance.getEndTime());
		System.out.println(historicProcessInstance.getId());
		*/
	}

}
