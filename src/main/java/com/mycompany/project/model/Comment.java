package com.mycompany.project.model;

import java.util.Date;

import org.antlr.analysis.SemanticContext.NOT;

public class Comment {
	private int board_bno;
	private int cno;
	private String ccontent;
	private String cwriter;
	private Date cdate;
	private int cup;
	private int cdown;
	
	public int getBoard_bno() {
		return board_bno;
	}
	public void setBoard_bno(int board_bno) {
		this.board_bno = board_bno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getCwriter() {
		return cwriter;
	}
	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public int getCup() {
		return cup;
	}
	public void setCup(int cup) {
		this.cup = cup;
	}
	public int getCdown() {
		return cdown;
	}
	public void setCdown(int cdown) {
		this.cdown = cdown;
	}
	
	
}