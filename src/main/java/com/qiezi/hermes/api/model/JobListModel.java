package com.qiezi.hermes.api.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Daniel on 3/6/16.
 */
public class JobListModel implements Serializable {

    private static final long serialVersionUID = 484754020880086195L;

    private int size;
    private List<JobTitleModel> jobList;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<JobTitleModel> getJobList() {
        return jobList;
    }

    public void setJobList(List<JobTitleModel> jobList) {
        this.jobList = jobList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JobListModel{");
        sb.append("size=").append(size);
        sb.append(", jobList=").append(jobList);
        sb.append('}');
        return sb.toString();
    }
}
