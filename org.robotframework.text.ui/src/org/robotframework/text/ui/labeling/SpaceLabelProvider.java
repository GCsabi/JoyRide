/*
* generated by Xtext
*/
package org.robotframework.text.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.robotframework.text.space.KeywordTable;
import org.robotframework.text.space.RobotStep;
import org.robotframework.text.space.SettingsTable;
import org.robotframework.text.space.TestCaseTable;
import org.robotframework.text.space.VariablesTable;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class SpaceLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public SpaceLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	String text(TestCaseTable table) {
		return "*** Test Cases ***";
	}

	String text(KeywordTable table) {
		return "*** Keywords ***";
	}
	
	String text(VariablesTable table) {
		return "*** Variables ***";
	}
	
	String text(SettingsTable table) {
		return "*** Settings ***";
	}

	String text(RobotStep step) {
		return "Step"; 
	}
/*
	//Labels and icons can be computed like this:
	
	String text(MyModel ele) {
	  return "my "+ele.getName();
	}
	 
    String image(MyModel ele) {
      return "MyModel.gif";
    }
*/
}
