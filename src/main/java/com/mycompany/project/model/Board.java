package com.mycompany.project.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private int bhitcount;
	private Date bdate;
	private String bgenre;
	private MultipartFile bposter;
	private MultipartFile bvideo;
	private String bposteroname;
	private String bpostersname;
	private String bpostertype;
	private String bvideooname;
	private String bvideosname;
	private String bvideotype;
	private double btotalrating;
	private int bratingcount;
	
	
	
	public MultipartFile getBvideo() {
		return bvideo;
	}
	public void setBvideo(MultipartFile bvideo) {
		this.bvideo = bvideo;
	}
	public String getBvideooname() {
		return bvideooname;
	}
	public void setBvideooname(String bvideooname) {
		this.bvideooname = bvideooname;
	}
	public String getBvideosname() {
		return bvideosname;
	}
	public void setBvideosname(String bvideosname) {
		this.bvideosname = bvideosname;
	}
	public String getBvideotype() {
		return bvideotype;
	}
	public void setBvideotype(String bvideotype) {
		this.bvideotype = bvideotype;
	}
	public String getBposteroname() {
		return bposteroname;
	}
	public void setBposteroname(String bposteroname) {
		this.bposteroname = bposteroname;
	}
	public String getBpostersname() {
		return bpostersname;
	}
	public void setBpostersname(String bpostersname) {
		this.bpostersname = bpostersname;
	}
	public String getBpostertype() {
		return bpostertype;
	}
	public void setBpostertype(String bpostertype) {
		this.bpostertype = bpostertype;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public int getBhitcount() {
		return bhitcount;
	}
	public void setBhitcount(int bhitcount) {
		this.bhitcount = bhitcount;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public String getBgenre() {
		return bgenre;
	}
	public void setBgenre(String bgenre) {
		this.bgenre = bgenre;
	}
	public MultipartFile getBposter() {
		return bposter;
	}
	public void setBposter(MultipartFile bposter) {
		this.bposter = bposter;
	}
	public double getBtotalrating() {
		return btotalrating;
	}
	public void setBtotalrating(double btotalrating) {
		this.btotalrating = btotalrating;
	}
	public int getBratingcount() {
		return bratingcount;
	}
	public void setBratingcount(int bratingcount) {
		this.bratingcount = bratingcount;
	}
	
}
