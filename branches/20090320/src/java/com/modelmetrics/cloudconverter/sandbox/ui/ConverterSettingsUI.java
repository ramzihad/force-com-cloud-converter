/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package com.modelmetrics.cloudconverter.sandbox.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class ConverterSettingsUI implements ConverterStatusListenerIF {

	private final RunUISWTInterface model;

	private static ProgressBar pb1;
	private Text datausername;
	private Text datapassword;
	private Text databasename;
	private Text username;
	private Text password;
	private Combo selections;
	private static Label statuslabel;
	private static Display display;
	private Shell shell;

	public ConverterSettingsUI(RunUISWTInterface model) {
		this.model = model;
		ConverterStatusPublisher.subscribe(this);
	}

	public void setStatus(String status) {
		this.setLabelAndBar(status, 10);

	}

//	public void initialize() {
//
//		display = new Display();
//		shell = new Shell(display);
//		shell.setText("JDBC to Force.com Converter");
//		shell.setSize(600, 1000);
//		GridLayout gridLayout = new GridLayout();
//		gridLayout.numColumns = 3;
//		shell.setLayout(gridLayout);
//
//		Group loginInfo = new Group(shell, SWT.NONE);
//		loginInfo.setText("Salesforce Login Info");
//		gridLayout = new GridLayout();
//		gridLayout.numColumns = 2;
//		loginInfo.setLayout(gridLayout);
//		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//		gridData.horizontalSpan = 4;
//		loginInfo.setLayoutData(gridData);
//
//		new Label(loginInfo, SWT.NONE).setText("Username:");
//		username = new Text(loginInfo, SWT.SINGLE | SWT.BORDER);
//		username.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//
//		new Label(loginInfo, SWT.NONE).setText("Password+Token:");
//		password = new Text(loginInfo, SWT.SINGLE | SWT.BORDER);
//		password.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//
//		Group ownerInfo = new Group(shell, SWT.NONE);
//		ownerInfo.setText("Please select JDBC Source");
//		gridLayout = new GridLayout();
//		gridLayout.numColumns = 2;
//		ownerInfo.setLayout(gridLayout);
//		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//		gridData.horizontalSpan = 2;
//		ownerInfo.setLayoutData(gridData);
//
//		new Label(ownerInfo, SWT.NONE).setText("Please Select JDBC Type: ");
//
//		selections = new Combo(ownerInfo, SWT.READ_ONLY);
//		selections.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		selections.add("mysql");
//		selections.add("notes (requires NoteSQL)");
//		selections.add("MS SQL Server (*)");
//		selections.add("Oracle (*)");
//		selections.add("DB2 (*)");
//
//		loginInfo = new Group(shell, SWT.NONE);
//		loginInfo.setText("Database Login Info");
//		gridLayout = new GridLayout();
//		gridLayout.numColumns = 2;
//		loginInfo.setLayout(gridLayout);
//		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//		gridData.horizontalSpan = 4;
//		loginInfo.setLayoutData(gridData);
//
//		new Label(loginInfo, SWT.NONE).setText("Database Username:");
//		datausername = new Text(loginInfo, SWT.SINGLE | SWT.BORDER);
//		datausername.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//
//		new Label(loginInfo, SWT.NONE).setText("Database Password:");
//		datapassword = new Text(loginInfo, SWT.SINGLE | SWT.BORDER);
//		datapassword.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//
//		new Label(loginInfo, SWT.NONE).setText("Database Name:");
//		databasename = new Text(loginInfo, SWT.SINGLE | SWT.BORDER);
//		databasename.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//
//		statuslabel = new Label(shell, SWT.NONE);
//		statuslabel.setText("Click 'Start Conversion' to begin.");
//		statuslabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
//		gridLayout = new GridLayout();
//		gridLayout.numColumns = 2;
//		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//		gridData.horizontalSpan = 4;
//		statuslabel.setLayoutData(gridData);
//
//		pb1 = new ProgressBar(shell, SWT.HORIZONTAL | SWT.SMOOTH);
//		pb1.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
//		pb1.setMinimum(0);
//		pb1.setMaximum(100);
//		gridLayout = new GridLayout();
//		gridLayout.numColumns = 2;
//		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//		gridData.horizontalSpan = 4;
//		pb1.setLayoutData(gridData);
//
//		Button ok = new Button(shell, SWT.PUSH);
//		ok.setText("Start Conversion");
//		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//		gridData.horizontalIndent = 5;
//		ok.setLayoutData(gridData);
//		ok.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				model.intializeProcess();
//
//			}
//		});
//
//		shell.pack();
//		shell.open();
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch())
//				display.sleep();
//		}
//	}

	public void setLabelAndBar(final String text, final int value) {

		getDisplay().syncExec(new Runnable() {
			public void run() {
				getStatuslabel().setText(text);
				getStatuslabel().redraw();
				getStatuslabel().update();
				if (value > 0) {
					getPb1().setSelection(value);
					getPb1().redraw();
					getPb1().update();
				}
			}
		});
	}

	public static ProgressBar getPb1() {
		return pb1;
	}

	public static void setPb1(ProgressBar pb1) {
		ConverterSettingsUI.pb1 = pb1;
	}

	public Text getDatausername() {
		return datausername;
	}

	public void setDatausername(Text datausername) {
		this.datausername = datausername;
	}

	public Text getDatapassword() {
		return datapassword;
	}

	public void setDatapassword(Text datapassword) {
		this.datapassword = datapassword;
	}

	public Text getDatabasename() {
		return databasename;
	}

	public void setDatabasename(Text databasename) {
		this.databasename = databasename;
	}

	public Text getUsername() {
		return username;
	}

	public void setUsername(Text username) {
		this.username = username;
	}

	public Text getPassword() {
		return password;
	}

	public void setPassword(Text password) {
		this.password = password;
	}

	public Combo getSelections() {
		return selections;
	}

	public void setSelections(Combo selections) {
		this.selections = selections;
	}

	public static Label getStatuslabel() {
		return statuslabel;
	}

	public static void setStatuslabel(Label statuslabel) {
		ConverterSettingsUI.statuslabel = statuslabel;
	}

	public static Display getDisplay() {
		return display;
	}

	public static void setDisplay(Display display) {
		ConverterSettingsUI.display = display;
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}
}
