package com.zhangyihao.twoyou.entity;

import java.util.Date;

public class Replay {
	private Integer id;
	private Comment comment;
	private User toReplayer;
	private User replayer;
	private String replayContent;
	private Date replayTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public User getToReplayer() {
		return toReplayer;
	}
	public void setToReplayer(User toReplayer) {
		this.toReplayer = toReplayer;
	}
	public User getReplayer() {
		return replayer;
	}
	public void setReplayer(User replayer) {
		this.replayer = replayer;
	}
	public String getReplayContent() {
		return replayContent;
	}
	public void setReplayContent(String replayContent) {
		this.replayContent = replayContent;
	}
	public Date getReplayTime() {
		return replayTime;
	}
	public void setReplayTime(Date replayTime) {
		this.replayTime = replayTime;
	}
}
