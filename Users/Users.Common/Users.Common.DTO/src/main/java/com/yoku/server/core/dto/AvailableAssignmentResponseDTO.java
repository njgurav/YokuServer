package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

public class AvailableAssignmentResponseDTO extends BaseRequestDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AssignmentDTO[] assignments;
	
	public AvailableAssignmentResponseDTO(){
		
	}

	public AssignmentDTO[] getAssignments() {
		return assignments;
	}

	public void setAssignments(AssignmentDTO[] assignments) {
		this.assignments = assignments;
	}
	
}
