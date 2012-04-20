/*
 *   Copyright 2012 Nokia Siemens Networks Oyj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robotframework.text.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.robotframework.text.ui.contentassist.AbstractSpaceProposalProvider;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class SpaceProposalProvider extends AbstractSpaceProposalProvider {
	
	private static final String[] BUILTIN_KEYWORDS = new String[]{
			"Call Method",
			"Catenate",
			"Comment",
			"Convert To Binary",
			"Convert To Boolean",
			"Convert To Hex",
			"Convert To Integer",
			"Convert To Number",
			"Convert To Octal",
			"Convert To String",
			"Create List",
			"Evaluate",
			"Exit For Loop",
			"Fail",
			"Fatal Error",
			"Get Count",
			"Get Length",
			"Get Library Instance",
			"Get Time",
			"Get Variable Value",
			"Get Variables",
			"Import Library",
			"Import Resource",
			"Import Variables",
			"Keyword Should Exist",
			"Length Should Be",
			"Log",
			"Log Many",
			"Log Variables",
			"No Operation",
			"Regexp Escape",
			"Remove Tags",
			"Repeat Keyword",
			"Replace Variables",
			"Run Keyword",
			"Run Keyword And Continue On Failure",
			"Run Keyword And Expect Error",
			"Run Keyword And Ignore Error",
			"Run Keyword If",
			"Run Keyword If All Critical Tests Passed",
			"Run Keyword If All Tests Passed",
			"Run Keyword If Any Critical Tests Failed",
			"Run Keyword If Any Tests Failed",
			"Run Keyword If Test Failed",
			"Run Keyword If Test Passed",
			"Run Keyword If Timeout Occurred",
			"Run Keyword Unless",
			"Run Keywords",
			"Set Global Variable",
			"Set Library Search Order",
			"Set Log Level",
			"Set Suite Documentation",
			"Set Suite Variable",
			"Set Tags",
			"Set Test Documentation",
			"Set Test Message",
			"Set Test Variable",
			"Set Variable",
			"Set Variable If",
			"Should Be Empty",
			"Should Be Equal",
			"Should Be Equal As Integers",
			"Should Be Equal As Numbers",
			"Should Be Equal As Strings",
			"Should Be True",
			"Should Contain",
			"Should Contain X Times",
			"Should End With",
			"Should Match",
			"Should Match Regexp",
			"Should Not Be Empty",
			"Should Not Be Equal",
			"Should Not Be Equal As Integers",
			"Should Not Be Equal As Numbers",
			"Should Not Be Equal As Strings",
			"Should Not Be True",
			"Should Not Contain",
			"Should Not End With",
			"Should Not Match",
			"Should Not Match Regexp",
			"Should Not Start With",
			"Should Start With",
			"Sleep",
			"Variable Should Exist",
			"Variable Should Not Exist",
			"Wait Until Keyword Succeeds"
	};
	
	private static final String[] SETTING_NAMES = new String[]{
		    "Documentation",
		    "Default Tags",
		    "Force Tags",
		    "Library",
		    "Resource",
		    "Test Template",
		    "Test Timeout",
		    "Suite Setup",
		    "Suite Teardown",
		    "Test Setup",
		    "Test Teardown"
	};
	
	private static final String[] KEYWORD_SETTING = new String[]{
			"[Arguments]",
			"[Teardown]",
			"[Documentation]",
			"[Timeout]",
			"[Return]"
	};
	
	private static final String[] TESTCASE_SETTING = new String[]{
			"[Tags]",
			"[Setup]",
			"[Teardown]",
			"[Documentation]",
			"[Timeout]",
			"[Template]"
	};
	
	@Override
	public void complete_KeywordTableHeader(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.complete_KeywordTableHeader(model, ruleCall, context, acceptor);
		acceptor.accept(createCompletionProposal("*** Keywords ***\n", context));
	}
	
	@Override
	public void complete_TestCaseTableHeader(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.complete_TestCaseTable(model, ruleCall, context, acceptor);
		acceptor.accept(createCompletionProposal("*** Test Cases ***\n", context));
	}
	
	@Override
	public void complete_SettingsTableHeader(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.complete_SettingsTable(model, ruleCall, context, acceptor);
		acceptor.accept(createCompletionProposal("*** Settings ***\n", context));
	}
	
	@Override
	public void complete_VariablesTableHeader(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.complete_VariablesTable(model, ruleCall, context, acceptor);
		acceptor.accept(createCompletionProposal("*** Variables ***\n", context));
	}

	@Override
	public void completeExecutingStep_Keyword(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeExecutingStep_Keyword(model, assignment, context, acceptor);
		addBuiltInKeywords(context, acceptor);
	}

	private void addBuiltInKeywords(ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		for(String kw: BUILTIN_KEYWORDS){
			acceptor.accept(createCompletionProposal(kw+"  ", context));
		}
	}
	
	@Override
	public void completeAssigningStep_Keyword(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeAssigningStep_Keyword(model, assignment, context, acceptor);
		addBuiltInKeywords(context, acceptor);
	}
	
	@Override
	public void completeKeywordSetting_Setting(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeKeywordSetting_Setting(model, assignment, context, acceptor);
		for(String keywordSetting: KEYWORD_SETTING)
			acceptor.accept(createCompletionProposal(keywordSetting+"  ", context));
	}
	
	@Override
	public void completeTestCase_Settings(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.completeTestCase_Settings(model, assignment, context, acceptor);
		for(String testCaseSetting: TESTCASE_SETTING)
			acceptor.accept(createCompletionProposal(testCaseSetting+"  ", context));
	}
	
	@Override
	public void complete_Setting(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.complete_Setting(model, ruleCall, context, acceptor);
		for(String setting: SETTING_NAMES)
			acceptor.accept(createCompletionProposal(setting+"  ", context));
	}
}
