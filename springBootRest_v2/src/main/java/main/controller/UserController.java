package main.controller;


import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/app/v1")
public class UserController {

    private final static String currentDirectory = System.getProperty("user.dir");
//    private final static String path = currentDirectory + File.separator + "answers" + File.separator; //для локальной отладки

    private final static String path = currentDirectory + File.separator +".."+ File.separator + "answers" + File.separator;
    String filePostAnswer = path+"postAnswer.txt";
    String fileGetAnswer = path+"getAnswer.txt";

//    String filePostAnswer = "C:\\D_PC_Work\\Personal_Data\\Learning\\Java\\ProjectJava\\xset\\springBootRest_v2\\postAnswer.txt";
//    String fileGetAnswer = "C:\\D_PC_Work\\Personal_Data\\Learning\\Java\\ProjectJava\\xset\\springBootRest_v2\\getAnswer.txt";
    String receiveDataPost, receiveDataGet;

    @PostConstruct
    public void init() throws IOException{
        Path filePost = Path.of(filePostAnswer);
        receiveDataPost = Files.readString(filePost);

        Path fileGet = Path.of(fileGetAnswer);
        receiveDataGet = Files.readString(fileGet);

    }

    @PostMapping (value = "/postRequest")
    public ResponseEntity<?> create(@RequestBody User user ) {

        if(user.getName().isEmpty() || user.getSurname().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String answerPost = String.format(receiveDataPost,user.getName(),user.getSurname(),user.getAge(),user.getSurname(),user.getName(),user.getAge()*2);
        return new ResponseEntity<>(answerPost, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getRequest")
    public ResponseEntity<?> getUser(@RequestParam(value="id") Integer id, @RequestParam(value = "name") String name) throws InterruptedException {
        if(id>10 && name.length()>5){
            if(id>10 && id<50){
                Thread.sleep(1000);
            } else{
                Thread.sleep(500);
            }
            String answerGet = String.format(receiveDataGet, id, name);
            return new ResponseEntity<>(answerGet, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}


