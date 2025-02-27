package com.bugra.repo;

import com.bugra.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);


}
//    private List<JobPost> jobs = new ArrayList<>();
//    public JobRepo() {
//
//        // Java Developer Job Post
//        jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java ",2,
//                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//
//    }
//    public List<JobPost> getAllJobs(){
//        return jobs;
//    }
//
//    public void addJob(JobPost job){
//        jobs.add(job);
//    }
//
//    public JobPost findJob(int postId) {
//        for(JobPost job : jobs){
//            if(job.getPostId() == postId){
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public void updateJob(JobPost job) {
//        for(JobPost jobPost1 : jobs){
//            if(jobPost1.getPostId() == job.getPostId()){
//                jobPost1.setPostProfile(job.getPostProfile());
//                jobPost1.setPostDesc(job.getPostDesc());
//                jobPost1.setPostTechStack(job.getPostTechStack());
//                jobPost1.setReqExperience(job.getReqExperience());
//            }
//        }
//
//    }
//
//    public void delete(int postID) {
//        for(JobPost jobPost : jobs){
//            if(jobPost.getPostId() == postID){
//                jobs.remove(jobPost);
//            }
//        }
//    }

