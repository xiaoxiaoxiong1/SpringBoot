package org.mybatis.entity;

/**
 * @Created by Administrator on 2019/2/9.
 * @DESC
 * @DATE 09
 */
public class Student  implements Comparable {

    private String name;

    private Integer score;

    public Integer getScore() {
       return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Student student=(Student)o;
        if(student.getScore().compareTo(this.getScore())>0){
            return 1;
        }else   if(student.getScore().compareTo(this.getScore())==0){
            return 0;
        }

        return -1;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
