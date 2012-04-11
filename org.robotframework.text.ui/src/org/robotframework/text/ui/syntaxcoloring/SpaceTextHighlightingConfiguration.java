package org.robotframework.text.ui.syntaxcoloring;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class SpaceTextHighlightingConfiguration extends
		DefaultHighlightingConfiguration {
	public final static String SEPARATOR_ID = "SEPARATOR_ID";
	public final static String HEADER_ID = "HEADER_ID";
	public static final String MACRO_NAME_ID = "MACRO NAME ID";
	public static final String VARIABLE_NAME_ID = "VARIABLE_NAME_ID";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(SEPARATOR_ID, "Separator", separatorTextStyle());
		acceptor.acceptDefaultHighlighting(HEADER_ID, "Header", headerStyle());
		acceptor.acceptDefaultHighlighting(MACRO_NAME_ID, "Macro name", macroNameStyle());
		acceptor.acceptDefaultHighlighting(VARIABLE_NAME_ID, "Variable name", variableNameStyle());
	}
	
	private TextStyle variableNameStyle() {
		return createTextStyle(rgb(255, 255, 255), rgb(0, 100, 100));
	}

	private TextStyle macroNameStyle() {
		return createTextStyle(rgb(255, 255, 255), rgb(0, 0, 200));
	}

	private TextStyle separatorTextStyle() {
		return createTextStyle(rgb(245, 245, 245), rgb(0, 0, 0));
	}

	private TextStyle headerStyle() {
		return createTextStyle(rgb(255, 255, 255), rgb(0, 155, 0));
	}
	
	private RGB rgb(int red, int green, int blue) {
		return new RGB(red, green, blue);
	}

	private TextStyle createTextStyle(RGB backGround, RGB foreGround) {
		TextStyle textStyle = new TextStyle();
		textStyle.setBackgroundColor(backGround);
		textStyle.setColor(foreGround);
		return textStyle;
	}
}
