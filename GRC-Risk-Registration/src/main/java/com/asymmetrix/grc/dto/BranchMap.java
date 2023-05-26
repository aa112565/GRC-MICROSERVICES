package com.asymmetrix.grc.dto;

import java.io.Serializable;

public class BranchMap implements Serializable {
	private static final long serialVersionUID = 1L;
	String ROBranchCd;
	String NSBBranches;
	public BranchMap() {}
	public BranchMap(String rOBranchCd) {
		super();
		ROBranchCd = rOBranchCd;
	}
	public BranchMap(String rOBranchCd, String nSBBranches) {
		super();
		ROBranchCd = rOBranchCd;
		NSBBranches = nSBBranches;
	}
	@Override
	public String toString() {
		return "BranchMap [ROBranchCd=" + ROBranchCd + ", NSBBranches=" + NSBBranches + "]";
	}
	public String getROBranchCd() {
		return ROBranchCd;
	}
	public void setROBranchCd(String rOBranchCd) {
		ROBranchCd = rOBranchCd;
	}
	public String getNSBBranches() {
		return NSBBranches;
	}
	public void setNSBBranches(String nSBBranches) {
		NSBBranches = nSBBranches;
	}
}
