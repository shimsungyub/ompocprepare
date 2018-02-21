package com.kt.om.poc.prepare.ompocprepare;

import java.util.logging.Logger;

import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;

/**
 * This is an empty service implementation illustrating how to use a plain Java 
 * class as a BPMN 2.0 Service Task delegate.
 */


public class CreateServiceOrderDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(CreateServiceOrderDelegate.class.getName());
  

  public void execute(DelegateExecution execution) throws Exception {
	  
	  String orderNumber = null;
	  String SCN = null;
	  String ORDERSEQNO = null;
	  String WorkOdrTypeNum = null;
	  String WorkOdrTypeCode = null;
	  
	  orderNumber = (String) execution.getVariable("orderNumber");
	  SCN = (String) execution.getVariable("SCN");
	  ORDERSEQNO = (String) execution.getVariable("ORDERSEQNO");
	  WorkOdrTypeCode = (String) execution.getVariable("WorkOdrTypeCode");
	  WorkOdrTypeNum = (String) execution.getVariable("WorkOdrTypeNum");
	  
	  RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
	  MessageCorrelationResult result = runtimeService.createMessageCorrelation("ServiceOrder_Message")
			  .processInstanceBusinessKey(orderNumber)
			  .setVariable("SCN", SCN)
			  .setVariable("ORDERSEQNO", ORDERSEQNO)
			  .setVariable("WorkOdrTypeCode", WorkOdrTypeCode)
			  .setVariable("WorkOdrTypeNum", WorkOdrTypeNum)
			  .correlateWithResult();
    
    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
            + "processDefinitionId=" + execution.getProcessDefinitionId()
            + ", activtyId=" + execution.getCurrentActivityId()
            + ", activtyName='" + execution.getCurrentActivityName() + "'"
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + " \n\n");
    
  }

}
