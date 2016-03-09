package com.qiezi.hermes.api.job;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-09
 */
@Entity
//@Table(name = "ganji_job_list")
public class GanjiId {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private int ganjiId;

	public GanjiId(int ganjiId) {
		this.ganjiId = ganjiId;
	}

	public GanjiId() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGanjiId() {
		return ganjiId;
	}

	public void setGanjiId(int ganjiId) {
		this.ganjiId = ganjiId;
	}
}
