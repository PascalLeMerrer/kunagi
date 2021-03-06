/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package scrum.client.project;

import scrum.client.common.TooltipBuilder;

public class RejectRequirementAction extends GRejectRequirementAction {

	public RejectRequirementAction(scrum.client.project.Requirement requirement) {
		super(requirement);
	}

	@Override
	public String getLabel() {
		return "Reject";
	}

	@Override
	protected void updateTooltip(TooltipBuilder tb) {
		tb.setText("Mark this story as not sufficently completed. Do this when the team needs to do more work on it.");
	}

	@Override
	public boolean isPermitted() {
		if (!requirement.getProject().isProductOwner(getCurrentUser())) return false;
		return true;
	}

	@Override
	public boolean isExecutable() {
		if (!requirement.isInCurrentSprint()) return false;
		if (!requirement.isTasksClosed()) return false;
		if (requirement.isClosed()) return false;
		if (requirement.isRejected()) return false;
		return true;
	}

	@Override
	protected void onExecute() {
		requirement.reject();
	}

}