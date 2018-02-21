package com.kt.om.poc.prepare.ompocprepare;

import java.util.logging.Logger;

import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * This is an empty service implementation illustrating how to use a plain Java 
 * class as a BPMN 2.0 Service Task delegate.
 */


public class TestDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(TestDelegate.class.getName());
  

  public void execute(DelegateExecution execution) throws Exception {
	  
	  String orderNumber = null;
	  String SCN = null;
	  String ORDERSEQNO = null;
	  orderNumber = (String) execution.getVariable("orderNumber");
	  SCN = (String) execution.getVariable("SCN");
	  ORDERSEQNO = (String) execution.getVariable("ORDERSEQNO");
	  String errorMessage = "validation failed";
	  
	  if(orderNumber == null || SCN == null || ORDERSEQNO == null)
	  {
		  //throw new BpmnError("ORP_VALIDATION_ERR1", errorMessage);
		  execution.setVariable("ORPvalidationResult", "false");
	  } else
	  {
		  execution.setVariable("ORPvalidationResult", "true");
		  LOGGER.info("Order is validated and key value is " + "orderNumber  " + "SCN    " + "ORDERSEQNO   ");
	  }
	  
    
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
