package com.example.demo.Lesson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/lessons/{id}")
    public Lesson newLesson(@PathVariable String id){
        Lesson newL=new Lesson();

        newL.setId(Long.getLong(id));
        newL.setTitle("JPA");
        return this.repository.save(newL);
    }

    @DeleteMapping("/lessons/{id}")
    public void deleteLesson(@PathVariable String id){
        repository.deleteById(Long.getLong(id));
    }

    @PatchMapping("/lessons/{id}")
    public Lesson patchLession(@PathVariable String id, @RequestBody Lesson lesson){
       lesson.setId(Long.getLong(id));
       return this.repository.save(lesson);

    }


}
