package com.example.huibanbackend.controller;

import com.example.huibanbackend.entity.*;
import com.example.huibanbackend.exception.DuplicateException;
import com.example.huibanbackend.exception.NotFoundException;
import com.example.huibanbackend.mapper.ConferenceMapper;
import com.example.huibanbackend.service.AttendListService;
import com.example.huibanbackend.service.ConferenceService;
import com.example.huibanbackend.service.FollowListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Tag(name = "conference controller", description = "测试conference相关接口")
@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private FollowListService followListService;

    @Autowired
    private AttendListService attendListService;


    @GetMapping("/popularList")
    @Operation(summary = "get the top 5 followed conferences ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<ConferenceDetail>> getPopularConferences(){
        return ResponseEntity.ok(conferenceService.getPopularList());
    }
//    public ResponseEntity<List<HashMap<String, Integer>>> getPopularConferences() {
//        return ResponseEntity.ok(conferenceService.getPopularList());
//
//    }


    @GetMapping("/recentList")
    @Operation(summary = "get the 10 conferences with the latest deadlines")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<ConferenceShow>> getRecentConferences() {
        return ResponseEntity.ok(conferenceService.getRecentList());

    }


    @GetMapping("/list")
    @Operation(summary = "get all conferences")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<ConferenceShow>> getAllConferences() {
        return ResponseEntity.ok(conferenceService.getAllShow());
    }


    @GetMapping("/list/{conferenceId}")
    @Operation(summary = "get conference show information by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<ConferenceShow> getConference(@PathVariable String conferenceId) {
        try{
            ConferenceShow cs = conferenceService.getById(conferenceId);
            return ResponseEntity.ok(cs);
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @GetMapping("/list/rank/{ccfRank}")
    @Operation(summary = "get conference show information by ccf rank")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<ConferenceShow>> getConferenceByCcfRank(@PathVariable String ccfRank) {
        return ResponseEntity.ok(conferenceService.getByCCFRank(ccfRank));
    }


    @GetMapping("/list/title/{title}")
    @Operation(summary = "get conference show information by title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<ConferenceShow>> getConferenceByTitle(@PathVariable String title) {
        return ResponseEntity.ok(conferenceService.getByTitle(title));
    }


    @GetMapping("/list/sub/{sub}")
    @Operation(summary = "get conference show information by sub")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<ConferenceShow>> getConferenceBySub(@PathVariable String sub) {
        return ResponseEntity.ok(conferenceService.getBySub(sub));
    }


    @GetMapping("/list/")
    @Operation(summary = "get conference show information with the startTime between startDate and endDate")
    @Parameters({@Parameter(name = "startDate", description = "start date"), @Parameter(name = "endDate", description = "end date")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<ConferenceShow>> getByPeriod(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam @Parameter Date startDate,  @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam @Parameter Date endDate) {
        //需要测试前端json格式返回的string能不能变为date
        return ResponseEntity.ok(conferenceService.getByPeriod(startDate, endDate));
    }

    @GetMapping("/list/detail")
    @Operation(summary = "get all conferences' details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<ConferenceDetail>> getAllConferenceDetails(){
        return ResponseEntity.ok(conferenceService.getAllDetail());
    }


    @GetMapping("/list/{conferenceId}/detail")
    @Operation(summary = "get conference detail by id")
    public ResponseEntity<ConferenceDetail> getConferenceDetail(@PathVariable String conferenceId){
        try{
            ConferenceDetail cd = conferenceService.getDetailById(conferenceId);
            return ResponseEntity.ok(cd);
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PostMapping
    @Operation(summary = "add conference")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "201", description = "已创建,成功请求并创建了新的资源"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(responseCode = "409", description = "服务器在完成请求时发生冲突")
    })
    public ResponseEntity<Conference> addConference(@RequestBody Conference conference) {
         try{
             conferenceService.insert(conference);
             return ResponseEntity.status(HttpStatus.CREATED).body(conference);
         }catch (DuplicateException e){
             return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
         }
    }


    @DeleteMapping("/{conferenceId}")
    @Operation(summary = "delete conference")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "204", description = "服务器成功处理，但未返回内容"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<Void> deleteConference(@PathVariable String conferenceId) {
        try{
            conferenceService.delete(conferenceId);
            return ResponseEntity.noContent().build();
        }catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    @Operation(summary = "update conference information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<Conference> updateConference(@RequestBody Conference conference) {
        try {
            conferenceService.update(conference);
            return ResponseEntity.ok(conference);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{conferenceId}/follow/add")
    @Operation(summary = "add follow number of conference")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public ResponseEntity<Void> addFollowNum(@PathVariable String conferenceId, @RequestParam @Parameter String email){
        try{
            conferenceService.addFollowNum(conferenceId);
            FollowList ft = new FollowList(email, "conference", conferenceId);
            followListService.insertConf(ft);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{conferenceId}/follow/sub")
    @Operation(summary = "sub follow number of conference")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public ResponseEntity<Void> subFollowNum(@PathVariable String conferenceId, @RequestParam @Parameter String email){
        try{
            conferenceService.subFollowNum(conferenceId);
            followListService.deleteConf(conferenceId, email);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{conferenceId}/attend/add")
    @Operation(summary = "add attend number of conference")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public ResponseEntity<Void> addAttendNum(@PathVariable String conferenceId, @RequestParam @Parameter String email){
        try{
            conferenceService.addAttendNum(conferenceId);
            AttendList att = new AttendList(email, "conference", conferenceId);
            attendListService.insertConf(att);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{conferenceId}/attend/sub")
    @Operation(summary = "sub attend number of conference")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public ResponseEntity<Void> subAttendNum(@PathVariable String conferenceId, @RequestParam @Parameter String email){
        try{
            conferenceService.subAttendNum(conferenceId);
            attendListService.deleteConf(conferenceId, email);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }








}
