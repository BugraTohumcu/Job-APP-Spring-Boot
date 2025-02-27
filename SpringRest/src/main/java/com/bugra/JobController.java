package com.bugra;

import com.bugra.model.JobPost;
import com.bugra.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    private JobService service;

    @Autowired
    public void setService(JobService service) {
        this.service = service;
    }
    @GetMapping("jobPosts")
    public List<JobPost> viewJob(){
       return service.getAllJobs();
    }

    @GetMapping("jobPosts/{postId}")
    public JobPost getJobPost(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping("jobPosts")
    public JobPost addJobPost(@RequestBody JobPost job){
        service.addJob(job);
        return service.getJob(job.getPostId());
    }

    @PutMapping("jobPosts")
    public JobPost updateJobPost(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return  service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPosts/{postId}")
    public String deleteJobPost(@PathVariable("postId") int postID){
        service.delete(postID);
        return "Deleted";
    }

    @GetMapping("load")
    public void load(){
        service.load();
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }


}
