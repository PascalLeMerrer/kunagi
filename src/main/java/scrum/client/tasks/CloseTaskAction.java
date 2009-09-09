package scrum.client.tasks;

import ilarkesto.gwt.client.AWidget;
import scrum.client.common.AAction;
import scrum.client.sprint.Task;

public class CloseTaskAction extends AAction {

	private Task task;

	public CloseTaskAction(Task task, AWidget... widgetsToUpdate) {
		super(widgetsToUpdate);
		this.task = task;
	}

	@Override
	public String getLabel() {
		return "Close";
	}

	@Override
	public String getTooltip() {
		return "Mark task as done.";
	}

	@Override
	public boolean isExecutable() {
		return !task.isDone() && (!task.isOwnerSet() || task.isOwner(getUser()));
	}

	@Override
	protected void onExecute() {
		task.setDone(getUser());
	}

}