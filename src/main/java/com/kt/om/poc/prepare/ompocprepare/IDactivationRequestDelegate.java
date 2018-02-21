package com.kt.om.poc.prepare.ompocprepare;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * This is an empty service implementation illustrating how to use a plain Java 
 * class as a BPMN 2.0 Service Task delegate.
 */
public class IDactivationRequestDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(IDactivationRequestDelegate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
	String idmsDependency = null;
	idmsDependency = (String) execution.getVariable("IDMSDependency");
	if(idmsDependency == null)
		 execution.setVariable("IDMSDependency", "false");
	else execution.setVariable("IDMSDependency", idmsDependency);
	  
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
