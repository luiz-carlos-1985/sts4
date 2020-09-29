/*******************************************************************************
 * Copyright (c) 2020 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.boot.wizard.preferences;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.springframework.ide.eclipse.boot.wizard.BootWizardActivator;

/**
 * Add Starters wizard preference page
 *
 * @author Alex Boyko
 *
 */
public class AddStartersWizardPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(BootWizardActivator.getDefault().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {

		Composite fieldEditorParent = getFieldEditorParent();

		Label excludeResourceDescription = new Label(fieldEditorParent, SWT.NONE);
		excludeResourceDescription.setText("Resources to exclude from the comparison of the local workspace project\n"
				+ "and the project generated by the Initializr Service.\n"
				+ "Specify glob pattern of project relative paths separated by commas.");
		excludeResourceDescription.setLayoutData(GridDataFactory.fillDefaults().span(2, 1).create());

		addField(new StringFieldEditor(PreferenceConstants.ADD_STARTERS_EXCLUDE_RESOURCES_FROM_COMPARE, "Path patterns:", fieldEditorParent));
	}

}