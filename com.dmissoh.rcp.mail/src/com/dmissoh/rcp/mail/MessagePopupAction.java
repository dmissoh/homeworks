package com.dmissoh.rcp.mail;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;

public class MessagePopupAction extends Action {

	private final IWorkbenchWindow window;

	MessagePopupAction(String text, IWorkbenchWindow window) {
		super(text);
		this.window = window;
		// The id is used to refer to the action in a menu or toolbar
		setId(ICommandIds.CMD_OPEN_MESSAGE);
		// Associate the action with a pre-defined command, to allow key
		// bindings.
		setActionDefinitionId(ICommandIds.CMD_OPEN_MESSAGE);
		setImageDescriptor(com.dmissoh.rcp.mail.Activator
				.getImageDescriptor("/icons/sample3.gif"));
	}

	public void run() {
		InputDialog inputDialog = new InputDialog(window.getShell(), "Greeter",
				"Enter your name", "Dummy", null);
		String name = "007";
		if (inputDialog.open() == InputDialog.OK) {
			name = inputDialog.getValue();
		}
		MessageDialog.openInformation(window.getShell(), "Open",
				generateMessage(name));
	}

	private String generateMessage(String name) {
		Shell shell = window.getShell();
		try {
			new ProgressMonitorDialog(shell).run(true, true,
					new LongLastingOperation(false));
		} catch (InvocationTargetException e) {
			MessageDialog.openError(shell, "Error", e.getMessage());
		} catch (InterruptedException e) {
			MessageDialog.openInformation(shell, "Cancelled", e.getMessage());
		}
		return "Hello " + name;
	}

	class LongLastingOperation implements IRunnableWithProgress {
		private static final int TOTAL_WORK = 5000;
		private static final int WORK = 500;

		private boolean indeterminate;

		public LongLastingOperation(boolean indeterminate) {
			this.indeterminate = indeterminate;
		}

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			monitor.beginTask("Running long lasting operation",
					indeterminate ? IProgressMonitor.UNKNOWN : TOTAL_WORK);
			for (int total = 0; total < TOTAL_WORK && !monitor.isCanceled(); total += WORK) {
				Thread.sleep(WORK);
				monitor.worked(WORK);
			}
			monitor.done();
			if (monitor.isCanceled())
				throw new InterruptedException(
						"The long lasting operation was cancelled");
		}
	}
}