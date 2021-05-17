/**
 * 类型描述：能够描述职务编号、职务名称
 */
package imooc.homework2;

public class Job {
    private String jobNum;
    private String jobName;

    // 无参构造
    public Job(){}
    // 有参构造
    public Job(String jobNum, String jobName) {
        this.setJobNum(jobNum);
        this.setJobName(jobName) ;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    };

    
    


    
}
